package DS_java.BinTreeDemo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BinTreeDemo {
    public static void main(String[] args) {
       BinNode binNode =  new BinNode(3,
               new BinNode(4,new BinNode(1), new BinNode(3)),
               new BinNode(5,null,new BinNode(1)));
//        travelPre(binNode);
        travelLevel(binNode);
    }

    public static void travelLevel(BinNode binNode){
        Queue<BinNode> queue = new ArrayDeque<>();
        queue.add(binNode);
        while (!queue.isEmpty()){
            BinNode node = queue.remove();
            System.out.println(node.data);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
    }
    public static void travelPre(BinNode binNode){
        if (binNode == null){
            return;
        }
        System.out.print(binNode.data + " ");
        travelPre(binNode.left);
        travelPre(binNode.right);
    }
}
