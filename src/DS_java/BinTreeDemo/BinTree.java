package DS_java.BinTreeDemo;

import com.alibaba.druid.sql.visitor.functions.Bin;

public class BinTree {
    BinNode root ;
    int size ;
    public BinTree(){

    }
    public BinTree(BinNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }
}
