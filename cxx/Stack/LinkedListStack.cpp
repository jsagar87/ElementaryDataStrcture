#include <iostream>

#include "Stack.hpp"

using namespace std;
using namespace Stack;

namespace Stack {

// -------------------- LinkedList Definition -----------------------------------
template<class T>
class LinkedListStack  : public Stack<T>{

private:
    template<class T>
    class Link {
        public :
            T data;
            Link *next;
    };

    Link<T> *stack;
public:
    LinkedListStack();
    ~LinkedListStack();
    virtual void push(T item);
    virtual T pop();
    virtual bool isEmpty();
    virtual int size();
};

template<class T>
LinkedListStack<T>::LinkedListStack() {
    this->stack = new Link<T>();
};

template<class T>
LinkedListStack<T>::~LinkedListStack(){

};

template<class T>
void LinkedListStack<T>::push(T item) {
    cout << "Item ->" << item << endl ;
};

template<class T>
T LinkedListStack<T>::pop(){
    T popper = this->stack->data;
    return popper;
};

template<class T>
bool LinkedListStack<T>::isEmpty(){
    return false;
};

template<class T>
int LinkedListStack<T>::size() {
    return 1;
};
// ------------------------------------------------------------------------------

}

