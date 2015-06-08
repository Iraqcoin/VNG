#include "Poco/Thread.h"
#include "Poco/Runnable.h"
#include "Poco/RunnableAdapter.h"
#include <iostream>
#include <Poco/ThreadPool.h>
#include "Poco/ThreadLocal.h"

  Poco::Mutex mutex;
  Poco::Mutex mutex2;
class HelloRunnable : public Poco::Runnable {
private:
  
    int n;
public :
    HelloRunnable(int m):Poco::Runnable(){
        n = m;
            std::cout<<"kt "<<std::endl;
    }
    HelloRunnable():Poco::Runnable(){
        n = 40;
    }
    virtual void run() {
        
        for(int i=0;i<12;i++){
             Poco::Thread::sleep(100);
             //std::cout<<Poco::Thread::current()->getName()<<"  "<<(--n)<<std::endl;
        }
      
       // Poco::Mutex::ScopedLock l(mutex);
        //std::cout<<" lock(mutex) "<<Poco::Thread::current()->getName()<<std::endl;
       
       // Poco::Mutex::ScopedLock l2(mutex2);
      //  std::cout<<" lock(mutex2) "<<Poco::Thread::current()->getName()<<std::endl;
    }
    virtual~HelloRunnable(){
        std::cout<<"huy cmnr"<<std::endl;
    }
};
class HelloRunnable1 : public Poco::Runnable {
private:
  
    int n;
public :
    HelloRunnable1():Poco::Runnable(){
    
        n = 40;
    }
    virtual void run() {
        
          
        for(int i=0;i<12;i++){
             Poco::Thread::sleep(100);
             //std::cout<<Poco::Thread::current()->getName()<<(--n)<<std::endl;
        }
       // Poco::Mutex::ScopedLock l(mutex2);
        //std::cout<<" lock(mutex2) "<<Poco::Thread::current()->getName()<<std::endl;
        //Poco::Thread::sleep(100);
       // Poco::Mutex::ScopedLock l2(mutex);
       // std::cout<<" lock(mutex) "<<Poco::Thread::current()->getName()<<std::endl;
    }
};



class Greeter {
public:

    void greet() {
        for (int i = 0; i < 20; i++) {
            std::cout << "H , world 111 !" << std::endl;
            Poco::Thread::sleep(1000);
        }
    }
};

class Counter : public Poco::Runnable {
 
    void run() {
        static Poco::ThreadLocal<int> tls;
        for (*tls = 0; *tls < 10; ++(*tls)) {
            std::cout << *tls << std::endl;
            Poco::Thread::sleep(1000);
        }
    }
};

void test() {
    HelloRunnable runnable;
    Poco::Thread* thread = new Poco::Thread();
    thread->start(runnable);
    thread->join();
    std::cout << "Ket thuc thread";
}

void test1() {
    Greeter g;
    Poco::RunnableAdapter<Greeter> runnable(g, &Greeter::greet);
    Poco::Thread thread;
    thread.start(runnable);
    thread.join();
    std::cout << "Ket thuc thread 1";
}

void test2() {
    HelloRunnable runnable;

    Poco::ThreadPool::defaultPool().startWithPriority(Poco::Thread::PRIO_LOWEST, runnable, "Thread 1");
    Poco::ThreadPool::defaultPool().start(runnable, "Thread 2");
    Poco::ThreadPool::defaultPool().start(runnable, "Thread 3");
    Poco::ThreadPool::defaultPool().start(runnable, "Thread 4");
    Poco::ThreadPool::defaultPool().joinAll();

    std::cout << "Ket thuc Thread pool";
}

void test3() {

    Counter counter;
    Poco::Thread t1;
    Poco::Thread t2;
    t1.start(counter);
    t2.start(counter);
    t1.join();
    t2.join();
}
void test4()
{
    HelloRunnable runnable(40);
    HelloRunnable runnable1(60);
    Poco::Thread t1;
    Poco::Thread t2;
    t1.setName("Thread 1");
    t1.start(runnable);
    t2.setName("Thread 2");
    t2.start(runnable1);
    t1.join();
    t2.join();
}
void test5(){
     Poco::Thread t1[2];
      t1[0].setName("Thread 1");
       t1[1].setName("Thread 2");
    for(int i=0;i<2;i++){
        //HelloRunnable runnable(40);// ??
        
        HelloRunnable *runnable = new HelloRunnable(50);
        std::cout<<runnable;
        t1[i].start(*runnable);
    }
      
      for(int i=0;i<2;i++){
          t1[i].join();
    }
}
//int main(int, char** argv) {
//    test5();
//    return 0;
//}


