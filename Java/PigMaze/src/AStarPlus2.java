class AStarPlus2 extends AStar {
    AStarPlus2(int[][] m, int my, int mx) {
        super(m, my, mx);
    }

    @Override
    boolean needAdd(Point current, int[][] map, boolean[][] visited) {
        if(current.y >= mapY || current.y < 0) {
            return false;
        }
        if(current.x >= mapX || current.x < 0) {
            return false;
        }
        return !visited[current.y][current.x];
    }

}