/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-11-30 17:23:00
 * @LastEditTime: 2020-11-30 18:47:49
 */
// 137.cpp : 定义控制台应用程序的入口点。
//

//#include "stdafx.h"
#include <iostream>

using namespace std;

struct SqStack{
    char data[6];
    int top;
};

void InitStack(SqStack* &s){
    s = new SqStack;
    s->top = -1;
}

void DestoryStack(SqStack* &s){
    delete s;
    cout<<"Stack Deleted. "<<endl;
}

bool StackEmpty(SqStack* s){
    return(s->top == -1);
}

bool Push(SqStack* &s,char e){
    if(s->top == 6){
        return false;
    }
    s->top++;
    s->data[s->top] = e;
    return true;
}

bool Pop(SqStack* &s,char &e){
    if(s->top == -1){
        return false;
    }
    e = s->data[s->top];
    s->top--;
    return true;
}

int main(){
    SqStack* s;
    InitStack(s);

    cout<<"Is the stack empty? 1:Empty; 0:Not Empty;"<<endl;
    cout<<StackEmpty(s)<<endl;

    for(char e = 'a';e <= 'e';e++){
        Push(s,e);
    }

    cout<<"Is the stack empty? 1:Empty; 0:Not Empty;"<<endl;
    cout<<StackEmpty(s)<<endl;

    int n;
    cout<<"Input number you want to put out: ";
    cin>>n;
    cout<<"The outed Stack: ";
    for(int i = 0;i < n;i++){
        char e;
        if(Pop(s,e) == 0){
        cout<<"Task Failed, Stack is Empty!!"<<endl;
        }
        else{
        cout<<e<<ends;
        }
    }
    cout<<endl;

    cout<<"Is the stack empty? 1:Empty; 0:Not Empty;"<<endl;
    cout<<StackEmpty(s)<<endl;

    DestoryStack(s);

    system("pause");
    return 0;
}
