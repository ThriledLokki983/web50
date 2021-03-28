package com.company;

/**
 * Name: Gideon Nimoh
 * Date: 3/28/21
 * Time: 9:38 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class SearchTree implements NodeList{
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null){
            int compare = currentItem.compareTo(newItem);
            if (compare < 0 ){
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                }else {
                    currentItem.setNext(newItem);
                    return true;
                }
            }else if (compare > 0){
                if (currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }else {
                System.out.println(newItem.getValue() + " already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem theItem) {
       if (theItem != null){
           System.out.println("Deleting: " + theItem.getValue());
       }
       ListItem currentItem = this.root;
       ListItem parentItem = currentItem;
       while (currentItem != null){
           int compare = currentItem.compareTo(theItem);
           if (compare < 0){
               parentItem = currentItem;
               currentItem = currentItem.next();
           }else if (compare > 0){
               parentItem = currentItem;
               currentItem = currentItem.previous();
           }else{
               performRemoval(parentItem, currentItem);
               return true;
           }
       }
       return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else {
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                this.root = item.next();
            }
        } else {
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            item.setValue(current.getValue());
            if (leftmostParent == item) {
                item.setNext(current.next());
            } else {
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
