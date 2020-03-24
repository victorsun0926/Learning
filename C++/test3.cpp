/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-03-24 14:37:39
 * @LastEditTime: 2020-03-24 14:38:03
 */
#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float r1,r2,r3,r4,r5,m,R;
	cout<<"please enter r1,r2,r3,r4,r5:";
	cin>>r1>>r2>>r3>>r4>>r5;
	m=r3*(r4+r5)/(r3+r4+r5);
	R=r1*(r2+m)/(r1+r2+m);
	cout<<"R="<<R<<endl;
    system("pause");
	return 0;
}
