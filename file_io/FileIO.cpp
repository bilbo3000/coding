#include <iostream> 
#include <string>
#include <fstream>

using namespace std; 

int main(int argc, char* argv[]){
	// Read
	string inputFile = "myInputFile.txt"; 
	ifstream inputStream(inputFile.c_str());
    while (inputStream.good()){
	    string line; 
	    getline(inputStream, line); 
	    cout << line << endl; 
    }
    inputStream.close();  

    // Write
    string outputFile = "myOutputFile.txt";
    ofstream outputStream(outputFile.c_str());
    outputStream.open(outputFile.c_str()); 
    outputStream << "Hello World" << endl; 
    outputStream.close();  
    
    // Remove
    string tempFile = "ToBeRemoved.txt"; 
    remove(tempFile.c_str()); 
}

