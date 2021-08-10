import java.util.Vector;

class AStar {
    int valueXY,valueTilt,mapY,mapX;
    int[][] map;
    boolean[][] visited;

    AStar(int[][] m,int my,int mx){
        valueXY = 10;
        valueTilt = 15;
        mapY = my;
        mapX = mx;
        map = m;
    }

    int getH(Point end, Point current){
        int x = ((current.x > end.x) ? (current.x-end.x) : (end.x-current.x));
        int y = ((current.y > end.y) ? (current.y-end.y) : (end.y-current.y));
        return (x + y)*valueXY;
    }

    boolean needAdd(Point current, int[][] map, boolean[][] visited) {
        if(current.y >= mapY || current.y < 0) {
            return false;
        }
        if(current.x >= mapX || current.x < 0) {
            return false;
        }
        if(map[current.y][current.x] == 1) {
            return false;
        }
        return !visited[current.y][current.x];
    }

    Vector<Point> start(Point begin, Point end) {
        boolean pathFound = false;
        visited = new boolean[mapY][mapX];
        visited[begin.x][begin.y] = true;
        pointTree tRoot = new pointTree();
        tRoot.p = begin;
        pointTree tCurrent;
        tCurrent = tRoot;
        Vector<pointTree> buffer = new Vector<>();
        while (true) {
            for (int i = 0; i < 8; i++) {
                pointTree tChild = new pointTree();
                tChild.p.setXY(tCurrent.p);
                switch (i) {
                    //up
                    case 0 -> {
                        tChild.p.y--;
                        tChild.p.g += valueXY;
                    }
                    //down
                    case 1 -> {
                        tChild.p.y++;
                        tChild.p.g += valueXY;
                    }
                    //left
                    case 2 -> {
                        tChild.p.x--;
                        tChild.p.g += valueXY;
                    }
                    //right
                    case 3 -> {
                        tChild.p.x++;
                        tChild.p.g += valueXY;
                    }
                    //up-left
                    case 4 -> {
                        tChild.p.y--;
                        tChild.p.x--;
                        tChild.p.g += valueTilt;
                    }
                    //down-left
                    case 5 -> {
                        tChild.p.y++;
                        tChild.p.x--;
                        tChild.p.g += valueTilt;
                    }
                    //up-right
                    case 6 -> {
                        tChild.p.y--;
                        tChild.p.x++;
                        tChild.p.g += valueTilt;
                    }
                    //down-right
                    case 7 -> {
                        tChild.p.y++;
                        tChild.p.x++;
                        tChild.p.g += valueTilt;
                    }
                    default -> {
                        break;
                    }
                }
                tChild.p.h = getH(end, tChild.p);
                tChild.p.setF();
                if (this.needAdd(tChild.p, map, visited)) {
                    tCurrent.childs.addElement(tChild);
                    tChild.parent = tCurrent;
                    buffer.addElement(tChild);
                    visited[tChild.p.y][tChild.p.x] = true;
                }
            }
            if(buffer.isEmpty()){
                break;
            }
            pointTree itMinus = buffer.firstElement();
            int size = buffer.size();
            for(int i = 0; i < size; i++) {
                itMinus = ((itMinus.p.f > buffer.elementAt(i).p.f) ? buffer.elementAt(i) : itMinus);
            }
            tCurrent = itMinus;
            buffer.remove(itMinus);
            if(tCurrent.p.equals(end)){
                pathFound = true;
                break;
            }
        }
        Vector<Point> result = new Vector<>();
        if(pathFound){
            while(tCurrent.parent != null){
                result.addElement(tCurrent.p);
                tCurrent = tCurrent.parent;
            }
        }
        return result;
    }
}

class Point {
    int x, y;
    int f, g, h;

    Point(){
        x = 0;
        y = 0;
        f = 0;
        g = 0;
        h = 0;
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
        f = 0;
        g = 0;
        h = 0;
    }

    void setF(){
        f = g + h;
    }

    void setXY(Point p){
     x = p.x;
     y = p.y;
    }

    boolean equals(Point p){
        return p.x == x && p.y == y;
    }
}

class pointTree {
    Point p;
    Vector<pointTree> childs;
    pointTree parent;

    pointTree(){
        p = new Point();
        childs = new Vector<>();
        parent = null;
    }
}