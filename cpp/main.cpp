#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <list>
#include <valarray>
#include <algorithm>
#include <chrono>
using namespace std;

enum StructureTypes {
    common_array,
    std_vector,
    std_list,
    std_valarray,
    invalid_type
};

StructureTypes resolveType(string input) {
    if (input == "array") return StructureTypes::common_array;
    if (input == "std_vector") return StructureTypes::std_vector;
    if (input == "std_list") return StructureTypes::std_list;
    if (input == "std_valarray") return StructureTypes::std_valarray;

    return StructureTypes::invalid_type;
}

//TODO: unify sorting call for all data structures if possible
//TODO: round elapsed time by 2 digits after dot 
int main(int argc, char **argv) {
    if (argc == 1) {
        cout << "Error: structure type must be passed as CMD argument!" << endl;
        return -1;
    }

    ifstream inputFile ("../input_data.txt");
    if(inputFile.is_open()) {
        string line;
        
        getline(inputFile, line);
        const unsigned int SIZE = stoi(line);

        chrono::_V2::system_clock::time_point tic;
        chrono::_V2::system_clock::time_point toc;

        switch (resolveType(argv[1])) {
            case StructureTypes::common_array: {
                int* data = new int[SIZE];

                for(int i = 0; getline(inputFile, line); i++)
                    data[i] = stoi(line);
                
                cout << SIZE << " integers have been loaded into array" << endl;
                
                tic = chrono::high_resolution_clock::now();
                sort(data, data + SIZE);
                toc = chrono::high_resolution_clock::now();

                delete[] data;
                break;
            }
            case StructureTypes::std_vector: {
                vector<int> data;

                while(getline(inputFile, line))
                    data.push_back(stoi(line));

                cout << data.size() << " integers have been loaded into std::vector" << endl;
                
                tic = chrono::high_resolution_clock::now();
                sort(data.begin(), data.end());
                toc = chrono::high_resolution_clock::now();
                data.clear();
                break;
            }
            case StructureTypes::std_list: {
                list<int> data;

                while(getline(inputFile, line))
                    data.push_back(stoi(line));

                cout << data.size() << " integers have been loaded into std::list" << endl;
                tic = chrono::high_resolution_clock::now();
                data.sort();
                toc = chrono::high_resolution_clock::now();
                data.clear();
                break;
            }
            case StructureTypes::std_valarray: {
                valarray<int> data(SIZE);

                for(int i = 0; getline(inputFile, line); i++)
                    data[i] = stoi(line);

                cout << data.size() << " integers have been loaded into std::valarray" << endl;
                
                tic = chrono::high_resolution_clock::now();
                sort(begin(data), end(data));
                toc = chrono::high_resolution_clock::now();
                data.resize(0, 0);
                break;
            }
            case StructureTypes::invalid_type: {
                cout << "Error: invalid structure type!" << endl;
                return -1;
            }
        }

        long elapsed = chrono::duration_cast<chrono::nanoseconds>(toc-tic).count();
        cout << "\n==> sorted in " << elapsed / 1000000000.0 << " seconds <==";
        
        inputFile.close();
    } 
    else {
        cout << "Error while opening file. Are you in the 'cpp/' directory?" << endl;
        return -1;
    }

    return 0;
}