package com.atguigu.leetcode.broadpriority;

import java.util.LinkedList;
import java.util.Queue;

import static com.atguigu.leetcode.broadpriority.FlyLandCount.inArea;

public class FlyLandCount {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        int res = numEnclaves(grid);
        System.out.println("res ======>"+res);
    }
    public static  final int[][] ONE_STEP = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static int numEnclaves(int[][] grid) {
        int res=0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    res = res + bfs(i,j,rows,cols,grid,isVisited);
                }
            }
        }
        return res;
    }

    public static int bfs(int i,int j,int rows,int cols,int[][] grid,boolean[][] isVisited){
        int count=0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        isVisited[i][j]=true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            count ++;
            int x=temp[0],y=temp[1];
            for(int[] oneStep:ONE_STEP){
                int newR = x + oneStep[0];
                int newC = y + oneStep[1];
                if(inArea(newR,newC,rows,cols) && grid[newR][newC]==1){
                    queue.offer(new int[]{newR,newC} );
                    isVisited[newR][newC]=true;
                }
                if(!inArea(newR,newC,rows,cols)){
                    grid[x][y]=2;
                    return 0;
                }
                if(grid[newR][newC]==2){
                    return 0;
                }

            }
        }
        return count;
    }

    public static boolean  inArea(int r,int c,int rows,int cols){
        return r>=0&&r<rows&&c>=0&&c<cols;
    }
}
