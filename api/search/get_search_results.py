from urllib import response
import flask
from flask_cors import CORS
from flask import request, jsonify
import requests
import re
import json
from query_expansion.Association_Cluster import association_main
from query_expansion.Metric_Clusters import metric_cluster_main
from spellchecker import SpellChecker

spell = SpellChecker()
app = flask.Flask(__name__)
CORS(app)
app.config["DEBUG"] = True
url = 'http://localhost:8983/solr/travelop/query'

@app.route('/', methods = ['GET'])
def get_search_results():
    if 'query' in request.args and 'type' in request.args:
        query = str(request.args['query'])
        query_type = str(request.args['type'])
        results_frequency = 30
        #payload = {"q": query, "df": "text", "row": results_frequency}
        payload = {"q": query, "df": "text", "row": results_frequency}
        search_results = get_query_search_results(payload)
        search_results_json = search_results.json()
        sanitized_results = sanitize_results(search_results_json['response']['docs'], query)
        if query_type == "page_rank":
            response = sanitized_results
        elif query_type == "hits":
            response = sort_wrt_hits(sanitized_results)
        elif "clustering" in query_type:
            response = get_clustering_results(sanitized_results, query_type)
        elif query_type == "association_qe":
            query = spell.correction(query)
            expanded_query = association_main(query, search_results_json['response']['docs'])
            temp = expanded_query.split()
            nq = '\ '.join(temp)
            new_payload = {"q": expanded_query, "df": "text", "row": results_frequency}
            new_search_results = get_query_search_results(new_payload)
            print(expanded_query)
            new_search_results_json = new_search_results.json()
            new_sanitized_results = sanitize_results(new_search_results_json['response']['docs'], expanded_query)
            response = new_sanitized_results
        elif query_type == "metric_qe":
            query = spell.correction(query)
            expanded_query = metric_cluster_main(query, search_results_json['response']['docs'])
            new_payload = {"q": expanded_query, "df": "text", "row": results_frequency}
            new_search_results = get_query_search_results(new_payload)
            print(expanded_query)
            new_search_results_json = new_search_results.json()
            new_sanitized_results = sanitize_results(new_search_results_json['response']['docs'], expanded_query)
            response = new_sanitized_results
        elif query_type == "scalar_qe":
            query = spell.correction(query)
            expanded_query = association_main(query, search_results_json['response']['docs'])
            new_payload = {"q": expanded_query, "df": "text", "row": results_frequency}
            new_search_results = get_query_search_results(new_payload)
            print(expanded_query)
            new_search_results_json = new_search_results.json()
            new_sanitized_results = sanitize_results(new_search_results_json['response']['docs'], expanded_query)
            response = new_sanitized_results
        return jsonify(response)
        

def get_query_search_results(payload):
    search_results = requests.get(url, params=payload)
    return search_results

def sanitize_results(search_results, query):
    results_filtered = []
    rank = 0
    for result in search_results:
        title = ""
        url = ""
        content = ""
        rank +=1
        if 'title' in result:
            title = result['title']
        if 'url' in result:
            url = result['url']
        if 'content' in result:
            content = result['content']
            meta_info = content[:200]
            meta_info = meta_info.replace("\n", " ")
            meta_info = " ".join(re.findall("[a-zA-Z]+", meta_info))
        hashmap = {
            "title": title,
            "url": url,
            "meta_info": meta_info,
            "rank": rank,
            "query": query
        }
        results_filtered.append(hashmap)

    return results_filtered

# def sanitize_results(search_results):
#     results_filtered = []
#     rank = 0
#     for result in search_results:
#         title = ""
#         url = ""
#         content = ""
#         rank +=1
#         if 'title' in result:
#             title = result['title']
#         if 'url' in result:
#             url = result['url']
#         if 'content' in result:
#             content = result['content']
#             meta_info = content[:200]
#             meta_info = meta_info.replace("\n", " ")
#             meta_info = " ".join(re.findall("[a-zA-Z]+", meta_info))
#         hashmap = {
#             "title": title,
#             "url": url,
#             "meta_info": meta_info,
#             "rank": rank,
#         }
#         results_filtered.append(hashmap)

#     return results_filtered

def sort_wrt_hits(clust_inp):
    authority_score_file = open("hits/authority_score_1", 'r').read()
    authority_score_dict = json.loads(authority_score_file)

    clust_inp = sorted(clust_inp, key=lambda x: authority_score_dict.get(x['url'], 0.0), reverse=True)
    return clust_inp

def get_clustering_results(clust_inp, param_type):
    if param_type == "flat_clustering":
        f = open('clustering_f.txt')
        lines = f.readlines()
        f.close()
    elif param_type == "hierarchical_clustering":
        f = open('clustering_h8.txt')
        lines = f.readlines()
        f.close()

    cluster_map = {}
    for line in lines:
        line_split = line.split(",")
        if line_split[1] == "":
            line_split[1] = "99"
        cluster_map.update({line_split[0]: line_split[1]})

    for curr_resp in clust_inp:
        curr_url = curr_resp["url"]
        curr_cluster = cluster_map.get(curr_url, "99")
        curr_resp.update({"cluster": curr_cluster})
        curr_resp.update({"done": "False"})

    clust_resp = []
    curr_rank = 1
    for curr_resp in clust_inp:
        if curr_resp["done"] == "False":
            curr_cluster = curr_resp["cluster"]
            curr_resp.update({"done": "True"})
            curr_resp.update({"rank": str(curr_rank)})
            curr_rank += 1
            clust_resp.append({"title": curr_resp["title"], "url": curr_resp["url"],
                               "meta_info": curr_resp["meta_info"], "rank": curr_resp["rank"]})
            for remaining_resp in clust_inp:
                if remaining_resp["done"] == "False":
                    if remaining_resp["cluster"] == curr_cluster:
                        remaining_resp.update({"done": "True"})
                        remaining_resp.update({"rank": str(curr_rank)})
                        curr_rank += 1
                        clust_resp.append({"title": remaining_resp["title"], "url": remaining_resp["url"],
                                           "meta_info": remaining_resp["meta_info"], "rank": remaining_resp["rank"]})

    return clust_resp