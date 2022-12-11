package com.example.projectdsa;
import java.nio.file.*;
import java.io.*;
import java.util.List;
public class AvlTree {
    static Node root;

    public static Node searchData(Node roott, String name) {
        if (roott == null || roott.product_name.equals(name))
            return roott;

        else if (roott.product_name.compareToIgnoreCase(name) >0)
            return searchData(roott.left, name);

        else
            return searchData(roott.right, name);
    }
    public Node insert(Node new_node) {
        if (root == null)
        {
            root = new_node;
        }
        else
        {
            Node temp = root;
            while (temp != null)
            {
                if (temp.product_name.equals(new_node.product_name))
                {
                    return temp;
                }
                else if (temp.product_name.compareToIgnoreCase(new_node.product_name) >0 && (temp.left == null))
                {
                    temp.left = new_node;
                    break;
                }
                else if (temp.product_name.compareToIgnoreCase(new_node.product_name)>0)
                {
                    temp = temp.left;
                }
                else if (temp.product_name.compareToIgnoreCase(new_node.product_name)<0 && (temp.right == null))
                {
                    temp.right = new_node;
                    break;
                }
                else
                {
                    temp = temp.right;
                }
            }
        }
        root=rebalance(root);
        return root;
    }
    Node rebalance(Node root) {
        updateHeight(root);
        int balance = getBalance(root);
        if (balance > 1) {
            Node temp = root.right;
            if (height( temp.right) > height(temp.left)) {
                root =  rotateLeft(root);
            } else {
                root.right = rotateRight( root.right);
                root =  rotateLeft(root);
            }
        } else if (balance < -1) {
            if (height(root.left.left) > height( root.left.right))
                root =  rotateRight(root);
            else {
                root.left =  rotateLeft(root.left);
                root =  rotateRight(root);
            }
        }
        return root;
    }
    Node rotateLeft(Node root) {
        Node rr = (Node) root.right;
        Node temp = rr.left;
        rr.left = root;
        root.right = temp;
        updateHeight(root);
        updateHeight(rr);
        return rr;
    }
    Node rotateRight(Node root) {
        Node rr = root.left;
        Node temp = rr.right;
        rr.right = root;
        root.left = temp;
        updateHeight(root);
        updateHeight(rr);
        return rr;
    }
    void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height((Node) n.right));
    }
    int height(Node n) {
        return n == null ? 0 : n.height;
    }
    int getBalance(Node n) {
        return (n == null) ? 0 : height((Node) n.right) - height(n.left);
    }

    static List<String> allLines = null;
    public static List<String> readFileInList(String fileName)
    {
        try {
            allLines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }
    public List ReadALLData(Node root,String pathname)
    {
        int price =30000;
        List<String> l = readFileInList(pathname);
        for (int i = 0; i < l.size(); i++) {

            Node n = new Node(l.get(i),price );
            price+=5000;
            root= insert( n);
        }
        return allLines ;
    }
}