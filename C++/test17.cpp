/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-05-27 19:37:13
 * @LastEditTime: 2020-05-27 20:10:15
 */
#include <iostream>
#include <iomanip>
#define N 5

using namespace std;

struct Student{
	char num[5];
	char name[20];
	int score[3];
	float Average;
};

int Input(struct Student S[],int n)
{
	int i;
	for(i=0;i<n;i++){
		cin>>S[i].num>>S[i].name>>S[i].score[0]>>S[i].score[1]>>S[i].score[2];
        S[i].Average=(S[i].score[0]+S[i].score[1]+S[i].score[2])/3;
	}
	for(i=0;i<n;i++){
		cout<<S[i].num<<" "<<S[i].name<<" "<<S[i].score[0]<<" "<<S[i].score[1]<<" "<<S[i].score[2]<<" "<<S[i].Average<<endl;
	}

}

int main(){
	int n;
	cout<<"N=";
	cin>>n;
	struct Student *S = new Student[n];
	Input(S,n);
	system("pause");
	return 0;
}
