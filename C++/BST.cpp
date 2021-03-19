// BST.cpp : 定义控制台应用程序的入口点。
//

//#include "stdafx.h"
#include <iostream>

using namespace std;

//二叉排序树的定义；
struct BSTnode{
	int key;
	BSTnode *lchild,*rchild;
};

//栈的定义；
struct SqStack{
    BSTnode* data[11];
    int top;
};

void InitStack(SqStack* &s){
    s = new SqStack;
    s->top = -1;
}

bool Push(SqStack* &s,BSTnode *e){
    if(s->top == 11){
        return false;
    }
    s->top++;
    s->data[s->top] = e;
    return true;
}

bool Pop(SqStack* &s,BSTnode* &e){
    if(s->top == -1){
        return false;
    }
    e = s->data[s->top];
    s->top--;
    return true;
}

void DestoryStack(SqStack* &s){
    delete s;
}

bool StackEmpty(SqStack* s){
    return(s->top == -1);
}

bool InsertBST(BSTnode* &bt,int k){
	if(bt == nullptr){
		bt = new BSTnode;
		bt->key = k;
		bt->lchild = bt->rchild = nullptr;
		return true;
	}
	if(k == bt->key){
		return false;
	}
	if(k < bt->key){
		return InsertBST(bt->lchild,k);
	}
	else{
		return InsertBST(bt->rchild,k);
	}
}

BSTnode* CreateBST(int A[],int n){
	BSTnode *bt = nullptr;
	int i = 0;
	while(i < n){
		InsertBST(bt,A[i]);
		i++;
	}
	return bt;
}

void DispBST(BSTnode *b){
	if(b != nullptr){
		cout<<b->key;
		if(b->lchild != nullptr || b->rchild != nullptr){
			cout<<"(";
			DispBST(b->lchild);
			if(b->rchild != nullptr){
				cout<<",";
			}
			DispBST(b->rchild);
			cout<<")";
		}
	}
}

void Delb(BSTnode *p,BSTnode* &r){
	BSTnode *q;
	if(r->rchild != nullptr){
		Delb(p,r->rchild);
	}
	else{
		p->key = r->key;
		q = r;
        r = r->lchild;
		delete q;
	}
}

void Dela(BSTnode* &p){
	BSTnode *q;
	if(p->rchild == nullptr){
		q = p;
		p = p->lchild;
		delete q;
		return;
	}
	if(p->lchild == nullptr){
		q = p;
		p = p->rchild;
		delete q;
	}
	else{
		Delb(p,p->lchild);
	}
}

bool DelBST(BSTnode* &bt,int k){
	if(bt != nullptr){
		if(k < bt->key){
			return DelBST(bt->lchild,k);
		}
		if(k > bt->key){
			return DelBST(bt->rchild,k);
		}
		if(k = bt->key){
			Dela(bt);
			return true;
		}
		return false;
	}
	else{
		return false;
	}
}

void SearchBST(BSTnode *bt,int k){
	cout<<"Searching node "<<bt->key<<endl;
	if(bt == nullptr || bt->key == k){
		cout<<"Found."<<endl;
		return;
	}
	if(k < bt->key){
		return SearchBST(bt->lchild,k);
	}
	else{
		return SearchBST(bt->rchild,k);
	}
}

void BSTOrder(BSTnode *b,int k){
	BSTnode *p;
	SqStack *st;
	InitStack(st);
	if(b != nullptr){
		Push(st,b);
		while(!StackEmpty(st)){
			Pop(st,p);
			cout<<"Checking "<<p->key<<endl;
			if(p->key == k){
		        cout<<"Find "<<p->key<<endl;
			}
            if(p->key != k){
				cout<<"Not Find"<<endl;
			}
			if(p->rchild != nullptr){
				Push(st,p->rchild);
			}
			if(p->lchild != nullptr){
				Push(st,p->lchild);
			}
		}
		cout<<endl;
	}
	DestoryStack(st);
}

bool IsBST(BSTnode *b){
    if(b != nullptr){
        if(b->lchild == nullptr && b->rchild == nullptr){
            return true;
		}
		if(b->lchild != nullptr && b->rchild == nullptr){
			if(b->lchild->key > b->key){
				return false;
			}
			return IsBST(b->lchild);
		}
		if(b->lchild == nullptr && b->rchild != nullptr){
			if(b->rchild->key < b->key){
				return false;
			}
			return IsBST(b->rchild);
		}
        else{
			if((b->lchild->key > b->key) || (b->rchild->key < b->key)){
				return false;
			}
			return (IsBST(b->rchild) && IsBST(b->lchild));
		}
	}
	else{
		return true;
	}
}


int main(){
    BSTnode *bt;
	int A[10]={4,9,0,1,8,6,3,5,2,7};
	bt = CreateBST(A,10);
    DispBST(bt);
    cout<<endl<<"bt is BST? 1:true 0:false "<<IsBST(bt)<<endl;
    SearchBST(bt,6);
    BSTOrder(bt,6);
    DelBST(bt,4);
	DispBST(bt);
	cout<<endl;
	DelBST(bt,5);
	DispBST(bt);
    system("pause");
	return 0;
}
