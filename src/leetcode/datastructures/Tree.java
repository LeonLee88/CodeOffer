package leetcode.datastructures;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Tree {
	
	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    public static TreeNode buildTree(Deque<String> nodes){
        String valStr = nodes.remove();
        if(valStr.equals("#")){
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(valStr));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        
        return node;
    }
    
    public static void serializePreOrder(TreeNode root, StringBuilder res){
        if(root == null){
            if(res.length()==0) {
                res.append("#"); // root is the root of the tree
            } else {
                res.append(",#"); // root is an inner node
            }
            
            return;
        }
        
        //root is not null
        if(res.length()==0){
            res.append(root.val);
        } else {
            res.append(","+String.valueOf(root.val));
        }
        serializePreOrder(root.left,res);
        serializePreOrder(root.right,res);
    }
}
