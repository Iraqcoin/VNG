swig -c++ -php5 example.swig
g++ `php-config --includes` -O2 -march=native -mtune=native -std=c++11 -fPIC -c *.cpp
g++ -shared *.o -o example.so
php5enmod example