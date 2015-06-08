#include <iostream>
#include "Poco/Timestamp.h"
#include "Poco/Thread.h"
#include "Poco/DateTime.h"
#include "Poco/LocalDateTime.h"
#include "Poco/Timespan.h"
#include "Poco/Timezone.h"
#include "Poco/DateTimeParser.h"
#include "Poco/DateTimeFormat.h"
#include <ctime>
using namespace std;
using Poco::Timestamp;
using Poco::DateTime;
using Poco::LocalDateTime;
using Poco::Timespan;
using Poco::DateTimeParser;
using Poco::DateTimeFormat;
void DemoTimestamp()
{
	Timestamp now;
	time_t	t1 = now.epochTime();
	cout<<t1<<endl;
	Timestamp ts1(Timestamp::fromEpochTime(t1));
	cout<<ts1.epochTime();
	Poco::Thread::sleep(2000);
	Timestamp::TimeDiff diff = now.elapsed();
	cout<<endl<<"diff = "<<diff;
	Timestamp start(now);
	cout<<endl<<"start : "<<start.epochMicroseconds();
	now.update();
	cout<<endl<<"update now : "<<now.epochMicroseconds();
	cout<<endl<<"update start : "<<start.epochMicroseconds();
	diff = now - start;
	cout<<endl<<"now - start : "<<diff;
}
void DemoDateTime()
{
	DateTime now; // the current date and time in UTC
	int year   = now.year();
	cout<<"year : "<<year<<endl;
	int month  = now.month();
	cout<<"month : "<<month<<endl;
	int day    = now.day();
	cout<<"day : "<<day<<endl;
	int dow    = now.dayOfWeek();
	int doy    = now.dayOfYear();
	int hour   = now.hour();
	cout<<"hour : "<<hour<<endl;
	int hour12 = now.hourAMPM();
	cout<<"hour 12 : "<<hour12<<endl;
	int min    = now.minute();
	cout<<"min : "<<min<<endl;
	int sec    = now.second();
	cout<<"sec : "<<sec<<endl;
	int ms     = now.millisecond();
	int us     = now.microsecond();
	double jd  = now.julianDay();
	cout<<"jd : "<<jd<<endl;
	Poco::Timestamp ts = now.timestamp();

	DateTime xmas(2015, 12, 25);               
	Poco::Timespan timeToXmas = xmas - now;


	DateTime dt(1973, 9, 12, 2, 30, 45);      // 1973-09-12 02:30:45
	cout<<dt.timestamp().epochMicroseconds()<<endl;
	dt.assign(2006, 10, 13, 4, 45, 12, 345); // 2006-10-13 12:45:12.345
	cout<<dt.timestamp().epochMicroseconds();

	bool isAM = dt.isAM(); // false
	cout<<endl<<"isAM : "<<isAM;
	bool isPM = dt.isPM(); // true
	cout<<endl<<"isPM : "<<isPM;

	bool isLeap = DateTime::isLeapYear(2006);     // false
	cout<<endl<<"nhuan : "<<isLeap;
	int days    = DateTime::daysOfMonth(2006, 2); // 28
	bool isValid = DateTime::isValid(2006, 02, 29); // false

	dt.assign(2006, DateTime::OCTOBER, 22); // 2006-10-22 00:00:00
	if (dt.dayOfWeek() == DateTime::SUNDAY)
	{
		// ...
	}
}
void LocalDateTimes()
{
	LocalDateTime now; // the current date and local time
	int year   = now.year();
	int month  = now.month();
	int day    = now.day();
	int dow    = now.dayOfWeek();
	int doy    = now.dayOfYear();
	int hour   = now.hour();
	int hour12 = now.hourAMPM();
	int min    = now.minute();
	int sec    = now.second();
	int ms     = now.millisecond();
	int us     = now.microsecond();
	int tzd    = now.tzd();
	double jd  = now.julianDay();
	Poco::Timestamp ts = now.timestamp();
	LocalDateTime dt1(1973, 9, 12, 2, 30, 45); // 1973-09-12 02:30:45
	dt1.assign(2006, 10, 13, 13, 45, 12, 345); // 2006-10-13 12:45:12.345
	LocalDateTime dt2(3600, 1973, 9, 12, 2, 30, 45, 0, 0); // UTC +1 hour
	dt2.assign(3600, 2006, 10, 13, 13, 45, 12, 345, 0);
	Poco::Timestamp nowTS;
	LocalDateTime dt3(3600, nowTS); // construct from Timestamp
}
void TimespanDemo()
{
	//Timespan ts1(1, 11, 45, 22, 123433); // 1d 11h 45m 22.123433s
	//Timespan ts2(33*Timespan::SECONDS);
	//Timespan ts3(2*Timespan::DAYS + 33*Timespan::HOURS); // 3d 33h
	//int days       = ts1.days();         // 1
	//int hours      = ts1.hours();        // 11
	//int totalHours = ts1.totalHours();   // 35
	//int minutes    = ts1.minutes();      // 45
	//int totalMins  = ts1.totalMinutes(); // 2145
	//int seconds    = ts1.seconds();      // 22
	//int totalSecs  = ts1.totalSeconds(); // 128722


	// what is my age?
	DateTime birthdate(1973, 9, 12, 2, 30); // 1973-09-12 02:30:00
	DateTime now;
	Timespan age = now - birthdate;
	int days  = age.days();         // in days
	cout<<days;
	int hours = age.totalHours();   // in hours
	int secs  = age.totalSeconds(); // in seconds

	// when was I 10000 days old?
	Timespan span(10000*Timespan::DAYS);
	DateTime dt = birthdate + span;
}
//int main(int argc , char** argv)
//{
//	//DemoTimestamp();
//	//DemoDateTime();
//	//LocalDateTimes();
//	//TimespanDemo();
//	std::string s("Sat, 1 Jan 2005 12:00:00 GMT");
//	int tzd;
//	DateTime dt;
//	DateTimeParser::parse(DateTimeFormat::RFC1123_FORMAT, s, dt, tzd);
//	cout<<tzd;
//	Poco::Timestamp ts = dt.timestamp();
//	Poco::LocalDateTime ldt(tzd, dt);
//	cout<<dt.timestamp().epochMicroseconds();
//	bool ok = DateTimeParser::tryParse("2006-10-22", dt, tzd);
//	cout<<endl<<"ok : "<<ok;
//
//	ok = DateTimeParser::tryParse("%e.%n.%Y", "22.10.2006", dt, tzd);
//
//	cout<<endl<<"ok 2 : "<<ok<<" + zone : " + tzd;
//	return 0;
//}