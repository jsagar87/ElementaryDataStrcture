#ifndef INCLUDE_HEADER_STACK
#define INCLUDE_HEADER_STACK

namespace Stack{
    template<class I>
    class Stack {        
        public:
            virtual void push(I item);
            virtual I pop();
            virtual bool isEmpty();
            virtual int size();
    }; // class Stack
}// namespace stack

#endif