package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/27/21
 * Time: 5:47 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
