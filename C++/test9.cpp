/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-03-31 14:24:02
 * @LastEditTime: 2020-03-31 15:12:26
 */
#include <iostream>
using namespace std;
int main(){
    int n=3;
    for(int i=1;i<=4;i++){
        for(int x=1;x<=n;x++){
            cout<<" ";
        }
        for(int y=1;y<=2*i-1;y++){
            cout<<"*";
        }
        cout<<endl;
        --n;
    }
    int j=1,k=5;
    for(int i=1;i<=3;i++){
        for(int x=1;x<=j;x++){
            cout<<" ";
        }
        for(int y=1;y<=k;y++){
            cout<<"*";
        }
        cout<<endl;
        ++j;
        k-=2;
    }
    system("pause");
    return 0;
}
