/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.command.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ReceivedOrder extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5852700382921220535L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ReceivedOrder\",\"namespace\":\"com.example.command.model\",\"fields\":[{\"name\":\"orderId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"customerId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"itemLabel\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"itemPrice\",\"type\":\"double\"},{\"name\":\"ts_received\",\"type\":\"long\",\"default\":0}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ReceivedOrder> ENCODER =
      new BinaryMessageEncoder<ReceivedOrder>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ReceivedOrder> DECODER =
      new BinaryMessageDecoder<ReceivedOrder>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ReceivedOrder> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ReceivedOrder> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ReceivedOrder> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ReceivedOrder>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ReceivedOrder to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ReceivedOrder from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ReceivedOrder instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ReceivedOrder fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String orderId;
   private java.lang.String customerId;
   private java.lang.String itemLabel;
   private double itemPrice;
   private long ts_received;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ReceivedOrder() {}

  /**
   * All-args constructor.
   * @param orderId The new value for orderId
   * @param customerId The new value for customerId
   * @param itemLabel The new value for itemLabel
   * @param itemPrice The new value for itemPrice
   * @param ts_received The new value for ts_received
   */
  public ReceivedOrder(java.lang.String orderId, java.lang.String customerId, java.lang.String itemLabel, java.lang.Double itemPrice, java.lang.Long ts_received) {
    this.orderId = orderId;
    this.customerId = customerId;
    this.itemLabel = itemLabel;
    this.itemPrice = itemPrice;
    this.ts_received = ts_received;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return orderId;
    case 1: return customerId;
    case 2: return itemLabel;
    case 3: return itemPrice;
    case 4: return ts_received;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: orderId = value$ != null ? value$.toString() : null; break;
    case 1: customerId = value$ != null ? value$.toString() : null; break;
    case 2: itemLabel = value$ != null ? value$.toString() : null; break;
    case 3: itemPrice = (java.lang.Double)value$; break;
    case 4: ts_received = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'orderId' field.
   * @return The value of the 'orderId' field.
   */
  public java.lang.String getOrderId() {
    return orderId;
  }


  /**
   * Sets the value of the 'orderId' field.
   * @param value the value to set.
   */
  public void setOrderId(java.lang.String value) {
    this.orderId = value;
  }

  /**
   * Gets the value of the 'customerId' field.
   * @return The value of the 'customerId' field.
   */
  public java.lang.String getCustomerId() {
    return customerId;
  }


  /**
   * Sets the value of the 'customerId' field.
   * @param value the value to set.
   */
  public void setCustomerId(java.lang.String value) {
    this.customerId = value;
  }

  /**
   * Gets the value of the 'itemLabel' field.
   * @return The value of the 'itemLabel' field.
   */
  public java.lang.String getItemLabel() {
    return itemLabel;
  }


  /**
   * Sets the value of the 'itemLabel' field.
   * @param value the value to set.
   */
  public void setItemLabel(java.lang.String value) {
    this.itemLabel = value;
  }

  /**
   * Gets the value of the 'itemPrice' field.
   * @return The value of the 'itemPrice' field.
   */
  public double getItemPrice() {
    return itemPrice;
  }


  /**
   * Sets the value of the 'itemPrice' field.
   * @param value the value to set.
   */
  public void setItemPrice(double value) {
    this.itemPrice = value;
  }

  /**
   * Gets the value of the 'ts_received' field.
   * @return The value of the 'ts_received' field.
   */
  public long getTsReceived() {
    return ts_received;
  }


  /**
   * Sets the value of the 'ts_received' field.
   * @param value the value to set.
   */
  public void setTsReceived(long value) {
    this.ts_received = value;
  }

  /**
   * Creates a new ReceivedOrder RecordBuilder.
   * @return A new ReceivedOrder RecordBuilder
   */
  public static com.example.command.model.ReceivedOrder.Builder newBuilder() {
    return new com.example.command.model.ReceivedOrder.Builder();
  }

  /**
   * Creates a new ReceivedOrder RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ReceivedOrder RecordBuilder
   */
  public static com.example.command.model.ReceivedOrder.Builder newBuilder(com.example.command.model.ReceivedOrder.Builder other) {
    if (other == null) {
      return new com.example.command.model.ReceivedOrder.Builder();
    } else {
      return new com.example.command.model.ReceivedOrder.Builder(other);
    }
  }

  /**
   * Creates a new ReceivedOrder RecordBuilder by copying an existing ReceivedOrder instance.
   * @param other The existing instance to copy.
   * @return A new ReceivedOrder RecordBuilder
   */
  public static com.example.command.model.ReceivedOrder.Builder newBuilder(com.example.command.model.ReceivedOrder other) {
    if (other == null) {
      return new com.example.command.model.ReceivedOrder.Builder();
    } else {
      return new com.example.command.model.ReceivedOrder.Builder(other);
    }
  }

  /**
   * RecordBuilder for ReceivedOrder instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ReceivedOrder>
    implements org.apache.avro.data.RecordBuilder<ReceivedOrder> {

    private java.lang.String orderId;
    private java.lang.String customerId;
    private java.lang.String itemLabel;
    private double itemPrice;
    private long ts_received;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.command.model.ReceivedOrder.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.customerId)) {
        this.customerId = data().deepCopy(fields()[1].schema(), other.customerId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.itemLabel)) {
        this.itemLabel = data().deepCopy(fields()[2].schema(), other.itemLabel);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.itemPrice)) {
        this.itemPrice = data().deepCopy(fields()[3].schema(), other.itemPrice);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.ts_received)) {
        this.ts_received = data().deepCopy(fields()[4].schema(), other.ts_received);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing ReceivedOrder instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.command.model.ReceivedOrder other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customerId)) {
        this.customerId = data().deepCopy(fields()[1].schema(), other.customerId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.itemLabel)) {
        this.itemLabel = data().deepCopy(fields()[2].schema(), other.itemLabel);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.itemPrice)) {
        this.itemPrice = data().deepCopy(fields()[3].schema(), other.itemPrice);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ts_received)) {
        this.ts_received = data().deepCopy(fields()[4].schema(), other.ts_received);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'orderId' field.
      * @return The value.
      */
    public java.lang.String getOrderId() {
      return orderId;
    }


    /**
      * Sets the value of the 'orderId' field.
      * @param value The value of 'orderId'.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder setOrderId(java.lang.String value) {
      validate(fields()[0], value);
      this.orderId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'orderId' field has been set.
      * @return True if the 'orderId' field has been set, false otherwise.
      */
    public boolean hasOrderId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'orderId' field.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder clearOrderId() {
      orderId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerId' field.
      * @return The value.
      */
    public java.lang.String getCustomerId() {
      return customerId;
    }


    /**
      * Sets the value of the 'customerId' field.
      * @param value The value of 'customerId'.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder setCustomerId(java.lang.String value) {
      validate(fields()[1], value);
      this.customerId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'customerId' field has been set.
      * @return True if the 'customerId' field has been set, false otherwise.
      */
    public boolean hasCustomerId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'customerId' field.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder clearCustomerId() {
      customerId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'itemLabel' field.
      * @return The value.
      */
    public java.lang.String getItemLabel() {
      return itemLabel;
    }


    /**
      * Sets the value of the 'itemLabel' field.
      * @param value The value of 'itemLabel'.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder setItemLabel(java.lang.String value) {
      validate(fields()[2], value);
      this.itemLabel = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'itemLabel' field has been set.
      * @return True if the 'itemLabel' field has been set, false otherwise.
      */
    public boolean hasItemLabel() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'itemLabel' field.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder clearItemLabel() {
      itemLabel = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'itemPrice' field.
      * @return The value.
      */
    public double getItemPrice() {
      return itemPrice;
    }


    /**
      * Sets the value of the 'itemPrice' field.
      * @param value The value of 'itemPrice'.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder setItemPrice(double value) {
      validate(fields()[3], value);
      this.itemPrice = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'itemPrice' field has been set.
      * @return True if the 'itemPrice' field has been set, false otherwise.
      */
    public boolean hasItemPrice() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'itemPrice' field.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder clearItemPrice() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ts_received' field.
      * @return The value.
      */
    public long getTsReceived() {
      return ts_received;
    }


    /**
      * Sets the value of the 'ts_received' field.
      * @param value The value of 'ts_received'.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder setTsReceived(long value) {
      validate(fields()[4], value);
      this.ts_received = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ts_received' field has been set.
      * @return True if the 'ts_received' field has been set, false otherwise.
      */
    public boolean hasTsReceived() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ts_received' field.
      * @return This builder.
      */
    public com.example.command.model.ReceivedOrder.Builder clearTsReceived() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReceivedOrder build() {
      try {
        ReceivedOrder record = new ReceivedOrder();
        record.orderId = fieldSetFlags()[0] ? this.orderId : (java.lang.String) defaultValue(fields()[0]);
        record.customerId = fieldSetFlags()[1] ? this.customerId : (java.lang.String) defaultValue(fields()[1]);
        record.itemLabel = fieldSetFlags()[2] ? this.itemLabel : (java.lang.String) defaultValue(fields()[2]);
        record.itemPrice = fieldSetFlags()[3] ? this.itemPrice : (java.lang.Double) defaultValue(fields()[3]);
        record.ts_received = fieldSetFlags()[4] ? this.ts_received : (java.lang.Long) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ReceivedOrder>
    WRITER$ = (org.apache.avro.io.DatumWriter<ReceivedOrder>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ReceivedOrder>
    READER$ = (org.apache.avro.io.DatumReader<ReceivedOrder>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.orderId);

    out.writeString(this.customerId);

    out.writeString(this.itemLabel);

    out.writeDouble(this.itemPrice);

    out.writeLong(this.ts_received);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.orderId = in.readString();

      this.customerId = in.readString();

      this.itemLabel = in.readString();

      this.itemPrice = in.readDouble();

      this.ts_received = in.readLong();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.orderId = in.readString();
          break;

        case 1:
          this.customerId = in.readString();
          break;

        case 2:
          this.itemLabel = in.readString();
          break;

        case 3:
          this.itemPrice = in.readDouble();
          break;

        case 4:
          this.ts_received = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










