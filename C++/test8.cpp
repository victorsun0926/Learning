/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-03-31 13:24:39
 * @LastEditTime: 2020-03-31 14:23:01
 */
#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
using namespace std;
int main(){
    cout<<"N=";
    int n;
    cin>>n;
    if(n<=0&&n>10){
        cout<<"Number Error.";
    }
    else{
        int i;
        vector<int> p(n);
        for(i=0;i<n;i++){
            cout<<"n"<<(i+1)<<"=";
            cin>>p[i];
    }
    int max = *max_element(p.begin(), p.end());
    int min = *min_element(p.begin(), p.end());
    int avg = accumulate(p.begin(), p.end(), 0) / p.size();
    cout<<"Max="<<max<<endl<<"Min="<<min<<endl<<"Avg="<<avg<<endl;
    }
    system("pause");
    return 0;
}
