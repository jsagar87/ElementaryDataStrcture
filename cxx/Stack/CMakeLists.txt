cmake_minimum_required(VERSION 3.13.4)

project(StackLib VERSION 1.0.0)

add_library(
    libstack
    Stack.hpp
    LinkedListStack.cpp
    ResizableArrayStack.cpp
)

add_executable(stack main.cpp)

target_link_libraries(stack PUBLIC libstack)