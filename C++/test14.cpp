/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-05-14 09:54:51
 * @LastEditTime: 2020-05-14 10:40:31
 */
#include <iostream>
#include <numeric>

using namespace std;

int input(int s[]);
void statistics(int n, int s[], int *max, int *min, float *avg);

int main(){
    int s[20]={0};
    int n=0,j=0,k=10000;
    float l=0;
    n=input(s);
    int* a=&j;
    int* i=&k;
    float* g=&l;
    statistics(n,s,a,i,g);
    system("pause");
    return 0;
}

int input(int s[]){
    int i,c;
    for(i=0;i<=20;i++){
        cin>>c;
        if(c==0){
            break;
        }
        else{
            s[i]=c;
        }
    }
    return i;
}

void statistics(int n, int s[], int *max, int *min, float *avg){
    for(int x=0;x<=n;x++){
        if(s[x]>*max){
            max=&(s[x]);
        }
        if(s[x]!=0 && s[x]<=*min){
            min=&(s[x]);
        }
    }
    int y;
    y=accumulate(s,s+n,0);
    cout<<"Max="<<*max<<endl<<"Min="<<*min<<endl<<"Avg="<<(y/n);
}
