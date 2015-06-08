%{
#include <iostream>
#include <vector>
using namespace std;

int HelloWorld(char *str) {
    cout << "Hello World: " << str << endl;

    // run some slow code
    vector<int> array;
    for (int i=0; i < 10000000; i++) array.push_back(i*2);
    for (int i=0; i < array.size(); i++) array[i]++;
    return 0;
}
%}

%module example
int HelloWorld(char *str);