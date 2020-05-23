/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-24 20:17:12
 * @LastEditTime: 2020-04-24 20:53:09
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int m,n;
    cout<<"N=";
    cin>>n;

    vector<int> x,j,o;
    for(int i=1;i<=n;i++){
        cout<<"n"<<i<<"=";
        cin>>m;
        x.push_back(m);
        if(m%2==0){
        o.push_back(m);
        }
        else{
        j.push_back(m);
        }
    }

    sort(j.begin(),j.end());
    sort(o.begin(),o.end(),greater<int>());

    cout<<"Odd=";
    for(int k=0;k<j.size();k++){
        cout<<j[k]<<" ";
    }
    cout<<"Even=";
    for(int l=0;l<o.size();l++){
        cout<<o[l]<<" ";
    }

    system("pause");
    return 0;
}
