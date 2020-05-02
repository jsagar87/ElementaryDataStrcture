#include <iostream>

#include "Stack.hpp"
#include "LinkedListStack.cpp"
#include "string"

using namespace std;

using namespace Stack;

int main(int argc, char **argv[]) {
    std::cout << "Hello, World! \nStack \n"
    << "LinkedListStack demo:" << std::endl;

    Stack::Stack<int> *stackInt;
    LinkedListStack<int> llStackInt();
    Stack::Stack<string> *stackString ;
    LinkedListStack<string> llstackString();

    stackInt = &llStackInt ;
    stackString = &llstackString;

    stackInt-> push(1);
    stackString->push("one");

}