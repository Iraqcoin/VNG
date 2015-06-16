#include "Poco/Thread.h"
#include "Poco/Runnable.h"
#include "Poco/RunnableAdapter.h"
#include <iostream>
#include <Poco/ThreadPool.h>
#include "Poco/ThreadLocal.h" 
Poco::FastMutex mutex;
  Poco::FastMutex mutex2;
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
      
       Poco::FastMutex::ScopedLock l(mutex);
       std::cout<<" lock(mutex) "<<Poco::Thread::current()->getName()<<std::endl;
       
       Poco::FastMutex::ScopedLock l2(mutex);
       std::cout<<" lock(mutex2) "<<Poco::Thread::current()->getName()<<std::endl;
    }
    virtual~HelloRunnable(){
        std::cout<<"huy cmnr"<<std::endl;
    }
};
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
int main(int, char** argv) {
    test4();
    return 0;
}