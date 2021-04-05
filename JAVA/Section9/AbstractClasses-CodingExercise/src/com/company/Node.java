package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 8:57 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Node extends ListItem{

    private ListItem item;

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null){
            return ((String) super .getValue()).compareTo((String) item.getValue());
        }else{
            return -1;
        }
    }
}

