#ifndef INCLUDE_HEADER_STACK
#define INCLUDE_HEADER_STACK

using namespace std;

namespace Stack{
    template<class I>
    class Stack {        
        public:
            virtual void push(I item) = 0;
            virtual I pop() = 0;
            virtual bool isEmpty() = 0;
            virtual int size() = 0;
    }; // class Stack
}// namespace stack

#endif