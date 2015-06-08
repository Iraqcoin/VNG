/* 
 * File:   DataProvider.h
 * Author: hoaibao
 *
 * Created on June 1, 2015, 8:21 AM
 */

#ifndef DATAPROVIDER_H
#define	DATAPROVIDER_H
#include "UserService.h"
#include <iostream>
#include "Poco/Data/Session.h"
#include "Poco/Data/SQLite/Connector.h"
#include "Poco/Data/MySQL/Connector.h"
#include "Poco/NumberFormatter.h"
#include <string>
#include <string.h>
#include <vector>
#include "Poco/Logger.h"
#include "Poco/Util/PropertyFileConfiguration.h"
#include "Poco/AutoPtr.h"
using Poco::Logger;
using namespace std;
using namespace Poco::Data::Keywords;
using Poco::Data::Session;
using Poco::Data::Statement;
using namespace ::Common::ThriftInterface;

class DataProvider{
public:
    static Logger& logger ;
    string getConnectionSting(bool flag);
    Session createSession();
    void InsertUser();
    void GetUsers(User &u,string name);
    int UpdateVisitor(string username);
    void Increase(User &u,string username);
};
#endif	/* DATAPROVIDER_H */

