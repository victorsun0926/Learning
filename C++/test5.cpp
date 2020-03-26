/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-03-26 09:13:11
 * @LastEditTime: 2020-03-26 09:39:58
 */
#include <iostream>
#include <math.h>
using namespace std;
int main(){
    int x,i;
    cout<<"Please insert a number:";
    cin>>x;
    for(i=2;i<=sqrt(x);i++){
    if(x%i==0){
        break;
    }
    }

    if(i<=sqrt(x)){
    cout<<x<<" is a prime number."<<endl;
    }
    else{
    cout<<x<<" is not a prime number."<<endl;
    }
    system("pause");
    return 0;
}
