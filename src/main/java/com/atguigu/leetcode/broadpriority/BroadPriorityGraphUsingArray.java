package com.atguigu.leetcode.broadpriority;

import java.util.*;

public class BroadPriorityGraphUsingArray {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{3,4}};
        int res = countComponents(5,edges);
        System.out.println("--------->"+res);
    }

    public static int countComponents(int n, int[][] edges) {
        // List<Integer>[] graph =  new ArrayList[n];
        int[][] graph = new int[n][n];

        // for(int i=0;i<n;i++){
        //     graph[i] = new ArrayList();
        // }

        for(int[] edge:edges ){
            graph[edge[0]][edge[1]]=1;
            graph[edge[1]][edge[0]]=1;
        }

        for(int[] arr:graph){
            System.out.println("====>"+ Arrays.toString(arr));
        }


        int res=0;
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                bfs(graph,i,isVisited);
                res++;
            }

        }

        return res;

    }

    public static void bfs(int[][] graph,int i,boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i);
        isVisited[i]=true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            int[] tempArr = graph[temp];
            for(int n=0;n<tempArr.length;n++){
                if(!isVisited[n] && tempArr[n]==1){
                    queue.offer(n);
                    isVisited[n]=true;
                }
            }
        }
        /**
         * ====>[0, 1, 0, 0, 0]
         * ====>[1, 0, 1, 0, 0]
         * ====>[0, 1, 0, 0, 0]
         * ====>[0, 0, 0, 0, 1]
         * ====>[0, 0, 0, 1, 0]
         */


    }

}
