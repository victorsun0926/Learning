// BinaryTree.cpp : 定义控制台应用程序的入口点。
//

//#include "stdafx.h"
#include <iostream>
#define MaxSize 10

using namespace std;

struct BTNode{
	char data;
	BTNode* lchild;
	BTNode* rchild;
};

void CreateBTree(BTNode* &b,const char* str){
	BTNode *st[MaxSize],*p;
	int top = -1,k,j = 0;
	char ch;
	b = nullptr;
	ch = str[j];
	while(ch != '\0'){
		switch(ch){
		 case '(':
			 top++;
			 st[top] = p;
			 k = 1;
			 break;
		 case ')':
			 top--;
			 break;
		 case ',':
			 k = 2;
			 break;
		 default:
			 p = new BTNode;
			 p->data = ch;
			 p->lchild = p->rchild = nullptr;
			 if(b == nullptr){
				 b = p;
			 }
			 else{
				 switch(k){
				 case 1:
					 st[top]->lchild = p;
					 break;
				 case 2:
					 st[top]->rchild = p;
					 break;
				 }
			 }
		}
		j++;
		ch = str[j];
	}
}

void DestoryBTree(BTNode* &b){
	if(b != nullptr){
		DestoryBTree(b->lchild);
		DestoryBTree(b->rchild);
		delete b;
	}
}

BTNode* FindNode(BTNode *b,char x){
	BTNode *p;
	if(b == nullptr){
		return nullptr;
	}
	if(b->data == x){
		return b;
	}
	else{
	    p = FindNode(b->lchild,x);
	    if(p != nullptr){
			return p;
		}
		else{
			return FindNode(b->rchild,x);
		}
	}
}

BTNode* LchildNode(BTNode *p){
	return p->lchild;
}
BTNode* RchildNode(BTNode *p){
	return p->rchild;
}

int BTHeight(BTNode *b){
	int lchildh,rchildh;
	if(b == nullptr){
		return 0;
	}
	else{
		lchildh = BTHeight(b->lchild);
		rchildh = BTHeight(b->rchild);
		return (lchildh > rchildh)? (lchildh + 1):(rchildh + 1);
	}
}

void DispBTree(BTNode *b){
	if(b != nullptr){
		cout<<b->data;
		if(b->lchild != nullptr || b->rchild != nullptr){
			cout<<"(";
			DispBTree(b->lchild);
			if(b->rchild != nullptr){
				cout<<",";
				DispBTree(b->rchild);
				cout<<")";
			}
		}
	}
}

int Nodes(BTNode *b){
	if(b == nullptr){
		return 0;
	}
	else{
		return Nodes(b->lchild) + Nodes(b->rchild) +1;
	}
}

void DispLeaf(BTNode *b,int &n){
	if(b != nullptr){
		if(b->lchild == nullptr && b->rchild == nullptr){
			cout<<b->data<<ends;
			n++;
		}
		DispLeaf(b->lchild,n);
		DispLeaf(b->rchild,n);
	}
}

void PreOrder(BTNode *b){
	if(b != nullptr){
		cout<<b->data<<ends;
		PreOrder(b->lchild);
		PreOrder(b->rchild);
	}
}

void InOrder(BTNode *b){
	if(b != nullptr){
		PreOrder(b->lchild);
		cout<<b->data<<ends;
		PreOrder(b->rchild);
	}
}

void PostOrder(BTNode *b){
	if(b != nullptr){
		PreOrder(b->lchild);
		PreOrder(b->rchild);
		cout<<b->data<<ends;
	}
}

int main(){
	BTNode *b,*t,*c;
	CreateBTree(b,"A(B(D,E(H(J,K(L,M(,N))))),C(F,G(,I)))");

    cout<<"The BTree: ";
    DispBTree(b);
    cout<<endl;

	t = FindNode(b,'H');
	if(t == nullptr){
		cout<<"Error,Node is not exist."<<endl;
	}
	else{
		c = LchildNode(t);
		cout<<"Lchild: "<<c->data<<endl;
		c = RchildNode(t);
		cout<<"Rchild: "<<c->data<<endl;
	}

	cout<<"The Depth of the BTree is "<<BTHeight(b)<<endl;

	cout<<"The amount of the node is "<<Nodes(b)<<endl;

	int n = 0;
	cout<<"The Leaf: ";
	DispLeaf(b,n);
	cout<<endl<<"The amount of the Leaf is "<<n<<endl;

	cout<<"The PreOrder: ";
	PreOrder(b);

	cout<<endl<<"The InOrder: ";
	InOrder(b);

	cout<<endl<<"The PostOrder: ";
	PostOrder(b);
	cout<<endl;

	DestoryBTree(b);

	system("pause");
	return 0;
}
