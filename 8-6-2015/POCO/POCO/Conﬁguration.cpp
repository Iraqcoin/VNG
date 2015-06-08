#include <iostream>
#include "Poco\AutoPtr.h"
#include "Poco\Util\ConfigurationView.h"
#include "Poco\Util\IniFileConfiguration.h"
#include "Poco\Util\PropertyFileConfiguration.h"
#include "Poco\Util\XMLConfiguration.h"
using namespace std;
using Poco::AutoPtr;
using Poco::Util::IniFileConfiguration;
using Poco::Util::PropertyFileConfiguration;
using Poco::Util::XMLConfiguration;
void DemoIniFile()
{
	AutoPtr<IniFileConfiguration> pconFig(new IniFileConfiguration("config.ini"));
	string path = pconFig->getString("MyApp.somePath");
	int value = pconFig->getInt("MyApp.someValue");
	cout<<path<<endl;
	cout<<value<<endl;
	value = pconFig->getInt("myapp.somevalue");
	cout<<value<<endl;
	value = pconFig->getInt("myapp2.SomeOtherValue", 456);
	cout<<value<<endl;
}
void DemoPropertiesFile()
{
	AutoPtr<PropertyFileConfiguration> pConf;
	pConf = new PropertyFileConfiguration("config.properties");
	std::string key1 = pConf->getString("key1");
	cout<<"key1 : "<<key1<<endl;
	int value = pConf->getInt("key2",1);
	cout<<"key2 : "<<value<<endl;
	std::string longVal = pConf->getString("key2.longValue","default");
	cout<<"key2.longValue : "<<longVal;

	//pConf->setInt("key100",10000);
	string path = pConf->getString("path");
	cout<<"Path "<<path;

	int a = pConf->getInt("key100");
	//pConf->save("config.properties");

	cout<<a;
}
void DemoXMLFile()
{
	AutoPtr<XMLConfiguration> pConfig;
	pConfig = new XMLConfiguration("config.xml");

	std::string prop1 = pConfig->getString("prop1"); 
	cout<<prop1<<endl;
	int prop2 = pConfig->getInt("prop2");
	cout<<prop2<<endl;
	std::string prop3 = pConfig->getString("prop3"); // ""
	cout<<prop3<<endl;
	std::string prop4 = pConfig->getString("prop3.prop4"); // ""
	cout<<"text : " <<prop4<<endl;
	prop4 = pConfig->getString("prop3.prop4[@attr]"); // "value3"
	cout<<prop4<<endl;
	prop4 = pConfig->getString("prop3.prop4[1][@attr]"); // "value4"
	cout<<prop4<<endl;
}
void DocCauHinh()
{
}
//int main()
//{
//	//DemoIniFile();
//	DemoPropertiesFile();
//	//DemoXMLFile();
//	return 0;
//}
