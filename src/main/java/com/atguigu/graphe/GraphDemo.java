package com.atguigu.graphe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphDemo {
    public static void main(String[] args) {
        String arr[] = {"A","B","C","D","E"};
        Graph graph = new Graph(arr.length);
        for(String str:arr){
            graph.addItem(str);
        }

        graph.addEdge(0,1,1);
        graph.addEdge(1,2,1);
        graph.addEdge(2,4,1);
        graph.addEdge(0,3,1);
        graph.addEdge(0,2,1);

        graph.showGraph();
        System.out.println("-------深度遍历--------");
        graph.dst();//深度遍历
        System.out.println("-------广度遍历-------");
        graph.bst();//广度遍历
    }
}

class Graph{
    public ArrayList<String> itemList;
    public int edges[][];
    public boolean isVisited[];

    public int edgeNums;

    public LinkedList linkedList;

    public Graph(int n) {
        this.itemList  = new ArrayList<String>(n);
        this.edges = new int[n][n];

        this.linkedList = new LinkedList();
    }

    /**
     * 添加节点
     * @param item
     */
    public void addItem(String item){
        this.itemList.add(item);
    }

    /**
     * 连接下标为a 和 b 的节点，边的权重为w
     * @param a
     * @param b
     * @param w
     */
    public void addEdge(int a,int b,int w){
        this.edges[a][b] = w;
        this.edges[b][a] = w;
        this.edgeNums++;
    }

    public String getItemByIndex(int i){
        return itemList.get(i);
    }

    /**
     * 返回当前节点（下标为index）的第一个相邻节点的下标
     * 未找到返回-1
     * @param index
     * @return
     */
    public int getFirstNeigh(int index){
        for(int i=0;i<itemList.size();i++){
            if(this.edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回从v出发的相邻节点x的下一个相邻节点
     * @param v
     * @param x
     * @return
     */
    public int getNextNeigh(int v,int x){
        for(int i=x+1;i<itemList.size();i++){
            if(edges[v][i]>0){
                return i;
            }
        }
        return -1;
    }

    public int getEdgeNums(){
        return edgeNums;
    }

    public int getWeight(int a,int b){
        return this.edges[a][b];
    }

    public void showGraph(){
        for(int[] item:edges){
            System.out.println(Arrays.toString(item));
        }
    }

    /**
     * 从节点n开始进行深度遍历  递归遍历
     * @param n
     */
    private void dst(boolean isVisited[],int n){
        System.out.print(this.getItemByIndex(n)+"->");
        isVisited[n]=true;

        int m = this.getFirstNeigh(n);
        while(m!=-1){
            if(!isVisited[m]){
//                System.out.print(this.getItemByIndex(m)+"->");
//                isVisited[m]=true;
                this.dst(isVisited,m);
            }
                m=this.getNextNeigh(n,m);

        }
    }

    public void dst(){
        this.isVisited = new boolean[itemList.size()];
        for(int i=0;i<itemList.size();i++){
            if(!isVisited[i]){
                dst(isVisited,i);
            }
        }
    }

    /**
     * 从节点n开始进行广度遍历
     */
    public void bst(boolean isVisited[],int n){
        int h;//存放首个邻接点
        int w;//存放邻接点
        System.out.println("==>"+this.getItemByIndex(n));
        isVisited[n] = true;
        this.linkedList.addLast(n);
        while(!linkedList.isEmpty()){
            h = (Integer) this.linkedList.removeFirst();
            w = this.getFirstNeigh(h);
            while(w!=-1){
                if(!isVisited[w]){
                    System.out.println("==>"+this.getItemByIndex(w));
                    isVisited[w]=true;
                    this.linkedList.addLast(w);
                }else{
                    w = this.getNextNeigh(h,w);
                }
            }
        }

    }

    public void bst(){
        this.isVisited = new boolean[itemList.size()];

        for(int i=0;i<itemList.size();i++){
            if(!isVisited[i]){
                this.bst(isVisited,i);

            }
        }

    }

}
