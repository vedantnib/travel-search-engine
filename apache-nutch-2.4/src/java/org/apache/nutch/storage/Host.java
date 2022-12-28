/**
 *Licensed to the Apache Software Foundation (ASF) under one
 *or more contributor license agreements.  See the NOTICE file
 *distributed with this work for additional information
 *regarding copyright ownership.  The ASF licenses this file
 *to you under the Apache License, Version 2.0 (the"
 *License"); you may not use this file except in compliance
 *with the License.  You may obtain a copy of the License at
 *
  * http://www.apache.org/licenses/LICENSE-2.0
 * 
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */
package org.apache.nutch.storage;  

import org.apache.avro.util.Utf8;
import org.apache.nutch.util.Bytes;

/** Host represents a store of webpages or other data which resides on a server or other computer so that it can be accessed over the Internet */
public class Host extends org.apache.gora.persistency.impl.PersistentBase implements org.apache.avro.specific.SpecificRecord, org.apache.gora.persistency.Persistent {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Host\",\"namespace\":\"org.apache.nutch.storage\",\"doc\":\"Host represents a store of webpages or other data which resides on a server or other computer so that it can be accessed over the Internet\",\"fields\":[{\"name\":\"metadata\",\"type\":{\"type\":\"map\",\"values\":[\"null\",\"bytes\"]},\"doc\":\"A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc\",\"default\":{}},{\"name\":\"outlinks\",\"type\":{\"type\":\"map\",\"values\":[\"null\",\"string\"]},\"doc\":\"Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics\",\"default\":{}},{\"name\":\"inlinks\",\"type\":{\"type\":\"map\",\"values\":[\"null\",\"string\"]},\"doc\":\"Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics\",\"default\":{}}]}");
  private static final long serialVersionUID = -4229257204185827136L;
  /** Enum containing all data bean's fields. */
  public static enum Field {
    METADATA(0, "metadata"),
    OUTLINKS(1, "outlinks"),
    INLINKS(2, "inlinks"),
    ;
    /**
     * Field's index.
     */
    private int index;

    /**
     * Field's name.
     */
    private String name;

    /**
     * Field's constructor
     * @param index field's index.
     * @param name field's name.
     */
    Field(int index, String name) {this.index=index;this.name=name;}

    /**
     * Gets field's index.
     * @return int field's index.
     */
    public int getIndex() {return index;}

    /**
     * Gets field's name.
     * @return String field's name.
     */
    public String getName() {return name;}

    /**
     * Gets field's attributes to string.
     * @return String field's attributes to string.
     */
    public String toString() {return name;}
  };

  public static final String[] _ALL_FIELDS = {
  "metadata",
  "outlinks",
  "inlinks",
  };

  /**
   * Gets the total field count.
   * @return int field count
   */
  public int getFieldsCount() {
    return Host._ALL_FIELDS.length;
  }

  /** A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc */
  private java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> metadata;
  /** Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics */
  private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> outlinks;
  /** Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics */
  private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> inlinks;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return metadata;
    case 1: return outlinks;
    case 2: return inlinks;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value) {
    switch (field$) {
    case 0: metadata = (java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer>)((value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyMapWrapper((java.util.Map)value)); break;
    case 1: outlinks = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)((value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyMapWrapper((java.util.Map)value)); break;
    case 2: inlinks = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)((value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyMapWrapper((java.util.Map)value)); break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'metadata' field.
   * A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc   */
  public java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> getMetadata() {
    return metadata;
  }

  /**
   * Sets the value of the 'metadata' field.
   * A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc   * @param value the value to set.
   */
  public void setMetadata(java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> value) {
    this.metadata = (value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyMapWrapper(value);
    setDirty(0);
  }
  
  /**
   * Checks the dirty status of the 'metadata' field. A field is dirty if it represents a change that has not yet been written to the database.
   * A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc   * @param value the value to set.
   */
  public boolean isMetadataDirty() {
    return isDirty(0);
  }

  /**
   * Gets the value of the 'outlinks' field.
   * Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getOutlinks() {
    return outlinks;
  }

  /**
   * Sets the value of the 'outlinks' field.
   * Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics   * @param value the value to set.
   */
  public void setOutlinks(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.outlinks = (value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyMapWrapper(value);
    setDirty(1);
  }
  
  /**
   * Checks the dirty status of the 'outlinks' field. A field is dirty if it represents a change that has not yet been written to the database.
   * Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics   * @param value the value to set.
   */
  public boolean isOutlinksDirty() {
    return isDirty(1);
  }

  /**
   * Gets the value of the 'inlinks' field.
   * Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getInlinks() {
    return inlinks;
  }

  /**
   * Sets the value of the 'inlinks' field.
   * Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics   * @param value the value to set.
   */
  public void setInlinks(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.inlinks = (value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyMapWrapper(value);
    setDirty(2);
  }
  
  /**
   * Checks the dirty status of the 'inlinks' field. A field is dirty if it represents a change that has not yet been written to the database.
   * Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics   * @param value the value to set.
   */
  public boolean isInlinksDirty() {
    return isDirty(2);
  }

  /** Creates a new Host RecordBuilder */
  public static org.apache.nutch.storage.Host.Builder newBuilder() {
    return new org.apache.nutch.storage.Host.Builder();
  }
  
  /** Creates a new Host RecordBuilder by copying an existing Builder */
  public static org.apache.nutch.storage.Host.Builder newBuilder(org.apache.nutch.storage.Host.Builder other) {
    return new org.apache.nutch.storage.Host.Builder(other);
  }
  
  /** Creates a new Host RecordBuilder by copying an existing Host instance */
  public static org.apache.nutch.storage.Host.Builder newBuilder(org.apache.nutch.storage.Host other) {
    return new org.apache.nutch.storage.Host.Builder(other);
  }
  
  private static java.nio.ByteBuffer deepCopyToReadOnlyBuffer(
      java.nio.ByteBuffer input) {
    java.nio.ByteBuffer copy = java.nio.ByteBuffer.allocate(input.capacity());
    int position = input.position();
    input.reset();
    int mark = input.position();
    int limit = input.limit();
    input.rewind();
    input.limit(input.capacity());
    copy.put(input);
    input.rewind();
    copy.rewind();
    input.position(mark);
    input.mark();
    copy.position(mark);
    copy.mark();
    input.position(position);
    copy.position(position);
    input.limit(limit);
    copy.limit(limit);
    return copy.asReadOnlyBuffer();
  }
  
  /**
   * RecordBuilder for Host instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Host>
    implements org.apache.avro.data.RecordBuilder<Host> {

    private java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> metadata;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> outlinks;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> inlinks;

    /** Creates a new Builder */
    private Builder() {
      super(org.apache.nutch.storage.Host.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.apache.nutch.storage.Host.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing Host instance */
    private Builder(org.apache.nutch.storage.Host other) {
            super(org.apache.nutch.storage.Host.SCHEMA$);
      if (isValidValue(fields()[0], other.metadata)) {
        this.metadata = (java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer>) data().deepCopy(fields()[0].schema(), other.metadata);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.outlinks)) {
        this.outlinks = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) data().deepCopy(fields()[1].schema(), other.outlinks);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.inlinks)) {
        this.inlinks = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) data().deepCopy(fields()[2].schema(), other.inlinks);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'metadata' field */
    public java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> getMetadata() {
      return metadata;
    }
    
    /** Sets the value of the 'metadata' field */
    public org.apache.nutch.storage.Host.Builder setMetadata(java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> value) {
      validate(fields()[0], value);
      this.metadata = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'metadata' field has been set */
    public boolean hasMetadata() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'metadata' field */
    public org.apache.nutch.storage.Host.Builder clearMetadata() {
      metadata = null;
      fieldSetFlags()[0] = false;
      return this;
    }
    
    /** Gets the value of the 'outlinks' field */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getOutlinks() {
      return outlinks;
    }
    
    /** Sets the value of the 'outlinks' field */
    public org.apache.nutch.storage.Host.Builder setOutlinks(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[1], value);
      this.outlinks = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'outlinks' field has been set */
    public boolean hasOutlinks() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'outlinks' field */
    public org.apache.nutch.storage.Host.Builder clearOutlinks() {
      outlinks = null;
      fieldSetFlags()[1] = false;
      return this;
    }
    
    /** Gets the value of the 'inlinks' field */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getInlinks() {
      return inlinks;
    }
    
    /** Sets the value of the 'inlinks' field */
    public org.apache.nutch.storage.Host.Builder setInlinks(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[2], value);
      this.inlinks = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'inlinks' field has been set */
    public boolean hasInlinks() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'inlinks' field */
    public org.apache.nutch.storage.Host.Builder clearInlinks() {
      inlinks = null;
      fieldSetFlags()[2] = false;
      return this;
    }
    
    @Override
    public Host build() {
      try {
        Host record = new Host();
        record.metadata = fieldSetFlags()[0] ? this.metadata : (java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer>) new org.apache.gora.persistency.impl.DirtyMapWrapper((java.util.Map)defaultValue(fields()[0]));
        record.outlinks = fieldSetFlags()[1] ? this.outlinks : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) new org.apache.gora.persistency.impl.DirtyMapWrapper((java.util.Map)defaultValue(fields()[1]));
        record.inlinks = fieldSetFlags()[2] ? this.inlinks : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) new org.apache.gora.persistency.impl.DirtyMapWrapper((java.util.Map)defaultValue(fields()[2]));
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
  
  public Host.Tombstone getTombstone(){
  	return TOMBSTONE;
  }

  public Host newInstance(){
    return newBuilder().build();
  }

// TODO NUTCH-1709 Generated classes o.a.n.storage.Host and
  // o.a.n.storage.ProtocolStatus contain methods not defined in source .avsc
  public boolean contains(String key) {
    return metadata.containsKey(new Utf8(key));
  }

  // TODO NUTCH-1709 Generated classes o.a.n.storage.Host and
  // o.a.n.storage.ProtocolStatus contain methods not defined in source .avsc
  public String getValue(String key, String defaultValue) {
    if (!contains(key))
      return defaultValue;
    return Bytes.toString(metadata.get(new Utf8(key)));
  }

  // TODO NUTCH-1709 Generated classes o.a.n.storage.Host and
  // o.a.n.storage.ProtocolStatus contain methods not defined in source .avsc
  public int getInt(String key, int defaultValue) {
    if (!contains(key))
      return defaultValue;
    return Integer.parseInt(getValue(key, null));
  }

  // TODO NUTCH-1709 Generated classes o.a.n.storage.Host and
  // o.a.n.storage.ProtocolStatus contain methods not defined in source .avsc
  public long getLong(String key, long defaultValue) {
    if (!contains(key))
      return defaultValue;
    return Long.parseLong(getValue(key, null));
  }

  private static final Tombstone TOMBSTONE = new Tombstone();
  
  public static final class Tombstone extends Host implements org.apache.gora.persistency.Tombstone {
  
      private Tombstone() { }
  
	  		  /**
	   * Gets the value of the 'metadata' field.
	   * A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc	   */
	  public java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> getMetadata() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the 'metadata' field.
	   * A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc	   * @param value the value to set.
	   */
	  public void setMetadata(java.util.Map<java.lang.CharSequence,java.nio.ByteBuffer> value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the 'metadata' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * A multivalued metadata container used for storing a wide variety of host metadata such as structured web server characterists etc	   * @param value the value to set.
	   */
	  public boolean isMetadataDirty() {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the 'outlinks' field.
	   * Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics	   */
	  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getOutlinks() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the 'outlinks' field.
	   * Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics	   * @param value the value to set.
	   */
	  public void setOutlinks(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the 'outlinks' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * Hyperlinks which direct outside of the current host domain these can used in a histogram style manner to generate host statistics	   * @param value the value to set.
	   */
	  public boolean isOutlinksDirty() {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the 'inlinks' field.
	   * Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics	   */
	  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getInlinks() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the 'inlinks' field.
	   * Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics	   * @param value the value to set.
	   */
	  public void setInlinks(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the 'inlinks' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * Hyperlinks which link to pages within the current host domain these can used in a histogram style manner to generate host statistics	   * @param value the value to set.
	   */
	  public boolean isInlinksDirty() {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
		  
  }

  private static final org.apache.avro.io.DatumWriter
            DATUM_WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);
  private static final org.apache.avro.io.DatumReader
            DATUM_READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  /**
   * Writes AVRO data bean to output stream in the form of AVRO Binary encoding format. This will transform
   * AVRO data bean from its Java object form to it s serializable form.
   *
   * @param out java.io.ObjectOutput output stream to write data bean in serializable form
   */
  @Override
  public void writeExternal(java.io.ObjectOutput out)
          throws java.io.IOException {
    out.write(super.getDirtyBytes().array());
    DATUM_WRITER$.write(this, org.apache.avro.io.EncoderFactory.get()
            .directBinaryEncoder((java.io.OutputStream) out,
                    null));
  }

  /**
   * Reads AVRO data bean from input stream in it s AVRO Binary encoding format to Java object format.
   * This will transform AVRO data bean from it s serializable form to deserialized Java object form.
   *
   * @param in java.io.ObjectOutput input stream to read data bean in serializable form
   */
  @Override
  public void readExternal(java.io.ObjectInput in)
          throws java.io.IOException {
    byte[] __g__dirty = new byte[getFieldsCount()];
    in.read(__g__dirty);
    super.setDirtyBytes(java.nio.ByteBuffer.wrap(__g__dirty));
    DATUM_READER$.read(this, org.apache.avro.io.DecoderFactory.get()
            .directBinaryDecoder((java.io.InputStream) in,
                    null));
  }
  
}

