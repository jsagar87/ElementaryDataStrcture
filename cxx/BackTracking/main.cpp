#include <iostream>
#include <list>
#include <vector>
#include <string>
#include <unordered_set>
#include <cstdio>
#include "math_fun.cpp"
#include <map>

using namespace std;

int get_box_id(int col, int row)
{
    const int col_num = std::floor(col/3);
    const int row_num = std::floor(row/3) * 3;

    return col_num + row_num;
}

int main(int argc, char** argv) 
{
    // list<map<int, int>> row;
    // list<map<int, int>> col;

    map<int, bool> zero;
    zero.insert({0,false});
    zero.insert({1,false});

    auto valExist = zero.find(0);

       if ( valExist == zero.end() ) {  
    // not found  
     cout<<"Element not found";  
    }   
    else {  
        // found  
        cout << "Iterator points to " << valExist->first << " = " << valExist->second << endl;  
    }  

    cout << "Box number for col 5, row 6 is " << get_box_id(5,6) << endl;

    // vector<string> msg{"Hello", "Lets", "play", "the", "Game", "of", "Sudoku"};
    // for (const string& word : msg)
    // {
    //     cout << word << " ";
    // }
    // cout << endl;
    

    // double alpha = 1.0f;
    // double x_threshold = 3.0f;    
    // if (argc>1) {
    //     std::cout << "Number " <<  alpha << std::endl ;
    //     alpha = atof(argv[1]);
    //     std::cout << "Number updated to " <<  alpha << std::endl ;
    //     printf("Number %f", alpha);
    // }
    // if (argc>2) {
    //     x_threshold = atof(argv[2]);
    // }
    // // const int n_particles = 1<<17;
    // const int n_steps = 500;
    // // std::cout << n_particles << std::endl ;
    // std::cout<< add(10,20) << std::endl;

    // std::cout << "End of program" << std::endl;
}
