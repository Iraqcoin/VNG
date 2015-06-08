#include <Poco\String.h>
#include<iostream>
using Poco::trim;
using Poco::trimInPlace;
using Poco::trimLeft;
using Poco::trimRight;
using Poco::trimRightInPlace;
using Poco::toUpper;
using Poco::toLower;
using Poco::toLowerInPlace;
using Poco::icompare;
#include "Poco/StringTokenizer.h"
#include "Poco/String.h" // for cat
using Poco::StringTokenizer;
using Poco::cat;
using namespace std;
class sinhvien{
public:
	int masv;
	string name;
};
using Poco::replace;
//int main(int argc, char** argv)
//{
//	StringTokenizer t1("red, green, blue", ",");
//	// "red", " green", " blue" (note the whitespace)
//	
//	StringTokenizer t2("red,green,,blue", ",");
//	// "red", "green", "", "blue"
//	StringTokenizer t3("red; green, blue", ",;",
//		StringTokenizer::TOK_TRIM);
//	// "red", "green", "blue"
//	StringTokenizer t4("red; green,, blue", ",;",
//		StringTokenizer::TOK_TRIM | StringTokenizer::TOK_IGNORE_EMPTY);
//	// "red", "green", "blue"
//	std::string s(cat(std::string("; "), t4.begin(), t4.end()));
//	// "red; green; blue"
//	return 0;
//}