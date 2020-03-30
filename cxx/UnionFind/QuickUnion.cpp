#include<iostream>

#include "UnionFind.hpp"

using namespace UnionFind;
using namespace std;

namespace UnionFind {
    class QuickUnion : public UnionFind {
        private:
            int N;
            int* id;
        public:
            QuickUnion();
            QuickUnion(int N);
            ~QuickUnion();

            // Add Connection between two components p and q        
            void _union(int p, int q) ;
            
            // Are p and q in the same component ?
            bool _connected(int p, int q);

            // Component identifier for p (0 to N-1)
            int _find(int key);

            // number of components
            int _count();

            // Print array sample
            void printSample();
    }; // class QuickUnion

} // namespace UnionFind

QuickUnion::QuickUnion() : N(N),id(new int[N])
{
    for (int i = 0; i<N; i++) {
        this->id[i] = i;
    }
}

QuickUnion::~QuickUnion() 
{
    cout << "Object is being destructed" << endl ;
    free(this->id);
}

int QuickUnion::_find(int key) {
    cout << "Hello from find " << endl ;
    int i = key ;
    while(this->id[i]!=i) {
        i = this->id[i] ;
    }
    return i;
}

void QuickUnion::_union(int p, int q) {
    int pid = _find(p);
    int qid = _find(q);
    if   (pid==qid) return;
    else (*this).id[pid] = qid ;
}

void QuickUnion::printSample() {
    int less;

    if (this->N <10) {
        less = this->N;
    }
    else
    {
        less = 10;
    }

    for(int i=0 ; i<less; i++ ) {
        std::cout << i << " -> " << this->id[i] << std::endl ;
    }
}