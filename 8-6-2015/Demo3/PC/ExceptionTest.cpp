#include "Poco/NestedDiagnosticContext.h"
#include <iostream>

void f1() {
    poco_ndc(f1);
    Poco::NDC::current().dump(std::cout);
}

void f2() {
   // poco_ndc(f2);
    f1();
}

int main(int argc, char** argv) {
    f2();
    return 0;
}