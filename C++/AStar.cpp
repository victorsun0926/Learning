/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926
 * @CreateTime: 2021-04-08 00:07:52
 * @LastEditTime: 2021-04-08 02:20:57
 */
#include <iostream>
#include <vector>

using namespace std;

//地图大小，Y为行，X为列
#define mapY 10
#define mapX 10
//代价设定，XY为直线代价，Tilt为斜线代价
#define valueXY 10
#define valueTilt 14

//点结构
struct Point {
    int y,x;
    int f,g,h;
    void setF(){
        f = g + h;
    }
    bool operator==(const Point&b){
        if(x == b.x && y == b.y){
            return true;
        }
        return false;
    }
};

//枚举点的八个方向
enum direct{p_up, p_down, p_left, p_right, p_lup, p_ldown, p_rup, p_rdown};

//树结点类型
struct TreeNode {
    Point p;
    vector<TreeNode*> childs;
    TreeNode* parent;
};

void nodeInit(TreeNode* t){
    t->p = {0};
    t->childs = {0};
    t->parent = nullptr;
}

//计算H（当前点到终点的直线距离）
int getH(Point end, Point current){
    int x = ((current.x > end.x) ? (current.x-end.x) : (end.x-current.x));
    int y = ((current.y > end.y) ? (current.y-end.y) : (end.y-current.y));
    return (x + y)*valueXY;
}

//判断是否为可行点
bool needAdd(Point current, int map[mapY][mapX], bool visited[mapY][mapX]){
    if(current.y >= mapY || current.y < 0) return false;
    if(current.x >= mapX || current.x < 0) return false;
    if(map[current.y][current.x] == 1) return false;
    if(visited[current.y][current.x] == true) return false;
    return true;
}

int main(){
    //地图，0为空地，1为墙
    int map[mapY][mapX] = {
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,0,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 },
        { 0,0,0,0,0,1,0,0,0,0 }
    };

    //记录走过的点
    bool visited[mapY][mapX] = {0};

    //是否完成路径
    bool findEnd = false;

    //起点和终点
    Point begin = {2,2,0,0,0};
    Point end = {4,8,0,0,0};

    //由起点出发
    visited[begin.y][begin.x] = true;

    //建立一棵树，根是起点
    TreeNode* tRoot = new TreeNode;
    nodeInit(tRoot);
    tRoot->p = begin;
    TreeNode* tCurrent = tRoot;
    TreeNode* tChild = nullptr;

    //存储待比较f值的结点
    vector<TreeNode*> buff;
    vector<TreeNode*>::iterator it;
    vector<TreeNode*>::iterator itMin;

    while(1){
        //遍历当前点八个方向的点
        for(int i = 0;i < 8;i++){
            tChild = new TreeNode;
            nodeInit(tChild);
            tChild->p = tCurrent->p;
            switch(i){
                case p_up:
                    tChild->p.y--;
                    tChild->p.g += valueXY;
                    break;
                case p_down:
                    tChild->p.y++;
                    tChild->p.g += valueXY;
                    break;
                case p_left:
                    tChild->p.x--;
                    tChild->p.g += valueXY;
                    break;
                case p_right:
                    tChild->p.x++;
                    tChild->p.g += valueXY;
                    break;
                case p_lup:
                    tChild->p.y--;
                    tChild->p.x--;
                    tChild->p.g += valueTilt;
                    break;
                case p_ldown:
                    tChild->p.y++;
                    tChild->p.x--;
                    tChild->p.g += valueTilt;
                    break;
                case p_rup:
                    tChild->p.y--;
                    tChild->p.x++;
                    tChild->p.g += valueTilt;
                    break;
                case p_rdown:
                    tChild->p.y++;
                    tChild->p.x++;
                    tChild->p.g += valueTilt;
                    break;
                defult:
                    break;
            }

            //计算g、h、f值，并检查可行性
            tChild->p.h = getH(end,tChild->p);
            tChild->p.setF();
            if(needAdd(tChild->p,map,visited)){
                //将结点连入树
                tCurrent->childs.push_back(tChild);
                tChild->parent = tCurrent;
                //添加至待比较列表
                buff.push_back(tChild);
                //设为访问过
                visited[tChild->p.y][tChild->p.x] = true;
            }
            else{
                delete tChild;
            }
        }

        //找出所有可行点中f值最小的点
        itMin = buff.begin();
        for(it = buff.begin(); it != buff.end(); it++){
            itMin = (((*itMin)->p.f > (*it)->p.f) ? it : itMin);
        }

        //将该点设为当前点并从可行点列表中删除
        tCurrent = *itMin;
        buff.erase(itMin);

        //若到达终点，路径完成，退出
        if(tCurrent->p == end){
            findEnd = true;
            break;
        }
        //若待比较列表为空，直接退出
        if(buff.empty()){
            break;
        }
    }

    //若找到路径，打印
    if(findEnd){
        cout<<"Path Found."<<endl;
        while(tCurrent){
            cout<<"("<<tCurrent->p.y<<","<<tCurrent->p.x<<") ";
            tCurrent = tCurrent->parent;
        }
        cout<<endl;
    }
    else{
        cout<<"Path not found."<<endl;
    }
    system("pause");
    return 0;
}
