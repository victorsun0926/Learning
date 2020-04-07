/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-04-07 13:46:17
 * @LastEditTime: 2020-04-07 18:31:48
 */
#include <iostream>

using namespace std;
int *input(int s[]);
int average(int n, int s[]);
int count(int avg, int n, int s[]);

int main(){
    while(1){
        int x=0,avg,cou;
        int s[20]={0};
        input(s);
        while(s[x++]!=0);
        x-=1;
        if(x==0){
            system("pause");
            return 0;
        }
        avg=average(x,s);
        cou=count(avg,x,s);
        cout<<x<<" "<<avg<<" "<<cou<<endl;
    }
}

int *input(int s[]){
    int i,c;
    for(i=0;i<=20;i++){
        cin>>c;
        if(c==0){
            break;
        }
        s[i]=c;
    }
    return s;
}

int average(int n, int s[]){
    int sum=0,avg=0;
    for(int a=0;a<=n;a++){
        sum+=s[a];
    }
    avg=sum/n;
    return avg;
}

int count(int avg, int n, int s[]){
    int m=0;
    for(int b=0;b<=n;b++){
        if(s[b]>avg){
        m+=1;
        }
    }
    return m;
}
