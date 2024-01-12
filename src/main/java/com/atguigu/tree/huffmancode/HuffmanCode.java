package com.atguigu.tree.huffmancode;


import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
//        String contentStr = "Hello oooo World,I like oooo ooooooooooooooo learning the DataStructure";
        String contentStr = "i like like like java do you like a java";
        byte[] contenBytes = contentStr.getBytes();

        List<Node> nodeList = getNodeList(contenBytes);
//        System.out.println("-------->"+nodeList);
//
        Node rootNode = createHaffmanTree(nodeList);
        preOrder(rootNode);

        //haffmanCode------->{32=010, 97=1010, 99=111110, 68=00000, 100=111111, 101=011, 103=00001, 72=00010, 104=00011, 73=00100, 105=10111, 107=00101, 44=00110, 108=100, 110=11100, 111=11101, 114=1100, 83=00111, 116=1101, 117=11110, 87=10110}
        // 111haffmanCode--->{32=010, 97=1010, 99=111110, 68=00000, 100=111111, 101=011, 103=00001, 72=00010, 104=00011, 73=00100, 105=10111, 107=00101, 44=00110, 108=100, 110=11100, 111=11101, 114=1100, 83=00111, 116=1101, 117=11110, 87=10110}

//        getCodes(rootNode,"",stringBuilder);


        haffmanCodes = getCodes(rootNode);

//        System.out.println("111haffmanCode------->"+haffmanCodes);

        byte[] haffmanCodeBytes = zipCode(contenBytes,haffmanCodes);
        System.out.println("ori len--->"+contenBytes.length);
        System.out.println("zip len--->"+haffmanCodeBytes.length);
        System.out.println("zip percentage--->"+((float)contenBytes.length-haffmanCodeBytes.length)/contenBytes.length);

        System.out.println("zipcode-------->"+Arrays.toString(haffmanCodeBytes));

        System.out.println(Integer.toBinaryString((byte)32));

    }

    private static StringBuilder stringBuilder = new StringBuilder();

    private static HashMap<Byte,String> haffmanCodes = new HashMap<>();

    private static HashMap<Byte,String> getCodes(Node rootNode){
        if(rootNode!=null){
            getCodes(rootNode.leftNode,"0",stringBuilder);
            getCodes(rootNode.rightNode,"1",stringBuilder);
            return haffmanCodes;
        }else{
            return null;
        }
    }

    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.leftNode,"0",stringBuilder2);
                getCodes(node.rightNode,"1",stringBuilder2);
            }else{
                haffmanCodes.put(node.data,stringBuilder2.toString());
            }

        }
    }

    private static byte[] zipCode(byte[] bytes,Map<Byte,String> haffmanCode){
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b:bytes){
            stringBuilder.append(haffmanCode.get(b));
        }
        int len = (stringBuilder.length()+7)/8;
        byte[] haffmanCodeBytes = new byte[len];
        int index=0;
        for(int i=0;i<stringBuilder.length();i=i+8){
            if(i+8>stringBuilder.length()){
                haffmanCodeBytes[index] = (byte)Integer.parseInt(stringBuilder.substring(i));
            }else{
                haffmanCodeBytes[index] = (byte)Integer.parseInt(stringBuilder.substring(i,i+8));
            }
            index++;
        }

        return haffmanCodeBytes;
    }


    private static Node createHaffmanTree(List<Node> nodeList){
        Collections.sort(nodeList);
        while(nodeList.size()>1){
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);
            Node parentNode = new Node(null, leftNode.vaule+ rightNode.vaule);
            parentNode.leftNode = leftNode;
            parentNode.rightNode = rightNode;
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(parentNode);
            Collections.sort(nodeList);
        }
        return nodeList.get(0);
    }

    private static void preOrder(Node root){
        if(root == null){
            System.out.println("此树为空");
        }else{
            root.preOrder();
        }
    }

    private static List<Node> getNodeList(byte bytes[]){
        List<Node> nodeList = new ArrayList<Node>();

        Map<Byte,Integer> tempMap = new HashMap<Byte,Integer>();
        for(byte item:bytes){
            Integer count = tempMap.get(item);
            if(count==null){
                tempMap.put(item,1);
            }else{
                tempMap.put(item,count+1);
            }
        }

        for(Map.Entry<Byte,Integer> entry:tempMap.entrySet() ){
            Node node = new Node(entry.getKey(), entry.getValue());
            nodeList.add(node);
        }

        return nodeList;
    }
}

class Node implements Comparable<Node>{
    public Byte data;
    public Integer vaule;
    public Node leftNode;
    public Node rightNode;

    public Node(Byte data, Integer vaule) {
        this.data = data;
        this.vaule = vaule;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", vaule=" + vaule +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.vaule-o.vaule;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.leftNode != null){
            this.leftNode.preOrder();
        }
        if(this.rightNode != null){
            this.rightNode.preOrder();
        }
    }
}
