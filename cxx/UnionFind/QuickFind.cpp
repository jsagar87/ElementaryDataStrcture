#include<iostream>

#include"UnionFind.hpp"

using namespace std;
using namespace UnionFind;

namespace UnionFind {
    class QuickFind : public UnionFind {
        private:
            int N;
            int* id;
        public:
            QuickFind();
            QuickFind(int N);
            ~QuickFind();

            // Add Connection between two components p and q        
            void _union(int p, int q) ;
            
            // Are p and q in the same component ?
            bool _connected(int p, int q);

            // Component identifier for p (0 to N-1)
            int _find(int key);

            // number of components
            int _count();
    }; // class QuickFind
} // namespace UnionFind

QuickFind::QuickFind(int N) 
{
    (*this).N = N;
    for (int i = 0; i<N; i++) {
        (*this).id[i] = i;
    }
}

int QuickFind::_find(int key)
{
    cout << "Hello from find " << endl ;
    
    int i = key ;
    // while((*this).id[i]!=i) {
    //     i = (*this).id[i] ;
    // }
    // return i;
    return (*this).id[i];
}

bool QuickFind::_connected(int p, int q) {
    return (*this).id[p] == (*this).id[q];
}

void QuickFind::_union(int p, int q) {    
    int pid = (*this).id[p] ;
    int qid = (*this).id[q] ;

    // Order of N operation
    for (int i = 0 ; i < N; i++) {
        if((*this).id[i] == pid) {
            (*this).id[i] = qid ;
        }
    }

}