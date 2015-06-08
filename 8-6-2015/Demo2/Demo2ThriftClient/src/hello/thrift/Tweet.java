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
public class Tweet implements org.apache.thrift.TBase<Tweet, Tweet._Fields>, java.io.Serializable, Cloneable, Comparable<Tweet> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Tweet");

  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField LOC_FIELD_DESC = new org.apache.thrift.protocol.TField("loc", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField TWEET_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("tweetType", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TweetStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TweetTupleSchemeFactory());
  }

  public int userId; // required
  public Location loc; // optional
  /**
   * 
   * @see TweetType
   */
  public TweetType tweetType; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_ID((short)1, "userId"),
    LOC((short)4, "loc"),
    /**
     * 
     * @see TweetType
     */
    TWEET_TYPE((short)5, "tweetType");

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
        case 1: // USER_ID
          return USER_ID;
        case 4: // LOC
          return LOC;
        case 5: // TWEET_TYPE
          return TWEET_TYPE;
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
  private static final int __USERID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.LOC,_Fields.TWEET_TYPE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LOC, new org.apache.thrift.meta_data.FieldMetaData("loc", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Location.class)));
    tmpMap.put(_Fields.TWEET_TYPE, new org.apache.thrift.meta_data.FieldMetaData("tweetType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TweetType.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Tweet.class, metaDataMap);
  }

  public Tweet() {
    this.tweetType = hello.thrift.TweetType.TWEET;

  }

  public Tweet(
    int userId)
  {
    this();
    this.userId = userId;
    setUserIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Tweet(Tweet other) {
    __isset_bitfield = other.__isset_bitfield;
    this.userId = other.userId;
    if (other.isSetLoc()) {
      this.loc = new Location(other.loc);
    }
    if (other.isSetTweetType()) {
      this.tweetType = other.tweetType;
    }
  }

  public Tweet deepCopy() {
    return new Tweet(this);
  }

  @Override
  public void clear() {
    setUserIdIsSet(false);
    this.userId = 0;
    this.loc = null;
    this.tweetType = hello.thrift.TweetType.TWEET;

  }

  public int getUserId() {
    return this.userId;
  }

  public Tweet setUserId(int userId) {
    this.userId = userId;
    setUserIdIsSet(true);
    return this;
  }

  public void unsetUserId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUserIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public Location getLoc() {
    return this.loc;
  }

  public Tweet setLoc(Location loc) {
    this.loc = loc;
    return this;
  }

  public void unsetLoc() {
    this.loc = null;
  }

  /** Returns true if field loc is set (has been assigned a value) and false otherwise */
  public boolean isSetLoc() {
    return this.loc != null;
  }

  public void setLocIsSet(boolean value) {
    if (!value) {
      this.loc = null;
    }
  }

  /**
   * 
   * @see TweetType
   */
  public TweetType getTweetType() {
    return this.tweetType;
  }

  /**
   * 
   * @see TweetType
   */
  public Tweet setTweetType(TweetType tweetType) {
    this.tweetType = tweetType;
    return this;
  }

  public void unsetTweetType() {
    this.tweetType = null;
  }

  /** Returns true if field tweetType is set (has been assigned a value) and false otherwise */
  public boolean isSetTweetType() {
    return this.tweetType != null;
  }

  public void setTweetTypeIsSet(boolean value) {
    if (!value) {
      this.tweetType = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
      }
      break;

    case LOC:
      if (value == null) {
        unsetLoc();
      } else {
        setLoc((Location)value);
      }
      break;

    case TWEET_TYPE:
      if (value == null) {
        unsetTweetType();
      } else {
        setTweetType((TweetType)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_ID:
      return Integer.valueOf(getUserId());

    case LOC:
      return getLoc();

    case TWEET_TYPE:
      return getTweetType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_ID:
      return isSetUserId();
    case LOC:
      return isSetLoc();
    case TWEET_TYPE:
      return isSetTweetType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Tweet)
      return this.equals((Tweet)that);
    return false;
  }

  public boolean equals(Tweet that) {
    if (that == null)
      return false;

    boolean this_present_userId = true;
    boolean that_present_userId = true;
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    boolean this_present_loc = true && this.isSetLoc();
    boolean that_present_loc = true && that.isSetLoc();
    if (this_present_loc || that_present_loc) {
      if (!(this_present_loc && that_present_loc))
        return false;
      if (!this.loc.equals(that.loc))
        return false;
    }

    boolean this_present_tweetType = true && this.isSetTweetType();
    boolean that_present_tweetType = true && that.isSetTweetType();
    if (this_present_tweetType || that_present_tweetType) {
      if (!(this_present_tweetType && that_present_tweetType))
        return false;
      if (!this.tweetType.equals(that.tweetType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_userId = true;
    list.add(present_userId);
    if (present_userId)
      list.add(userId);

    boolean present_loc = true && (isSetLoc());
    list.add(present_loc);
    if (present_loc)
      list.add(loc);

    boolean present_tweetType = true && (isSetTweetType());
    list.add(present_tweetType);
    if (present_tweetType)
      list.add(tweetType.getValue());

    return list.hashCode();
  }

  @Override
  public int compareTo(Tweet other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLoc()).compareTo(other.isSetLoc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLoc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.loc, other.loc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTweetType()).compareTo(other.isSetTweetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTweetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tweetType, other.tweetType);
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
    StringBuilder sb = new StringBuilder("Tweet(");
    boolean first = true;

    sb.append("userId:");
    sb.append(this.userId);
    first = false;
    if (isSetLoc()) {
      if (!first) sb.append(", ");
      sb.append("loc:");
      if (this.loc == null) {
        sb.append("null");
      } else {
        sb.append(this.loc);
      }
      first = false;
    }
    if (isSetTweetType()) {
      if (!first) sb.append(", ");
      sb.append("tweetType:");
      if (this.tweetType == null) {
        sb.append("null");
      } else {
        sb.append(this.tweetType);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'userId' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
    if (loc != null) {
      loc.validate();
    }
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

  private static class TweetStandardSchemeFactory implements SchemeFactory {
    public TweetStandardScheme getScheme() {
      return new TweetStandardScheme();
    }
  }

  private static class TweetStandardScheme extends StandardScheme<Tweet> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Tweet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LOC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.loc = new Location();
              struct.loc.read(iprot);
              struct.setLocIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TWEET_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.tweetType = hello.thrift.TweetType.findByValue(iprot.readI32());
              struct.setTweetTypeIsSet(true);
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
      if (!struct.isSetUserId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'userId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Tweet struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI32(struct.userId);
      oprot.writeFieldEnd();
      if (struct.loc != null) {
        if (struct.isSetLoc()) {
          oprot.writeFieldBegin(LOC_FIELD_DESC);
          struct.loc.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.tweetType != null) {
        if (struct.isSetTweetType()) {
          oprot.writeFieldBegin(TWEET_TYPE_FIELD_DESC);
          oprot.writeI32(struct.tweetType.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TweetTupleSchemeFactory implements SchemeFactory {
    public TweetTupleScheme getScheme() {
      return new TweetTupleScheme();
    }
  }

  private static class TweetTupleScheme extends TupleScheme<Tweet> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Tweet struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.userId);
      BitSet optionals = new BitSet();
      if (struct.isSetLoc()) {
        optionals.set(0);
      }
      if (struct.isSetTweetType()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetLoc()) {
        struct.loc.write(oprot);
      }
      if (struct.isSetTweetType()) {
        oprot.writeI32(struct.tweetType.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Tweet struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.userId = iprot.readI32();
      struct.setUserIdIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.loc = new Location();
        struct.loc.read(iprot);
        struct.setLocIsSet(true);
      }
      if (incoming.get(1)) {
        struct.tweetType = hello.thrift.TweetType.findByValue(iprot.readI32());
        struct.setTweetTypeIsSet(true);
      }
    }
  }

}
