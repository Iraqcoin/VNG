#include <iostream>
#include "Poco/HMACEngine.h"
#include "Poco/SHA1Engine.h"

using namespace std;
using Poco::DigestEngine;
using Poco::HMACEngine;
using Poco::SHA1Engine;

//int main(int argc, char** argv)
//{
//	std::string message1("This is a top-secret message.");
//	std::string message2("Don't tell anyone!");
//	std::string passphrase("s3cr3t"); // HMAC needs a passphrase
//	HMACEngine<SHA1Engine> hmac(passphrase); // we'll compute a HMAC-SHA1
//	hmac.update(message1);
//	cout<<message1<<endl;
//	hmac.update(message2);
//	const DigestEngine::Digest& digest = hmac.digest();
//	// finish HMAC computation and obtain digest
//	std::string digestString(DigestEngine::digestToHex(digest));
//	// convert to a string of hexadecimal numbers
//
//	cout<<digestString;
//	return 0;
//}