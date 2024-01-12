package com.atguigu.algorithm.minpath;

import java.util.Arrays;

/**
 * 普里姆算法 求最短路径
 */
public class PrimDemo {
    public static void main(String[] args) {
        char[] vertex = new char[]{'A','B','C','D','E','F','G'};
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        Graph graph = new Graph(vertex.length);
        graph.createGraph(vertex,weight);
        graph.showGraph();
        graph.primSearch(0);

    }
}

class Graph{
    public int totalNum;
    char vertex[];
    int[][] weight;

    public Graph(int totalNum) {
        this.totalNum = totalNum;
        this.vertex = new char[this.totalNum];
        this.weight = new int[this.totalNum][this.totalNum];
    }

    public void createGraph(char vertex[],int[][] weight){
        for(int i=0;i<this.totalNum;i++){
            this.vertex[i] = vertex[i];
            for(int j=0;j<this.totalNum;j++){
                this.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(){
        for(int[] h:this.weight){
            System.out.println(Arrays.toString(h));
        }
    }

    public void primSearch(int ori){
        boolean isVisited[] = new boolean[this.totalNum];
        int[][] selectEdge = new int[totalNum][totalNum];
        int minEdge = 10000;
        int h1 = -1;
        int h2 = -1;

        isVisited[ori] = true;
        int i,j;
        for(int e=1;e<totalNum;e++){
            for(i=0;i<totalNum;i++){
                for(j=0;j<totalNum;j++){
                    if(isVisited[i] && !isVisited[j] && weight[i][j]<minEdge){
                        minEdge = weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }

            }
            System.out.println("边<"+vertex[h1]+"-"+vertex[h2]+"> 权重"+weight[h1][h2]);
            isVisited[h2]=true;
            minEdge=10000;
        }
    }
}