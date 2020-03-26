/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-03-26 09:42:18
 * @LastEditTime: 2020-03-26 10:04:25
 */
#include <iostream>
using namespace std;
int main(){
    int x;
    cout<<"Press score:";
    cin>>x;
    cout<<"Score="<<x<<endl;
    if(x<0){
        cout<<"Score is less than 0, Error."<<endl;
    }
    else if(x>100){
        cout<<"Score is more than 100, Error."<<endl;
    }
    else{
        switch(x/20){
            case 0:
            cout<<"Grade=E"<<endl;
            break;
            case 1:
            cout<<"Grade=D"<<endl;
            break;
            case 2:
            cout<<"Grade=C"<<endl;
            break;
            case 3:
            cout<<"Grade=B"<<endl;
            break;
            case 4:
            cout<<"Grade=A"<<endl;
            break;
            case 5:
            cout<<"Grade=A"<<endl;
            break;
        }
    }
    system("pause");
    return 0;
}
