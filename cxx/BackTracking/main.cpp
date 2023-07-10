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
class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        std::vector<string> v = {"Jaya", "Sushma", "Rekha", "Divya", "Sabki pasand nirma"};

        for (const string& s: v) {
            std::cout << s << endl ;
        }
        // vector<vector<char>>& boardNew;
        // std::copy(std::begin(board), std::end(board), std::begin(boardNew));
        // int r = board.size();
        // // int c = board[0].size();

        // // std::cout << "numberof columns " << c << std::endl;
        // std::cout << "nuymberof rows" << r << std::endl;


        


    }
};

int main(int argc, char** argv) 
{
    map<int, bool> row;
    list<map<int, bool>> col;
    
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


    // std::vector<vector<char>>* board = {{".","1"}, {"2","1"}};
    Solution sol;
    sol.solveSudoku(NULL);

    return 0;    
}
