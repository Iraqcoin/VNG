#include "DataProvider.h"

using Poco::NumberFormatter;
using Poco::AutoPtr;
using Poco::Util::PropertyFileConfiguration;
Logger& DataProvider::logger = Logger::get("logger1");

string DataProvider::getConnectionSting(bool flag) {
    AutoPtr<PropertyFileConfiguration> pConf;
    pConf = new PropertyFileConfiguration("cpps.properties");
    if (flag == true) {
        return pConf->getString("connectionString.sqlite");
    } else {
        return pConf->getString("connectionString.mysql");
    }
}

Session DataProvider::createSession() {
    logger.information("connectDatabase");
    // register SQLite connector
    //Poco::Data::SQLite::Connector::registerConnector();
    Poco::Data::MySQL::Connector::registerConnector();
    //std::string con = getConnectionSting(true);
    std::string con = getConnectionSting(false);
    // create a session
    //Session session("SQLite", con);
    Session session("MySQL", con);
    return session;

}

void DataProvider::GetUsers(User& u, string name) {
    // a simple query
    logger.information("GetUsers");
    User uu;
    Session session = createSession();
    Statement select(session);
    select << "SELECT * FROM users WHERE username=?",
            into(uu.Id),
            into(uu.username),
            into(uu.password),
            into(uu.visitor),
            use(name), now; //  iterate over result set one row at a time
    try {
        while (!select.done()) {
            select.execute();
        }
    } catch (Poco::Exception ex) {
        logger.error(ex.message());
    }

    u.__set_username(uu.username);
    u.__set_password(u.password);
    u.__set_visitor(uu.visitor);
    u.__set_Id(uu.Id);
}

int DataProvider::UpdateVisitor(string username) {
    logger.information("UpdateVisitor");
    User u;
    Increase(u, username);
    Session session = createSession();
    Statement insert(session);
    insert << "Update users set username=? , passwd=? , visitor=? WHERE id=?",
            use(u.username),
            use(u.password),
            use(u.visitor),
            use(u.Id);
    try {
        insert.execute();
    } catch (Poco::Exception ex) {
        logger.error(ex.message());
    }

    return 1;
}

void DataProvider::Increase(User& u, string username) {
    logger.information("Increase");
    GetUsers(u, username);
    u.__set_visitor(u.visitor + 1);
}

void DataProvider::InsertUser() {
    Session session = createSession();
    Statement insert(session);
    User u;
    u.__set_Id(1);
    string str1 = "Thread";
    string str2 = "1";
    string username = str1 + str2;
    u.__set_username(username);
    u.__set_password("123456");
    u.__set_visitor(0);
    insert << "INSERT INTO users(id,username,passwd,visitor) VALUES(?,?, ?, ?)",
            use(u.Id),
            use(u.username),
            use(u.password),
            use(u.visitor);
    insert.execute();
    for (int i = 2; i <= 10; i++) {
        u.__set_Id(i);
        string str1 = "Thread";
        string str2;
        NumberFormatter::append(str2, i);
        string username = str1 + str2;
        u.__set_username(username);
        u.__set_password("123456");
        u.__set_visitor(0);
        insert.execute();
    }
}
