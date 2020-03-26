/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-03-26 08:34:22
 * @LastEditTime: 2020-03-26 09:11:54
 */
#include <iostream>
using namespace std;
int main(){
    int x,y;
    cout<<"Please insert x=";
    cin>>x;
    if(x<1){
        y=x;
    }
    else if(x>=1&&x<10){
        y=2*x-1;
    }
    else{
        y=3*x-11;
    }
    cout<<"X="<<x<<endl<<"Y="<<y<<endl;
    system("pause");
    return 0;
}
