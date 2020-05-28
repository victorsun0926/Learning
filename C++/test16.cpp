/*
 * @Author: Victor Sun
 * @Github: https://github.com/victorsun0926/
 * @CreateTime: 2020-05-27 19:37:13
 * @LastEditTime: 2020-05-27 19:45:17
 */
#include <iostream>
#include <iomanip>

using namespace std;

struct POINT{
    float x;
    float y;
};
struct CIRCLE{
    float r;
    struct POINT center;
}Circle;

int main(){
    int HavingOrigin(CIRCLE);
    CIRCLE c1;
    cout<<"X=";
    cin>>c1.center.x;
    cout<<endl<<"Y=";
    cin>>c1.center.y;
    cout<<endl<<"R=";
    cin>>c1.r;
    HavingOrigin(c1);
    system("pause");
    return 0;
}

int HavingOrigin(CIRCLE c)
{
    if((c.center.x*c.center.x+c.center.y*c.center.y)<=c.r*c.r)
    cout<<"Having Origin"<<endl;
    else cout<<"Not Having Origin"<<endl;
}
