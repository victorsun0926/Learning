import java.util.Vector;

class AStarPlus1 extends AStar {
    public AStarPlus1(int[][] m,int my,int mx){
        super(m, my, mx);
    }

    Vector<Point> dStart(dPoint begin, dPoint end) {
        begin.g = 5;
        boolean pathFound = false;
        visited = new boolean[mapY][mapX];
        visited[begin.x][begin.y] = true;
        dPointTree tRoot = new dPointTree();
        tRoot.p = begin;
        dPointTree tCurrent;
        tCurrent = tRoot;
        Vector<dPointTree> buffer = new Vector<>();
        while (true) {
            for (int i = 0; i < 8; i++) {
                dPointTree tChild = new dPointTree();
                tChild.p.setXY(tCurrent.p);
                switch (i) {
                    //up
                    case 0 -> {
                        tChild.p.y--;
                        tChild.p.dir = 0;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    //down
                    case 1 -> {
                        tChild.p.y++;
                        tChild.p.dir = 1;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    //left
                    case 2 -> {
                        tChild.p.x--;
                        tChild.p.g += valueXY;
                        tChild.p.dir = 2;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    //right
                    case 3 -> {
                        tChild.p.x++;
                        tChild.p.dir = 3;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    //up-left
                    case 4 -> {
                        tChild.p.y--;
                        tChild.p.x--;
                        tChild.p.dir = 4;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    //down-left
                    case 5 -> {
                        tChild.p.y++;
                        tChild.p.x--;
                        tChild.p.dir = 5;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    //up-right
                    case 6 -> {
                        tChild.p.y--;
                        tChild.p.x++;
                        tChild.p.dir = 6;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    //down-right
                    case 7 -> {
                        tChild.p.y++;
                        tChild.p.x++;
                        tChild.p.dir = 7;
                        tChild.p.setG(tCurrent.p.dir);
                    }
                    default -> {
                        break;
                    }
                }
                tChild.p.h = 0;
                tChild.p.setF();
                if (needAdd(tChild.p, map, visited)) {
                    tCurrent.childs.addElement(tChild);
                    tChild.parent = tCurrent;
                    buffer.addElement(tChild);
                    visited[tChild.p.y][tChild.p.x] = true;
                }
            }
            if(buffer.isEmpty()){
                break;
            }
            dPointTree itMinus = buffer.firstElement();
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

class dPoint extends Point{
    int dir;

    dPoint(int x, int y){
        super(x,y);
        dir = -1;
    }

    dPoint(){
        super();
        this.dir = -1;
        this.g = 10;
    }

    void setG(int parent_dir){
        if(dir != parent_dir){
            g += 5;
        }
    }
}

class dPointTree {
    dPoint p;
    Vector<dPointTree> childs;
    dPointTree parent;

    dPointTree(){
        p = new dPoint();
        childs = new Vector<>();
        parent = null;
    }
}