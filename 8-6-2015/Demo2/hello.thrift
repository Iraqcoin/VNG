include "base.thrift"
namespace * hello.thrift


enum TweetType {
    TWEET,       // 1
    RETWEET = 2, // 2
    REPLY,
}
struct Location{
	1: required i32 id;
	2: string name;
	3: Demo demo;
	4: Location lo;
}
struct Tweet {
    4: optional Location loc;
  
}
service HelloService extends base.Twitter{
	base.Tweet getBaseTweet();
	Tweet getChildTweet();
	Tweet KhoiTao();
}
struct Demo{
	1:optional string demoName;
}