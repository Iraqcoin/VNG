/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef hello_TYPES_H
#define hello_TYPES_H

#include <iosfwd>

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/cxxfunctional.h>
#include "base_types.h"


namespace hello { namespace thrift {

struct TweetType {
  enum type {
    TWEET = 0,
    RETWEET = 2,
    REPLY = 3
  };
};

extern const std::map<int, const char*> _TweetType_VALUES_TO_NAMES;

class Location;

class Tweet;

class Demo;

typedef struct _Location__isset {
  _Location__isset() : name(false), demo(false), lo(false) {}
  bool name :1;
  bool demo :1;
  bool lo :1;
} _Location__isset;

class Location {
 public:

  static const char* ascii_fingerprint; // = "FA35B88690BB4F87FE720D8435516664";
  static const uint8_t binary_fingerprint[16]; // = {0xFA,0x35,0xB8,0x86,0x90,0xBB,0x4F,0x87,0xFE,0x72,0x0D,0x84,0x35,0x51,0x66,0x64};

  Location(const Location&);
  Location& operator=(const Location&);
  Location() : id(0), name() {
  }

  virtual ~Location() throw();
  int32_t id;
  std::string name;
  Demo demo;
  Location lo;

  _Location__isset __isset;

  void __set_id(const int32_t val);

  void __set_name(const std::string& val);

  void __set_demo(const Demo& val);

  void __set_lo(const Location& val);

  bool operator == (const Location & rhs) const
  {
    if (!(id == rhs.id))
      return false;
    if (!(name == rhs.name))
      return false;
    if (!(demo == rhs.demo))
      return false;
    if (!(lo == rhs.lo))
      return false;
    return true;
  }
  bool operator != (const Location &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Location & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  friend std::ostream& operator<<(std::ostream& out, const Location& obj);
};

void swap(Location &a, Location &b);

typedef struct _Tweet__isset {
  _Tweet__isset() : loc(false) {}
  bool loc :1;
} _Tweet__isset;

class Tweet {
 public:

  static const char* ascii_fingerprint; // = "0F293DFEB4315EDC80A9C58B0509AF38";
  static const uint8_t binary_fingerprint[16]; // = {0x0F,0x29,0x3D,0xFE,0xB4,0x31,0x5E,0xDC,0x80,0xA9,0xC5,0x8B,0x05,0x09,0xAF,0x38};

  Tweet(const Tweet&);
  Tweet& operator=(const Tweet&);
  Tweet() {
  }

  virtual ~Tweet() throw();
  Location loc;

  _Tweet__isset __isset;

  void __set_loc(const Location& val);

  bool operator == (const Tweet & rhs) const
  {
    if (__isset.loc != rhs.__isset.loc)
      return false;
    else if (__isset.loc && !(loc == rhs.loc))
      return false;
    return true;
  }
  bool operator != (const Tweet &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Tweet & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  friend std::ostream& operator<<(std::ostream& out, const Tweet& obj);
};

void swap(Tweet &a, Tweet &b);

typedef struct _Demo__isset {
  _Demo__isset() : demoName(false) {}
  bool demoName :1;
} _Demo__isset;

class Demo {
 public:

  static const char* ascii_fingerprint; // = "66E694018C17E5B65A59AE8F55CCA3CD";
  static const uint8_t binary_fingerprint[16]; // = {0x66,0xE6,0x94,0x01,0x8C,0x17,0xE5,0xB6,0x5A,0x59,0xAE,0x8F,0x55,0xCC,0xA3,0xCD};

  Demo(const Demo&);
  Demo& operator=(const Demo&);
  Demo() : demoName() {
  }

  virtual ~Demo() throw();
  std::string demoName;

  _Demo__isset __isset;

  void __set_demoName(const std::string& val);

  bool operator == (const Demo & rhs) const
  {
    if (__isset.demoName != rhs.__isset.demoName)
      return false;
    else if (__isset.demoName && !(demoName == rhs.demoName))
      return false;
    return true;
  }
  bool operator != (const Demo &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Demo & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  friend std::ostream& operator<<(std::ostream& out, const Demo& obj);
};

void swap(Demo &a, Demo &b);

}} // namespace

#endif
