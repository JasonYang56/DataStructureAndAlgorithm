package com.atguigu.leetcode.broadpriority;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MaxIslandArea {

    @Test
    public  void testDemo(){
//        int[][] oriGrid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//        System.out.println("---->"+maxAreaOfIsland(oriGrid));
        char c ='1';
        System.out.println(c=='1');

    }

    private static final int[][] moveStep = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
//    private static final int[][] moveStep = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && !isVisited[i][j]){
                    res = Math.max(res,bfs(i,j,rows,cols,grid,isVisited));
                }
            }
        }
        return res;

    }

    public boolean isInArea(int x,int y,int rows,int cols){
        return x>=0 && x<rows && y>=0 && y< cols;
    }

    public int bfs(int i,int j,int rows,int cols,int[][]grid,boolean[][] isVisited){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i,j});
        isVisited[i][j] = true;
        int count = 0;

        while(!queue.isEmpty()){

            int[] temp = queue.poll();
            count++;
            for(int[] oneStep:moveStep){
                int newX = temp[0] + oneStep[0];
                int newY = temp[1] + oneStep[1];
                    if(isInArea(newX,newY,rows,cols) && grid[newX][newY]==1 && !isVisited[newX][newY]){
                        queue.offer(new int[]{newX,newY});
                        isVisited[newX][newY]=true;

                    }


            }
        }

        return count;

    }
}
