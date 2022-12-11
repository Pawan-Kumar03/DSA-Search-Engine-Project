package com.example.projectdsa;

public class Node extends javafx.scene.Node {
//    public static Object root;
    //attributes\
    public int height;
    public  String product_name;
    //private String category;
    public int price;

    Node right;
    Node left;
    Node(String product_name, String s)
    {}
    //constructor for intializing
    Node(String product_name,int price) {
        right = null;
        left = null;
        this.product_name = product_name;
        this.price = price;
    }
}