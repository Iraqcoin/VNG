/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package hello.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-5-16")
public class Location implements org.apache.thrift.TBase<Location, Location._Fields>, java.io.Serializable, Cloneable, Comparable<Location> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Location");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DEMO_FIELD_DESC = new org.apache.thrift.protocol.TField("demo", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField LO_FIELD_DESC = new org.apache.thrift.protocol.TField("lo", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LocationStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LocationTupleSchemeFactory());
  }

  public int id; // required
  public String name; // required
  public Demo demo; // required
  public Location lo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    NAME((short)2, "name"),
    DEMO((short)3, "demo"),
    LO((short)4, "lo");

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
        case 1: // ID
          return ID;
        case 2: // NAME
          return NAME;
        case 3: // DEMO
          return DEMO;
        case 4: // LO
          return LO;
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
  private static final int __ID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEMO, new org.apache.thrift.meta_data.FieldMetaData("demo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "Demo")));
    tmpMap.put(_Fields.LO, new org.apache.thrift.meta_data.FieldMetaData("lo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "Location")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Location.class, metaDataMap);
  }

  public Location() {
  }

  public Location(
    int id,
    String name,
    Demo demo,
    Location lo)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.name = name;
    this.demo = demo;
    this.lo = lo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Location(Location other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetDemo()) {
      this.demo = other.demo;
    }
    if (other.isSetLo()) {
      this.lo = other.lo;
    }
  }

  public Location deepCopy() {
    return new Location(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.name = null;
    this.demo = null;
    this.lo = null;
  }

  public int getId() {
    return this.id;
  }

  public Location setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public String getName() {
    return this.name;
  }

  public Location setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public Demo getDemo() {
    return this.demo;
  }

  public Location setDemo(Demo demo) {
    this.demo = demo;
    return this;
  }

  public void unsetDemo() {
    this.demo = null;
  }

  /** Returns true if field demo is set (has been assigned a value) and false otherwise */
  public boolean isSetDemo() {
    return this.demo != null;
  }

  public void setDemoIsSet(boolean value) {
    if (!value) {
      this.demo = null;
    }
  }

  public Location getLo() {
    return this.lo;
  }

  public Location setLo(Location lo) {
    this.lo = lo;
    return this;
  }

  public void unsetLo() {
    this.lo = null;
  }

  /** Returns true if field lo is set (has been assigned a value) and false otherwise */
  public boolean isSetLo() {
    return this.lo != null;
  }

  public void setLoIsSet(boolean value) {
    if (!value) {
      this.lo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case DEMO:
      if (value == null) {
        unsetDemo();
      } else {
        setDemo((Demo)value);
      }
      break;

    case LO:
      if (value == null) {
        unsetLo();
      } else {
        setLo((Location)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return Integer.valueOf(getId());

    case NAME:
      return getName();

    case DEMO:
      return getDemo();

    case LO:
      return getLo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case NAME:
      return isSetName();
    case DEMO:
      return isSetDemo();
    case LO:
      return isSetLo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Location)
      return this.equals((Location)that);
    return false;
  }

  public boolean equals(Location that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_demo = true && this.isSetDemo();
    boolean that_present_demo = true && that.isSetDemo();
    if (this_present_demo || that_present_demo) {
      if (!(this_present_demo && that_present_demo))
        return false;
      if (!this.demo.equals(that.demo))
        return false;
    }

    boolean this_present_lo = true && this.isSetLo();
    boolean that_present_lo = true && that.isSetLo();
    if (this_present_lo || that_present_lo) {
      if (!(this_present_lo && that_present_lo))
        return false;
      if (!this.lo.equals(that.lo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true;
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_demo = true && (isSetDemo());
    list.add(present_demo);
    if (present_demo)
      list.add(demo);

    boolean present_lo = true && (isSetLo());
    list.add(present_lo);
    if (present_lo)
      list.add(lo);

    return list.hashCode();
  }

  @Override
  public int compareTo(Location other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDemo()).compareTo(other.isSetDemo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDemo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.demo, other.demo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLo()).compareTo(other.isSetLo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lo, other.lo);
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
    StringBuilder sb = new StringBuilder("Location(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("demo:");
    if (this.demo == null) {
      sb.append("null");
    } else {
      sb.append(this.demo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lo:");
    if (this.lo == null) {
      sb.append("null");
    } else {
      sb.append(this.lo);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'id' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
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
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LocationStandardSchemeFactory implements SchemeFactory {
    public LocationStandardScheme getScheme() {
      return new LocationStandardScheme();
    }
  }

  private static class LocationStandardScheme extends StandardScheme<Location> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Location struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEMO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.demo = new Demo();
              struct.demo.read(iprot);
              struct.setDemoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.lo = new Location();
              struct.lo.read(iprot);
              struct.setLoIsSet(true);
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
      if (!struct.isSetId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Location struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.demo != null) {
        oprot.writeFieldBegin(DEMO_FIELD_DESC);
        struct.demo.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.lo != null) {
        oprot.writeFieldBegin(LO_FIELD_DESC);
        struct.lo.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LocationTupleSchemeFactory implements SchemeFactory {
    public LocationTupleScheme getScheme() {
      return new LocationTupleScheme();
    }
  }

  private static class LocationTupleScheme extends TupleScheme<Location> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Location struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.id);
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetDemo()) {
        optionals.set(1);
      }
      if (struct.isSetLo()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetDemo()) {
        struct.demo.write(oprot);
      }
      if (struct.isSetLo()) {
        struct.lo.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Location struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.id = iprot.readI32();
      struct.setIdIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.demo = new Demo();
        struct.demo.read(iprot);
        struct.setDemoIsSet(true);
      }
      if (incoming.get(2)) {
        struct.lo = new Location();
        struct.lo.read(iprot);
        struct.setLoIsSet(true);
      }
    }
  }

}

