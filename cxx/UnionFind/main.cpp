#include <iostream>

#include "QuickUnion.cpp"

using namespace std;

using namespace UnionFind;

int main(int argc, char **argv[]) {
    std::cout << "Hello, World! \nQuick Union \n" << std::endl;
    QuickUnion qu(10);
    qu._union(2,3);
    qu._find(1);
    qu.printSample();
}