namespace cpp com.example.project  // 1
namespace java com.example.project // 2
struct Tweet {
    1: required i32 userId;
    2: required string userName;
    3: required string text;
    16: optional string language = "english"
	17: map<string,string> MAP_CONST = {"hello": "world", "goodnight": "moon"}
}
exception TwitterUnavailable{
	1:string message;
}
service Twitter {
	 void ping();                                                             // 1
    bool postTweet(1:Tweet tweet) throws (1:TwitterUnavailable unavailable); // 2
	i32 searchTweets(1:string query);                          // 3
    oneway void zip()    
}
