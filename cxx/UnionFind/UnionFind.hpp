#ifndef UNION_FIND_INCLUDE
#define UNION_FIND_INCLUDE

namespace UnionFind {

    class UnionFind {
        public:

            // Add Connection between two components p and q        
            virtual void _union(int p, int q) ;
            
            // Are p and q in the same component ?
            virtual bool _connected(int p, int q);

            // Component identifier for p (0 to N-1)
            virtual int _find(int key);

            // number of components
            virtual int _count();
    };
}
#endif