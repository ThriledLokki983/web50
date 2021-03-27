package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String theData = "9 3 8 6 7 4 1 2 0 9 6 4 5 7";
        String myStringData = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.";

        MyLinkedList list = new MyLinkedList(null);
        //list.traverse(list.getRoot());

        String[] data = theData.split(" ");
        for (String s : data){
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());
    }
}
