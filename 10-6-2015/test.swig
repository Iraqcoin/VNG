%{
#include <iostream>
#include <vector>
using namespace std;

int TinhTong(int a,int b) {
    return a + b;
}
%}

%module example
int TinhTong(int a,int b);