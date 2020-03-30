## A set of Algorithms for solving DYnamic connectivity problem

2 classic algorithm
Alg 1 : Quick Find
Alg 2 : Quick Union

Dynamic connectivity :: Given the set of N Objects
    - Union command. connect two objects
    - Find/connected query. is there a path connecting two objects

Intermix union command with connected query we need to be able to officially support those commands for large number of objects.
Applications involve manipulating objects of all types.
・Pixels in a digital photo.
・Computers in a network.
・Friends in a social network.
・Transistors in a computer chip.
・Elements in a mathematical set.
・Variable names in Fortran program.
・Metallic sites in a composite system.


## Goal
Design efficient data structure for union-find
- Number of object N can be huge
- Number of operation M can be huge
- Find Queries and Union command may be intermixed

