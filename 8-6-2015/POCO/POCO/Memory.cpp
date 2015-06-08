#include "Poco/RefCountedObject.h"
#include "Poco/AutoPtr.h"
#include <iostream>
using Poco::RefCountedObject;
using Poco::AutoPtr;

class RCO: public RefCountedObject
{
public:
	RCO()
	{
	}
	void greet() const
	{
		std::cout << "Hello, world!" << std::endl;
	}
protected:
	~RCO()
	{
	}
};
//int main(int argc, char** argv)
//{
//	//AutoPtr<RCO> pRCO(new RCO);
//	//pRCO->greet();   // AutoPtr has -> operator
//	//(*pRCO).greet(); // AutoPtr has * operator
//	//std::cout << "refcount: " << pRCO->referenceCount() << std::endl;
//	//RCO* p1 = pRCO; // AutoPtr supports conversion to plain pointer
//	//RCO* p2 = pRCO.get();
//	//std::cout << "refcount: " << pRCO->referenceCount() << std::endl;
//	//std::cin.get();
//	//return 0;
//}