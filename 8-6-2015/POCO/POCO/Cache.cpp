#include "Poco\LRUCache.h"
#include "Poco\ExpireCache.h"
#include "Poco\UniqueExpireCache.h"
#include "Poco\ExpirationDecorator.h"
#include <iostream>
using Poco::LRUCache;
using namespace std;
void LRU()
{
		LRUCache<int,string> myCache(3);
	myCache.add(1,"Lousy"); // |-1-| -> first elem is the most popular one
		Poco::SharedPtr<string> ptrElem =  myCache.get(1);  //1
	cout<<"dsdsd "<<*ptrElem;
	
	myCache.add(2, "Morning"); // |-2-1-|
	myCache.add(3, "USA");  // |-3-2-1-|

	// now get rid of the most unpopular entry: "Lousy"

	myCache.add(4, "Good"); // |-4-3-2-|

	poco_assert (*ptrElem == "Lousy");

	 ptrElem = myCache.get(2); // |-2-4-3-|

	cout<<"dsdsd "<<*ptrElem;
	myCache.add(2, "Evening"); // 2 Events: Remove followed by Add
	cout<<"dsdsd "<<*ptrElem;
	ptrElem = myCache.get(2); // |-2-4-3-|
	cout<<"dsdsd "<<*ptrElem;
}
typedef Poco::ExpirationDecorator<std::string> ExpString;
void static TimeBasedExpiration()
{
	Poco::UniqueExpireCache<int, ExpString> myCache;
	myCache.add(1, ExpString("test", 500));  // expires after 500ms
	myCache.add(2, ExpString("test", 1500)); // expires after 1500ms
	poco_assert (myCache.size() == 2);
	Poco::SharedPtr<ExpString> ptr = myCache.get(1);
	
}
//void main()
//{
//	TimeBasedExpiration();
//}
