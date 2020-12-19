/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-11-11 18:00:28
 * @LastEditTime: 2020-11-29 19:17:31
 */
// 137.cpp : 定义控制台应用程序的入口点。
//

//#include "stdafx.h"
#include <iostream>

using namespace std;

struct LinkNode{
	char data;
	LinkNode* next;
};

void CreateList(LinkNode* &L,char a[],int n){
	LinkNode *s,*r;
	L = new LinkNode;
	r = L;
	for(int i = 0;i < n;i++){
		s = new LinkNode;
		s->data = a[i];
		r->next = s;
		r = s;
	}
	r->next = L;
}

void InitList(LinkNode* &L){
	L = new LinkNode;
	L->next = L;
}

void DestoryList(LinkNode* &L){
	LinkNode *pre = L,*p = L->next;
    while(p != L){
		delete pre;
		pre = p;
		p = pre->next;
	}
	delete pre;
	cout<<"List Deleted."<<endl;
}

bool ListEmpty(LinkNode* L){
	return(L->next == L);
}

int ListLength(LinkNode* L){
    int n = 1;
	LinkNode* p = L->next;
	while(p->next != L){
		n++;
		p = p->next;
	}
	return n;
}

void DispList(LinkNode* L){
    LinkNode *p = L->next;
	cout<<"The List: ";
	while(p != L){
		cout<<p->data<<ends;
        p = p->next;
	}
	cout<<endl;
}

bool GetElem(LinkNode* L,int i,char &e){
	int j = 1;
	LinkNode *p = L->next;
	if(i <= 0){
		return false;
	}
	while(j < i && p != L){
		j++;
		p = p->next;
	}
	if(p == L){
		return false;
	}
	else{
		e = p->data;
		return true;
	}
}

int LocateElem(LinkNode* L,char e){
	int i = 1;
	LinkNode *p = L->next;
	while(p != L && p->data != e){
		p = p->next;
		i++;
	}
	if(p == L){
	    cout<<"error ";
		return 0;
	}
	else{
	    return i;
	}
}

bool ListInsert(LinkNode* &L,int i, char e){
	int j = 1;
	LinkNode *p = L->next,*s;
	if(i <= 0){
	    return false;
	}
    while(j < i-1 && p != L){
		j++;
		p = p->next;
	}
	if(p == L){
		return false;
	}
	else{
		s = new LinkNode;
		s->data = e;
		s->next = p->next;
		p->next = s;
		return true;
	}
}

bool ListDelete(LinkNode* &L,int i,char &e){
	int j = 1;
	LinkNode *p = L->next,*q;
	if(i <= 0){
        return false;
	}
	while(j < i-1 && p != L){
		j++;
		p = p->next;
	}
	if(p == L){
		return false;
	}
	else{
		q = p->next;
		if(q == L){
			return false;
		}
		e = q->data;
		p->next = q->next;
		delete q;
		return true;
	}
}


int main()
{
	LinkNode* list1;
	InitList(list1);

	cout<<"Is the List Empty? 1:true , 0:false"<<endl;
	cout<<ListEmpty(list1)<<endl;

	char a[5]={'a','b','c','d','e'};
	CreateList(list1,a,5);

	cout<<"The List: ";
	DispList(list1);

	cout<<"The Length of the list is ";
	cout<<ListLength(list1)<<endl;

	cout<<"Is the List Empty? 1:true , 0:false"<<endl;
	cout<<ListEmpty(list1)<<endl;

	char e;
	int m,n;

	cout<<"Insert the elem`s number: ";
	cin>>m;
	n = GetElem(list1,m,e);
	if(n == 0){
		cout<<"Task Failed!"<<endl;
	}
	else{
		cout<<"The Elem is "<<e<<endl;
	}

	cout<<"'a' is in the "<<LocateElem(list1,'a')<<endl;
	cout<<"'z' is in the "<<LocateElem(list1,'z')<<endl;

	cout<<"Insert the number you want to insert: ";
	cin>>m;
	e = 'f';
	n = ListInsert(list1,m,e);
	if(n == 0){
		cout<<"Task Failed!"<<endl;
	}
	else{
		cout<<"Task Success!"<<endl;
		cout<<"The List: ";
	    DispList(list1);
	}

	cout<<"Inster the number you want to delete: ";
	cin>>m;
	n = ListDelete(list1,m,e);
	if(n == 0){
		cout<<"Task Failed!"<<endl;
	}
	else{
		cout<<"Task Success!"<<endl;
		cout<<m<<" deleted.";
		cout<<"The List: ";
	    DispList(list1);
	}

    DestoryList(list1);

	system("pause");
	return 0;
}
