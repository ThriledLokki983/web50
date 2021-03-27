package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        MyLinkedList list = new MyLinkedList(null);
        //list.traverse(list.getRoot());

        String[] data = stringData.split(" ");
        for (String s : data){
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());
    }
}
