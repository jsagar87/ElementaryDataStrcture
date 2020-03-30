cmake_minimum_required(VERSION 3.13.4)

project(QuickUnionLib VERSION 1.0.0)

add_library(
    libunionfind
    UnionFind.hpp
    QuickUnion.cpp
    QuickFind.cpp
)

add_executable(uf main.cpp)

target_link_libraries(uf PUBLIC libunionfind)