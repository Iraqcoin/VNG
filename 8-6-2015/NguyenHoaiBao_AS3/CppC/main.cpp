/*
 * File:   main.cpp
 * Author: hoaibao
 *
 * Created on May 26, 2015, 8:38 AM
 */

#include <iostream>
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/transport/TSocket.h>
#include <thrift/transport/TTransportUtils.h>
#include "UserService.h"
#include "BenMarkCPP.h"

using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;
using boost::shared_ptr;
using namespace ::Common::ThriftInterface;

/*
 *
 */
void runDemo() {
    boost::shared_ptr<TTransport> socket(new TSocket("localhost", 9090));
    // boost::shared_ptr<TTransport> transport(new TBufferedTransport(socket));
    boost::shared_ptr<TTransport> transport(new TFramedTransport(socket));
    boost::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
    UserServiceClient client(protocol);
    try {
        transport->open();
        User uu;
        client.GetUser(uu, "Thread 2");
        cout << "ID : " << uu.Id << endl;
        cout << "USERNAME : " << uu.username << endl;
        cout << "VISITOR : " << uu.visitor;
        transport->close();
    } catch (TException& tx) {
        cout << "ERROR: " << tx.what() << endl;
    }
}
int main(int argc, char** argv) {

    runDemo();
    //DemoBenMarkRequest();
    //DemoBenMarkThread();
    //DemoBenMarkThreadPool();
    return 0;
}

