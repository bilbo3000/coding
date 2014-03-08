#include <iostream> 
#include <stdio.h> 

using namespace std; 

int main() {
    FILE * fp;
    
    // Read  
    string inputFile = "myInputFile.txt"; 
    fp = fopen(inputFile.c_str(), "r");
    char c; 
    
    while ((c = fgetc(fp)) != EOF) {
        cout << c;  
    }
    
    fclose(fp);  
    
    // Write
    string outputFile = "myOutputFile2.txt";
    string outputString = "Hello World!";  
    fp = fopen(outputFile.c_str(), "w"); 
    fprintf(fp, "%s", outputString.c_str()); 
    
    fclose(fp); 
}
