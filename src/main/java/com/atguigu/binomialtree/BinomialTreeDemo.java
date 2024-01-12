package com.atguigu.binomialtree;

public class BinomialTreeDemo {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1,"Tom");
        TreeNode treeNode2 = new TreeNode(2,"Jerry");
        TreeNode treeNode3 = new TreeNode(3,"Peter");
        TreeNode treeNode4 = new TreeNode(4,"Jasper");
        TreeNode treeNode5 = new TreeNode(5,"Tracy");

        treeNode1.setLeftNode(treeNode2);
        treeNode1.setRightNode(treeNode3);
        treeNode3.setLeftNode(treeNode5);
        treeNode3.setRightNode(treeNode4);

        BinomialTree binomialTree = new BinomialTree(treeNode1);

        binomialTree.preVisit(binomialTree.getRoot());
        binomialTree.delNode(treeNode1,1);
        System.out.println("----------------------");
        binomialTree.preVisit(binomialTree.getRoot());

//        binomialTree.midVisit(binomialTree.getRoot());
//        binomialTree.afterVisit(binomialTree.getRoot());

//        System.out.println("前序查找："+binomialTree.preSearch(treeNode1,5));
//        System.out.println("中序查找："+binomialTree.midSearch(treeNode1,5));
//        System.out.println("后序查找："+binomialTree.afterSearch(treeNode1,5));
//
    }
}

class BinomialTree{
    public TreeNode getRoot() {
        return root;
    }

    private TreeNode root;

    public BinomialTree(TreeNode root) {
        this.root = root;
    }

    //删除指定编号的节点
    public void delNode(TreeNode root,int id){
        if(root != null){
            if(root.getId()==id){
                this.root = null;
                return;
            }else{
                TreeNode tempNode = null;
                if(root.hasLeftNode()){
                    if(root.getLeftNode().getId() == id){
                        root.setLeftNode(null);
                        return;
                    }else{
                        delNode(root.getLeftNode(),id);
                    }
                    if(root.getRightNode().getId() == id){
                        root.setRightNode(null);
                        return;
                    }else{
                        delNode(root.getRightNode(),id);
                    }
                }
            }
        }else{
            System.out.println("该二叉树为空树");
        }
    }

    //前序遍历
    public void preVisit(TreeNode root){
        if(root == null){
            System.out.println("该二叉树为空");
        }else{
            System.out.println("前序遍历--->"+root.toString());
            if(root.hasLeftNode()){
                preVisit(root.getLeftNode());
            }
            if(root.hasRightNode()){
                preVisit(root.getRightNode());
            }
        }
    }

    //中序遍历
    public void midVisit(TreeNode root){
        if(root == null){
            System.out.println("该二叉树为空");
        }else{
            if(root.hasLeftNode()){
                midVisit(root.getLeftNode());
            }
            System.out.println("中序遍历--->"+root.toString());
            if(root.hasRightNode()){
                midVisit(root.getRightNode());
            }
        }
    }

    //后序遍历
    public void afterVisit(TreeNode root){
        if(root == null){
            System.out.println("该二叉树为空");
        }else{
            if(root.hasLeftNode()){
                afterVisit(root.getLeftNode());
            }

            if(root.hasRightNode()){
                afterVisit(root.getRightNode());
            }

            System.out.println("后序遍历--->"+root.toString());
        }
    }

    //前序查找
    public TreeNode preSearch(TreeNode root,int id){
        System.out.println("前序查找"+root.getId());

        if(root != null){
            if(root.getId()==id){
                return root;
            }
            TreeNode tempNode = null;
            if (root.hasLeftNode()) {
                tempNode = preSearch(root.getLeftNode(), id);
                if(tempNode != null){
                    return tempNode;
                }else{
                    if (root.hasRightNode()) {
                        tempNode = preSearch(root.getRightNode(), id);
                        if(tempNode != null) {
                            return tempNode;
                        }
                    }
                }
            }
        }

        return null;
    }

    //中序查找
    public TreeNode midSearch(TreeNode root,int id){

        if (root != null) {
            TreeNode tempNode = null;
            if (root.hasLeftNode()) {

                if (root.getLeftNode().getId() == id) {
                    System.out.println("中序查找");

                    return root.getLeftNode();
                }else{
                    tempNode = midSearch(root.getLeftNode(),id);
                    if(tempNode != null){
                        return tempNode;
                    }else{
                        if(root.getId()==id){
                            return  root;
                        }else{
                            tempNode = midSearch(root.getRightNode(),id);
                            if(tempNode != null){
                                return tempNode;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    //后序查找
    public TreeNode afterSearch(TreeNode root,int id){

        if(root !=null){
            TreeNode tempNode = null;
            if(root.hasLeftNode()){
                System.out.println("后序查找");

                if(root.getLeftNode().getId()==id){
                    return root.getLeftNode();
                }else{
                    tempNode = afterSearch(root.getLeftNode(),id);
                    if(tempNode!=null){
                        return tempNode;
                    }else{
                        tempNode = afterSearch(root.getRightNode(),id);
                        if(tempNode!=null){
                            return tempNode;
                        }else{

                            if(root.getId()==id){
                                return root;
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
}

class TreeNode{
    private int id;
    private String name;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //添加左节点  默认添加新节点后，摘下的节点放到新节的左节点上
    public void addLeftNode(TreeNode treeNode){
        if(hasLeftNode()){
            TreeNode tempNode = this.leftNode;
            this.leftNode = treeNode;
            treeNode.leftNode = tempNode;
        }else{
            this.leftNode = treeNode;
        }
    }

    //添加右节点  默认添加新节点后，摘下的节点放到新节的左节点上
    public void addRightNode(TreeNode treeNode){
        if(hasRightNode()){
            TreeNode tempNode = this.rightNode;
            this.rightNode = treeNode;
            treeNode.leftNode = tempNode;
        }else{
            this.rightNode = treeNode;
        }
    }

    public boolean hasLeftNode(){
        if(this.leftNode != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean hasRightNode(){
        if(this.rightNode != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
