package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        /*
        String theData = "9 3 8 6 7 4 1 2 0 9 6 4 5 7";
        String myStringData = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.";
       */

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String[] data = stringData.split(" ");
        for (String s : data){
            tree.addItem(new Node(s));
        }
        //tree.traverse(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("Darwin"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("Adelaide"));
        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node("ipsum"));
//        tree.removeItem(new Node("used"));
//        tree.removeItem(new Node("placeholder"));
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
