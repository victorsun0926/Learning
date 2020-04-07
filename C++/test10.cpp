/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-07 13:04:55
 * @LastEditTime: 2020-04-07 13:43:32
 */
#include <iostream>
using namespace std;

int aliquot(int n1, int n2, int n3){
    if(n1>n2){
        int tmp;
        tmp=n1;
        n1=n2;
        n2=tmp;
    }
    else if(n1==0&&n2==0&&n3==0){
        return 0;
    };

    int n=0;
    for(int i=n1;i<=n2;i++){
        if(i%n3==0){
        n+=1;
        }
    }
    cout<<n<<endl;
    return 0;
}

int main(){
    int n1,n2,n3,m;
    cin>>n1>>n2>>n3;
    aliquot(n1,n2,n3);
    system("pause");
    return 0;
}
