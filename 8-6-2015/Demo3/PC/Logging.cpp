#include <iostream>
#include "Poco/Logger.h"
#include "Poco/FileChannel.h"
#include "Poco/AutoPtr.h"
using namespace std;
using Poco::Logger;
using Poco::FileChannel;
using Poco::AutoPtr;
//int main(int argc, char** argv)
//{
//   AutoPtr<FileChannel> pChannel(new FileChannel);
//   pChannel->setProperty("path", "sample.log");
//   pChannel->setProperty("rotation", "2 K");
//   pChannel->setProperty("archive", "timestamp");
// 
//   Logger::root().setChannel(pChannel);
// 
//   Logger& logger = Logger::get("TestLogger"); // inherits root channel
// 
//   for (int i = 0; i < 100; ++i)
//      logger.information("Testing FileChannel");
//}