package com.company;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in you grocery list");
        for (int i = 0; i < groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    private void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified");
    }

    private void removeGroceryItem(int position){
        //String theItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Grocery item " + (position + 1) + " has been deleted");
    }

//    public String findItem(String item){
//       // boolean exists = groceryList.contains(item);
//        int position = groceryList.indexOf(item);
//        if (position >= 0){
//            return groceryList.get(position);
//        }
//        return null;
//    }

    private int findItem(String item){
            return groceryList.indexOf(item);
    }

    public void modifyGroceryItem(String currentItem, String item){
        int position = findItem(currentItem);
        if (position >= 0){
            modifyGroceryItem(position, item);
        }
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        if (position >= 0){
            removeGroceryItem(position);
        }
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if (position >= 0){
            return true;
        }
        return false;
    }


}
