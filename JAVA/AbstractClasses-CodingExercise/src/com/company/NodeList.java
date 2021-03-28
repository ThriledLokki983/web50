package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 9:09 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem newItem);
    boolean removeItem(ListItem theItem);
    void traverse(ListItem root);

}
