/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package net.cantaloupe.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order implements org.apache.thrift.TBase<Order, Order._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Order");

  private static final org.apache.thrift.protocol.TField OID_FIELD_DESC = new org.apache.thrift.protocol.TField("oid", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField AMOUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("amount", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new OrderStandardSchemeFactory());
    schemes.put(TupleScheme.class, new OrderTupleSchemeFactory());
  }

  public int oid; // required
  public double amount; // required
  /**
   * 
   * @see Status
   */
  public Status status; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OID((short)1, "oid"),
    AMOUNT((short)2, "amount"),
    /**
     * 
     * @see Status
     */
    STATUS((short)3, "status");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // OID
          return OID;
        case 2: // AMOUNT
          return AMOUNT;
        case 3: // STATUS
          return STATUS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __OID_ISSET_ID = 0;
  private static final int __AMOUNT_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);
  private _Fields optionals[] = {_Fields.STATUS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OID, new org.apache.thrift.meta_data.FieldMetaData("oid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AMOUNT, new org.apache.thrift.meta_data.FieldMetaData("amount", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Status.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Order.class, metaDataMap);
  }

  public Order() {
  }

  public Order(
    int oid,
    double amount)
  {
    this();
    this.oid = oid;
    setOidIsSet(true);
    this.amount = amount;
    setAmountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Order(Order other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.oid = other.oid;
    this.amount = other.amount;
    if (other.isSetStatus()) {
      this.status = other.status;
    }
  }

  public Order deepCopy() {
    return new Order(this);
  }

  @Override
  public void clear() {
    setOidIsSet(false);
    this.oid = 0;
    setAmountIsSet(false);
    this.amount = 0.0;
    this.status = null;
  }

  public int getOid() {
    return this.oid;
  }

  public Order setOid(int oid) {
    this.oid = oid;
    setOidIsSet(true);
    return this;
  }

  public void unsetOid() {
    __isset_bit_vector.clear(__OID_ISSET_ID);
  }

  /** Returns true if field oid is set (has been assigned a value) and false otherwise */
  public boolean isSetOid() {
    return __isset_bit_vector.get(__OID_ISSET_ID);
  }

  public void setOidIsSet(boolean value) {
    __isset_bit_vector.set(__OID_ISSET_ID, value);
  }

  public double getAmount() {
    return this.amount;
  }

  public Order setAmount(double amount) {
    this.amount = amount;
    setAmountIsSet(true);
    return this;
  }

  public void unsetAmount() {
    __isset_bit_vector.clear(__AMOUNT_ISSET_ID);
  }

  /** Returns true if field amount is set (has been assigned a value) and false otherwise */
  public boolean isSetAmount() {
    return __isset_bit_vector.get(__AMOUNT_ISSET_ID);
  }

  public void setAmountIsSet(boolean value) {
    __isset_bit_vector.set(__AMOUNT_ISSET_ID, value);
  }

  /**
   * 
   * @see Status
   */
  public Status getStatus() {
    return this.status;
  }

  /**
   * 
   * @see Status
   */
  public Order setStatus(Status status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case OID:
      if (value == null) {
        unsetOid();
      } else {
        setOid((Integer)value);
      }
      break;

    case AMOUNT:
      if (value == null) {
        unsetAmount();
      } else {
        setAmount((Double)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Status)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OID:
      return Integer.valueOf(getOid());

    case AMOUNT:
      return Double.valueOf(getAmount());

    case STATUS:
      return getStatus();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OID:
      return isSetOid();
    case AMOUNT:
      return isSetAmount();
    case STATUS:
      return isSetStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Order)
      return this.equals((Order)that);
    return false;
  }

  public boolean equals(Order that) {
    if (that == null)
      return false;

    boolean this_present_oid = true;
    boolean that_present_oid = true;
    if (this_present_oid || that_present_oid) {
      if (!(this_present_oid && that_present_oid))
        return false;
      if (this.oid != that.oid)
        return false;
    }

    boolean this_present_amount = true;
    boolean that_present_amount = true;
    if (this_present_amount || that_present_amount) {
      if (!(this_present_amount && that_present_amount))
        return false;
      if (this.amount != that.amount)
        return false;
    }

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Order other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Order typedOther = (Order)other;

    lastComparison = Boolean.valueOf(isSetOid()).compareTo(typedOther.isSetOid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.oid, typedOther.oid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAmount()).compareTo(typedOther.isSetAmount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAmount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.amount, typedOther.amount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(typedOther.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, typedOther.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Order(");
    boolean first = true;

    sb.append("oid:");
    sb.append(this.oid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("amount:");
    sb.append(this.amount);
    first = false;
    if (isSetStatus()) {
      if (!first) sb.append(", ");
      sb.append("status:");
      if (this.status == null) {
        sb.append("null");
      } else {
        sb.append(this.status);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'oid' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'amount' because it's a primitive and you chose the non-beans generator.
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class OrderStandardSchemeFactory implements SchemeFactory {
    public OrderStandardScheme getScheme() {
      return new OrderStandardScheme();
    }
  }

  private static class OrderStandardScheme extends StandardScheme<Order> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Order struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.oid = iprot.readI32();
              struct.setOidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // AMOUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.amount = iprot.readDouble();
              struct.setAmountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = Status.findByValue(iprot.readI32());
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetOid()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'oid' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetAmount()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'amount' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Order struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OID_FIELD_DESC);
      oprot.writeI32(struct.oid);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AMOUNT_FIELD_DESC);
      oprot.writeDouble(struct.amount);
      oprot.writeFieldEnd();
      if (struct.status != null) {
        if (struct.isSetStatus()) {
          oprot.writeFieldBegin(STATUS_FIELD_DESC);
          oprot.writeI32(struct.status.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class OrderTupleSchemeFactory implements SchemeFactory {
    public OrderTupleScheme getScheme() {
      return new OrderTupleScheme();
    }
  }

  private static class OrderTupleScheme extends TupleScheme<Order> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Order struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.oid);
      oprot.writeDouble(struct.amount);
      BitSet optionals = new BitSet();
      if (struct.isSetStatus()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetStatus()) {
        oprot.writeI32(struct.status.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Order struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.oid = iprot.readI32();
      struct.setOidIsSet(true);
      struct.amount = iprot.readDouble();
      struct.setAmountIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.status = Status.findByValue(iprot.readI32());
        struct.setStatusIsSet(true);
      }
    }
  }

}

