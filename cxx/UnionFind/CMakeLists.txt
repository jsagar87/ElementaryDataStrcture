cmake_minimum_required(VERSION 3.13.4)

project(QuickUnionLib VERSION 1.0.0)

add_library(libunionfind STATIC
    UnionFind.hpp
    QuickUnion.cpp
    QuickFind.cpp
)

find_library(UNIONFIND_LIBRARY libunionfind lib)

add_executable(uf main.cpp)

target_link_libraries(uf LINK_PUBLIC ${UNIONFIND_LIBRARY})