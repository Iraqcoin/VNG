#include "Poco/AutoPtr.h"
using Poco::AutoPtr;
#include <iostream>
using namespace std;
class RCO{
public:
    RCO():_rc(1){
        
    }
    void duplicate(){
        ++_rc;
    }
    void release(){
        cout<<"realse"<<endl;
        if(--_rc==0)
        {
            cout<<"delete";
            delete this;
        }
    }
  
    int _rc;
};

//int main(int ,char** argv){
//    RCO *pNew = new RCO(); // _rc == 1;
//    AutoPtr<RCO> p1(pNew); // _rc == 1;
//   
//    AutoPtr<RCO> p2(p1);
//    // _rc == 2;
//    cout<<p2->_rc;
//    AutoPtr<RCO> p3(pNew,true); // _rc == 3
//
//    
//    p2=0; // _rc = 2
//    cout<<p3->_rc;
//    
//    
//    p3=0; // _rc = 1
//    cout<<p1->_rc;
//    
//    RCO* pRC = p1; // _rc== 1
//    
//    p1 = 0; /// _rc = 0 deleted
//    
//    cout<<pNew->_rc;
//    p1 = new RCO; //// _rc == 1
//    cout<<p1->_rc;
//    
//}