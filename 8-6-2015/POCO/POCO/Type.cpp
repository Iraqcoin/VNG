#include <iostream>
#include <Poco\Types.h>
#include <Poco\ByteOrder.h>
#include <Poco\Any.h>
#include <Poco\Exception.h>
using namespace std;
using  Poco::Int16;
using Poco::IntPtr;
using Poco::Any;
using Poco::AnyCast;
using Poco::RefAnyCast;
class SinhVien{
public:
	int ma;
	string name;
	void show(){
	}
};
//int main(int argc, char** argv)
//{
//	#ifdef POCO_ARCH_LITTLE_ENDIAN
//		std::cout << "little endian" << std::endl;
//	#else
//		std::cout << "big endian" << std::endl;
//	#endif
//
//
//	Poco::UInt16 port = 80;
//	Poco::UInt16 networkPort = Poco::ByteOrder::toNetwork(port);
//	cout<<endl<<networkPort;
//	SinhVien sv;
//	sv.ma = 1;
//	sv.name = "hb";
//	Any any(sv);
//	Any a(10.100);
//	//int i = AnyCast<int>(any); // okay
////	int& ri = RefAnyCast<int>(any);
//	//cout<<endl<<"Any : "<<i;
//	//cout<<endl<<"AnyRef : "<<ri;
//	try{
//		SinhVien s = AnyCast<SinhVien>(any);
//		float dd = AnyCast<float>(a);
//		cout<<endl<<"Short : "<<s.name;
//		cout<<dd;
//	}
//	catch(Poco::BadCastException ex){
//		string mess = ex.displayText();
//		cout<<mess;
//	}
//	return 0;
//}
