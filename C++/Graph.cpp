// Graph.cpp : 定义控制台应用程序的入口点。
//

//#include "stdafx.h"
#include <iostream>
#include <iomanip>
#define MAXV 6
#define INF 65535

using namespace std;

struct VertexGraph{
	int no;
	char info;
};

struct MatGraph{
	int edges[MAXV][MAXV];
	int n,e;
	VertexGraph vexs[MAXV];
};

struct ArcNode{
	int adjvex;
	ArcNode *nextarc;
	int weight;
};

struct VNode{
	char info;
	ArcNode *firstarc;
};

struct AdjGraph{
	VNode adjlist[MAXV];
	int n,e;
};

void CreateAdj(AdjGraph *&G,int A[MAXV][MAXV],int n,int e){
	if(n > 6){
		cerr<<"Error. Martix is overflow."<<endl;
	}
	int i,j;
	ArcNode *p;
	G = new AdjGraph;
	for(i = 0;i < n;i++){
		G->adjlist[i].firstarc = nullptr;
	}
	for(i = 0; i < n;i++){
		for(j = n - 1;j >= 0;j--){
			if(A[i][j] != 0 && A[i][j] != INF){
				p = new ArcNode;
				p->adjvex = j;
				p->weight = A[i][j];
				p->nextarc = G->adjlist[i].firstarc;
				G->adjlist[i].firstarc = p;
			}
		}
	}
	G->n = n;
	G->e = e;
}

void DispAdj(AdjGraph *G){
	int i;
	ArcNode *p;
	for(i = 0;i < G->n;i++){
		p = G->adjlist[i].firstarc;
		cout<<setw(3)<<i<<":";
		while(p != nullptr){
			cout<<setw(3)<<p->adjvex<<"["<<p->weight<<"]";
			p = p->nextarc;
		}
		cout<<endl;
	}
}

void DestoryAdj(AdjGraph *&G){
	ArcNode *pre,*p;
	for(int i = 0;i < G->n;i++){
		pre = G->adjlist[i].firstarc;
		if(pre != nullptr){
			p = pre->nextarc;
			while(p != nullptr){
				delete pre;
				pre = p;
				p = p->nextarc;
			}
			delete pre;
		}
	}
	delete G;
	cout<<"Graph deleted."<<endl;
}

int main()
{
	int A[MAXV][MAXV] = {0,5,INF,7,INF,INF,INF,0,4,INF,INF,INF,8,INF,0,INF,INF,9,INF,INF,5,0,INF,6,INF,INF,INF,5,0,INF,3,INF,INF,INF,1,0};
	cout<<"The Adjacency Matrix is: "<<endl;
	for(int i = 0;i < MAXV;i++){
		for(int j = 0;j < MAXV;j++){
			if(A[i][j] == INF){
				cout<<"∞"<<ends;
			}
			else{
				cout<<setw(2)<<A[i][j]<<ends;
			}
		}
		cout<<endl;
	}

	AdjGraph *G;
	int n = 6,e = 10;
	CreateAdj(G,A,n,e);
	DispAdj(G);
	DestoryAdj(G);

	system("pause");
	return 0;
}
