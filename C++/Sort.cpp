/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2021-01-02 15:05:23
 * @LastEditTime: 2021-01-02 15:21:20
 */
//#include "stdafx.h"
#include <iostream>

using namespace std;

void InsSort(int R[],int n){
    int i,j;
    int tmp;
    for(i = 1;i < n;i++){
        if(R[i] < R[i-1]){
            tmp = R[i];
            j = i - 1;
            do{
                R[j+1] = R[j];
                j--;
            } while(j >= 0 && R[j] > tmp);
            R[j+1] = tmp;
        }
    }
}

void SelSort(int R[],int n){
    int i,j,k;
    for(i = 0;i < n-1;i++){
        k = i;
        for(j = i + 1;j < n;j++){
            if(R[j] < R[k]){
                k = j;
            }
            if(k != i){
                swap(R[i],R[k]);
            }
        }
    }
}

int main(){
    int R[10] = {9,8,7,6,5,4,3,2,1,0};
    cout<<"Origin:"<<ends;
    for(int x = 0;x < 10;x++){
        cout<<R[x]<<ends;
    }
    cout<<endl;
    InsSort(R,10);
    cout<<"Sorted:"<<ends;
    for(int x = 0;x < 10;x++){
        cout<<R[x]<<ends;
    }
    cout<<endl;

    int r[10] = {8,5,2,7,4,1,9,6,3,0};
    cout<<"Origin:"<<ends;
    for(int x = 0;x < 10;x++){
        cout<<r[x]<<ends;
    }
    cout<<endl;
    SelSort(r,10);
    cout<<"Sorted:"<<ends;
    for(int x = 0;x < 10;x++){
        cout<<r[x]<<ends;
    }
    cout<<endl;

    system("pause");
    return 0;
}
