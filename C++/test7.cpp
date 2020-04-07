/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-03-31 12:57:40
 * @LastEditTime: 2020-03-31 13:22:38
 */
#include <iostream>
#include <math.h>
using namespace std;
int main(){
    int i,y,sum=0;
    for(i=1;i<=10;i++){
    y=i*pow(-1,i);
    sum=sum+y;
    }
    cout<<"Sum="<<sum<<endl;
    system("pause");
    return 0;
}
