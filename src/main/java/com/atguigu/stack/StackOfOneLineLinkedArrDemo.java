package com.atguigu.stack;

public class StackOfOneLineLinkedArrDemo {
    public static void main(String[] args) {
        StackOfOneLineLinkedArr stackOfOneLineLinkedArr = new StackOfOneLineLinkedArr(5);
        for(int i=0;i<5;i++){
            LinkedNode linkedNode = new LinkedNode(i+1,null);
            stackOfOneLineLinkedArr.push(linkedNode);
        }

        stackOfOneLineLinkedArr.showStack();

        LinkedNode popNode = stackOfOneLineLinkedArr.pop();
        System.out.println("pop node is:"+popNode.getNo());

        LinkedNode popNode2 = stackOfOneLineLinkedArr.pop();
        System.out.println("pop node is:"+popNode2.getNo());

        stackOfOneLineLinkedArr.showStack();

        stackOfOneLineLinkedArr.push(new LinkedNode(6,null));
        stackOfOneLineLinkedArr.push(new LinkedNode(7,null));
        stackOfOneLineLinkedArr.showStack();

        LinkedNode popNode3 = stackOfOneLineLinkedArr.pop();
        System.out.println("pop node is:"+popNode3.getNo());

        LinkedNode popNode4 = stackOfOneLineLinkedArr.pop();
        System.out.println("pop node is:"+popNode4.getNo());

        stackOfOneLineLinkedArr.showStack();

        LinkedNode popNode5 = stackOfOneLineLinkedArr.pop();
        stackOfOneLineLinkedArr.showStack();

        LinkedNode popNode6 = stackOfOneLineLinkedArr.pop();
        stackOfOneLineLinkedArr.showStack();

        LinkedNode popNode7 = stackOfOneLineLinkedArr.pop();
        stackOfOneLineLinkedArr.showStack();

        LinkedNode popNode8 = stackOfOneLineLinkedArr.pop();
        stackOfOneLineLinkedArr.showStack();





    }
}


class StackOfOneLineLinkedArr{
    LinkedNode firseNode = new LinkedNode(-1,null);
    private int maxSize ;

    private int currentNum = 0;

    public StackOfOneLineLinkedArr(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isEmpty(){
        return firseNode.getNextNode()==null?true:false;
    }

    public boolean isFull(){
        return currentNum==maxSize?true:false;
    }

    public void push(LinkedNode linkedNode){
        if(!isFull()){
            LinkedNode lastNode = this.findLaseNode();
            if(lastNode==null){
                firseNode.setNextNode(linkedNode);
            }else{
                lastNode.setNextNode(linkedNode);
            }
            currentNum++;
        }else{
            System.out.println("链表已满");
        }
    }

    public LinkedNode pop(){
        if(!isEmpty()){
            LinkedNode tempNode = firseNode;
            LinkedNode helpNode = firseNode;

            while (true){
                if(tempNode.getNextNode().getNextNode()==null){
                    helpNode = tempNode.getNextNode();
                    tempNode.setNextNode(null);
                    this.currentNum--;
                    return helpNode;
                }else{
                    tempNode = tempNode.getNextNode();
                }
            }
        }else{
            System.out.println("链表为空");
            return null;
        }
    }

    public void showStack(){
        if(!isEmpty()){
            LinkedNode tempNode = firseNode;
            LinkedNode[] linkedNodeArrs = new LinkedNode[currentNum];
            int tempCurrentNum = currentNum;
            while (true){
                if(tempNode.getNextNode()==null){
                    linkedNodeArrs[0]=tempNode;
                    break;
                }else{
                    linkedNodeArrs[tempCurrentNum-1]=tempNode.getNextNode();
                    tempNode = tempNode.getNextNode();
                    tempCurrentNum--;
                }
            }
            for(int i=0;i<currentNum;i++){
                System.out.println("--"+linkedNodeArrs[i].getNo()+"--");
            }
        }else{
            System.out.println("链表为空");
        }
    }

    public LinkedNode findLaseNode(){
        if(!isEmpty()){
            LinkedNode tempNode = firseNode;
            while (true){
                if(tempNode.getNextNode()==null){
                    return tempNode;
                }else{
                    tempNode = tempNode.getNextNode();
                }
            }
        }else{
            System.out.println("链表为空");
            return null;
        }
    }

}

class  LinkedNode{
    private int no;
    private LinkedNode nextNode;

    public LinkedNode(int no, LinkedNode nextNode) {
        this.no = no;
        this.nextNode = nextNode;
    }

    public int getNo() {
        return no;
    }

    public LinkedNode getNextNode() {
        return nextNode;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNextNode(LinkedNode nextNode) {
        this.nextNode = nextNode;
    }
}
