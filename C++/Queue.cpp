/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-11-30 18:55:54
 * @LastEditTime: 2020-11-30 19:39:58
 */
// 137.cpp : 定义控制台应用程序的入口点。
//

//#include "stdafx.h"
#include <iostream>

using namespace std;

struct SqQueue{
    char data[9];
    int front,rear;
};

void InitQueue(SqQueue* &q){
    q = new SqQueue;
    q->front = q->rear = 0;
}

void DestoryQueue(SqQueue* &q){
    delete q;
    cout<<"Queue Destoried."<<endl;
}

bool QueueEmpty(SqQueue* q){
    return(q->front == q->rear);
}

bool enQueue(SqQueue* &q,char e){
    if((q->rear + 1) % 9 == q->front){
        return false;
    }
    q->rear = (q->rear + 1) % 9;
    q->data[q->rear] = e;
    return true;
}

bool deQueue(SqQueue* &q,char &e){
    if(q->front == q->rear){
        return false;
    }
    q->front = (q->front + 1) % 9;
    e = q->data[q->front];
    return true;
}

int main(){
    SqQueue* q;
    InitQueue(q);

    cout<<"Is Queue Empty? 1:True; 0:False; "<<endl;
    cout<<QueueEmpty(q)<<endl;

    char a;

    for(a = 'a';a <= 'c';a++){
        enQueue(q,a);
    }

    deQueue(q,a);
    cout<<"A elem: "<<a<<endl;

    for(a = 'd';a <= 'f';a++){
        if(enQueue(q,a) == 0){
            cout<<"Task Failed! Queue is Full. "<<endl;
        }
    }

    while(deQueue(q,a) != 0){
        cout<<a<<ends;
    }

    cout<<endl;
    DestoryQueue(q);

    system("pause");
    return 0;
}
