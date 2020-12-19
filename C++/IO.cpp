/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-12-15 15:17:39
 * @LastEditTime: 2020-12-15 16:01:11
 */
//#include "stdafx.h"
#include <iostream>
#include <fstream>
using namespace std;

int main(){
    ofstream ofile;
    ofile.open("d:/abc.txt",ios::out);
    char *a,b;
    cout<<"Please input some number, insert 0 to end: ";
    cin.getline(a,20,'0');
    for(int i = 0;a[i] != '\0';i++){
        ofile.put(a[i]);
    }
    ofile.close();
    cout<<endl;

    ifstream ifile;
    ifile.open("d:/abc.txt",ios::in);
    cout<<"The number saved in abc.txt: ";
    while(ifile.get(b)){
        cout<<b<<ends;
    }
    cout<<endl;
    ifile.close();
    system("pause");
    return 0;
}
