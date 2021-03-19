/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2021-01-02 13:44:34
 * @LastEditTime: 2021-01-02 14:58:21
 */
// Search.cpp : 定义控制台应用程序的入口点。
//

//#include "stdafx.h"
#include <iostream>

using namespace std;

struct RecType{
	int key;
};

int BinSearch(RecType R[],int n,int k){
	int low = 0,high = n - 1,mid;
	while(low <= high){
		cout<<"low = "<<low<<",high = "<<high<<endl;
		cout<<"low <= high"<<endl;
		mid = (low + high) / 2;
		cout<<"mid = (low + high) / 2 = "<<mid<<endl;
		if(k == R[mid].key){
			cout<<"k = mid"<<endl;
			cout<<"The number is mid->key"<<endl;
			return mid + 1;
		}
		if(k < R[mid].key){
			cout<<"k < mid"<<endl;
			cout<<"high = mid - 1"<<endl;
			high = mid - 1;
		}
		else{
			cout<<"k > mid"<<endl;
			cout<<"low = mid + 1"<<endl;
			low =mid + 1;
		}
	}
	return 0;
}


int main(){
	RecType R[10] = {1,2,3,4,5,6,7,8,9,10};
	cout<<"The number finded is "<<BinSearch(R,10,9)<<endl;
	system("pause");
	return 0;
}
