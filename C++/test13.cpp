/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-24 20:54:21
 * @LastEditTime: 2020-04-24 21:00:28
 */
#include <iostream>

using namespace std;

int main(){
    string s1,s2;
    cout<<"s1=";
    cin>>s1;
    cout<<"s2=";
    cin>>s2;
    cout<<"The Length of S1 ="<<s1.size()<<endl;
    cout<<"The Length of S2 ="<<s2.size()<<endl;
    if(s1.size()>=s2.size()){
        cout<<"S1+S2="<<s2<<s1<<endl;
    }
    else{
        cout<<"S1+S2="<<s1<<s2<<endl;
    }
    system("pause");
    return 0;
}
