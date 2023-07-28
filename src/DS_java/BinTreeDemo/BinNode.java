package DS_java.BinTreeDemo;

public class BinNode {
    int data;
    BinNode left;
    BinNode right;
    BinNode parent;
    int height;
    BinNode(){}
    BinNode(int data){
        this.data = data;
    }
    BinNode(int data,BinNode left, BinNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
