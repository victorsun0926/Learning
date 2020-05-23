/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-05-14 10:42:37
 * @LastEditTime: 2020-05-14 10:55:40
 */
#include <iostream>

using namespace std;

void time(int *year, int *mon, int *day);
bool prime(int n);

int main(){
    int i,j,k;
    int* y=&i;
    int* m=&j;
    int* d=&k;
    cout<<"Input Year,Month,Day: ";
    cin>>i>>j>>k;
    time(y,m,d);
    system("pause");
    return 0;
}

void time(int *year, int *mon, int *day){
    int a[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int sum = *day;
    for(int i = 1; i <= *mon-1; i++){
	    sum += a[i];
	}
    if(*mon >= 3 && prime(*year)){
	    sum ++;
    }
    cout<<"The Day of One Year is "<<sum<<endl;
}

bool prime(int n){
    return (n % 4 == 0 && n % 100 != 0) || (n % 400 == 0);
}
