#include <iostream>
#include <set>
#include "Poco/Thread.h"
#include "Poco/Runnable.h"
#include <Poco/ThreadPool.h>
#include "Poco/DateTime.h"
#include "Poco/Timestamp.h"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/transport/TSocket.h>
#include <thrift/transport/TTransportUtils.h>
#include "Poco/NumberFormatter.h"
#include "Poco/Nullable.h"
#include "Poco/RunnableAdapter.h"
#include "Poco/ThreadLocal.h"
#include "UserService.h"


using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::protocol;
using namespace apache::thrift::transport;
using boost::shared_ptr;
using namespace ::Common::ThriftInterface;
using namespace std;
using Poco::Thread;
using Poco::ThreadPool;
using Poco::Timestamp;
using Poco::NumberFormatter;
//Runnable class

class Greeter {
public:
    void greet() {
        boost::shared_ptr<TTransport> socket(new TSocket("localhost", 9090));
        // boost::shared_ptr<TTransport> transport(new TBufferedTransport(socket));
        boost::shared_ptr<TTransport> transport(new TFramedTransport(socket));
        boost::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
        UserServiceClient client(protocol);
        try {
            transport->open();
            for (int j = 1; j <= 1000; j++) {
                User uu;
                client.GetUser(uu, Thread::current()->getName());
                cout << Thread::current()->getName() << " : " << j << " _ " << uu.username << endl;
            }
            transport->close();
        } catch (TException& tx) {
            cout << "ERROR: " << tx.what() << endl;
        }
    }
};
// đo thời gian TB Server phản hỏi 1 request

void DemoBenMarkRequest() {
    Timestamp now;
    Timestamp::TimeDiff start = now.elapsed();
    boost::shared_ptr<TTransport> socket(new TSocket("localhost", 9090));
    // boost::shared_ptr<TTransport> transport(new TBufferedTransport(socket));
    boost::shared_ptr<TTransport> transport(new TFramedTransport(socket));
    boost::shared_ptr<TProtocol> protocol(new TBinaryProtocol(transport));
    UserServiceClient client(protocol);
    bool check = false;
    try {
        transport->open();
        check = client.CheckLogin("", "");
        transport->close();
    } catch (TException& tx) {
        cout << "ERROR: " << tx.what() << endl;
    }
    Timestamp::TimeDiff end = now.elapsed();
    Timestamp::TimeDiff tong = end - start;

    cout << (tong) << " nano second " << endl;
}

void DemoBenMarkThread() {
    //N = 10 ; số Thread;
    //n = 1000 ; số request của 1 Thread     
    Timestamp now;
    Timestamp::TimeDiff start = now.elapsed();
    const int N = 10;
    Thread ts[N];
    for (int k = 0; k < N; k++) {
        string str1;
        string str2 = "Thread ";
        NumberFormatter::append(str1, k + 1);
        ts[k].setName(str2 + str1);
        Greeter greeter;
        Poco::RunnableAdapter<Greeter> runnable(greeter, &Greeter::greet);
        ts[k].start(runnable);
    }
    // chờ cho đến khi chạy hết 10 thread.
    for (int i = 0; i < N; i++)
        ts[i].join(); // wait for all threads to end
    Timestamp::TimeDiff end = now.elapsed();
    Timestamp::TimeDiff tong = end - start;
    cout << (tong / 1000) << endl;
    tong = tong / 1000;
    float tb = 10000 / ((float) tong / 1000);
    cout << endl << "TB : " << tb;
}

void DemoBenMarkThreadPool() {
    //    N = 10 ; số Thread;
    //    n = 1000 ; số request của 1 Thread     
    Poco::ThreadPool::defaultPool().addCapacity(10000);
    Timestamp now;
    Timestamp::TimeDiff start = now.elapsed();
    for (int i = 1; i <= 10; i++) {
        string str1;
        string str2 = "Thread ";
        NumberFormatter::append(str1, i);
        string str3 = str2 + str1;
        Greeter g;
        Poco::RunnableAdapter<Greeter> runnable(g, &Greeter::greet);
        Poco::ThreadPool::defaultPool().start(runnable, str3);
    }
    Poco::ThreadPool::defaultPool().joinAll();
    // chờ cho đến khi chạy hết 10 thread.
    Timestamp::TimeDiff end = now.elapsed();
    Timestamp::TimeDiff tong = end - start;
    cout << (tong / 1000) << endl;
    tong = tong / 1000;
    float tb = 10000 / ((float) tong / 1000);
    cout << "TB : " << tb;
}
