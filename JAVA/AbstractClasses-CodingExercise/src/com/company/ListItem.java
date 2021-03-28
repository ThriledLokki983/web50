package com.company;

import java.util.List;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 8:50 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public abstract class ListItem {
    protected ListItem leftLink;
    protected ListItem rightLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

     abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
