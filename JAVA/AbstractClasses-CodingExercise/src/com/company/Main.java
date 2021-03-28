package com.company;

public class Main {

    public static void main(String[] args) {
        //String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String theData = "9 3 8 6 7 4 1 2 0 9 6 4 5 7";
        //String myStringData = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.";


        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String[] data = theData.split(" ");
        for (String s : data){
            tree.addItem(new Node(s));
        }
        //tree.traverse(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("9"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("0"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("3"));
        tree.removeItem(new Node("6"));
        tree.removeItem(new Node("8"));
        tree.traverse(tree.getRoot());

//        tree.removeItem(new Node("is"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(new Node("a"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(new Node("a"));
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
    }
}
