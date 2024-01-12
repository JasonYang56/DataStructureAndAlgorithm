package com.atguigu.leetcode.broadpriority;


import java.util.*;

public class ShortBridge {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] grid = new int[][]{{1,1,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};

        int result = shortestBridge(grid);
        System.out.println("res====>"+result);

    }

    public static final int[][] ONE_STEP = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int shortestBridge(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        int res = Integer.MAX_VALUE;
        List<int[]> firstList = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!isVisited[i][j] && grid[i][j] == 1) {
                    bfs(i, j, rows, cols, isVisited, grid, firstList);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }




        for (int[] a : grid) {
            System.out.println(Arrays.toString(a));
        }

//        for (int[] arr : firstList) {
//            System.out.println(Arrays.toString(arr));
//        }

        // for(int[] arr:firstList){
        //     // System.out.println(""Arrays.toString(arr));
        //     for(int[] oneStep:ONE_STEP){
        //         int newC = arr[0] + oneStep[0];
        //         int newR = arr[1] + oneStep[1];
        //         if(inArea(newR,newC,rows,cols) && grid[newC][newR]==0){
        //             System.out.println("newC" + newC);
        //             System.out.println("newR" + newR);
        //             res = Math.min(res,bfs2(newC,newR,rows,cols,isVisited,grid));
        //         }
        //     }
        // }
        Queue<int[]> tempQueue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == -1) {
                    for(int[] oneStep:ONE_STEP){
                        int newR = i + oneStep[0];
                        int newC = j + oneStep[1];
                        if(inArea(newR,newC,rows,cols) && grid[newR][newC]==0 && !isVisited[newR][newC]){
//                            res = Math.min(res, bfs2(newR, newC, rows, cols, isVisited, grid));
                            tempQueue.offer(new int[]{newR,newC});
                            isVisited[newR][newC]=true;
                            grid[newR][newC]=2;
                        }
                    }


                }
            }
        }

        return bfs3(tempQueue,isVisited,rows,cols,grid);
//
//        for (boolean[] arr : isVisited) {
//            System.out.println(Arrays.toString(arr));
//        }

        // for(int[] arr:firstList){
        //     res = Math.min(res,bfs2(arr[0],arr[1],rows,cols,isVisited,grid));
        // }

//        return res;
    }

    public static void bfs(int i, int j, int rows, int cols, boolean[][] isVisited, int[][] grid, List<int[]> firstList) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;
        grid[i][j] = -1;


        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            firstList.add(temp);
            for (int[] oneStep : ONE_STEP) {
                int newR = temp[0] + oneStep[0];
                int newC = temp[1] + oneStep[1];
                if (inArea(newR, newC, rows, cols) && grid[newR][newC] == 1 && !isVisited[newR][newC]) {
                    queue.offer(new int[]{newR, newC});
                    isVisited[newR][newC] = true;
                    grid[newR][newC] = -1;
                }

            }
        }

    }

    public static int bfs2(int i, int j, int rows, int cols, boolean[][] isVisited, int[][] grid) {
        System.out.println("i j" + i + " " + j);
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        queue.offer(new int[]{i, j});
//         isVisited[i][j] = true;
        //System.out.println("isVisited" + isVisited[i][j]);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int n = 0; n < size; n++) {
                int[] temp = queue.poll();
                // int num = 0;
                for (int[] oneStep : ONE_STEP) {

                    int newR = temp[0] + oneStep[0];
                    int newC = temp[1] + oneStep[1];
                    if (inArea(newR, newC, rows, cols)) {
                        if (grid[newR][newC] == 0) {
                             System.out.println("1111111"+grid[newR][newC]);

                            queue.offer(new int[]{newR, newC});
//                             isVisited[newR][newC] = true;
                        } else if (grid[newR][newC] == 1) {
                             System.out.println("2222222"+grid[newR][newC]);
                            System.out.println("count" + " " + count);
                            return count;
                        }
                    }

                }
            }

            count++;
        }
        System.out.println("count" + " " + count);
        return count;
    }

    public static int bfs3(Queue<int[]> queue,boolean[][] isVisited,int rows, int cols, int[][] grid){
        int count=0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] temp = queue.poll();
//                grid[temp[0]][temp[1]]=2;
//                isVisited[temp[0]][temp[1]]=true;
                for(int[] oneStep:ONE_STEP){
                    int newR = temp[0]+oneStep[0];
                    int newC = temp[1]+ oneStep[1];
                    if(inArea(newR,newC,rows,cols)){
                        if(grid[newR][newC]==0){
                            queue.offer(new int[]{newR,newR});
//                            isVisited[newR][newC]=true;
                            grid[newR][newC]=2;
                        }else if(grid[newR][newC]==1){
                            return count;
                        }
                    }
                }

            }
        }
        return count;
    }

    public static boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}

