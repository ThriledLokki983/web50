package com.company;

public class Printer {
    private int tonerLevel = 100;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, int pagesPrinted, boolean duplex) {
        this.tonerLevel = (tonerLevel < 0 && tonerLevel > 100) ? tonerLevel : this.tonerLevel;
        this.pagesPrinted = pagesPrinted;
        this.duplex = duplex;
    }

    public void fillUpToner(int tonerNumber){
        this.tonerLevel += tonerNumber;
        if (this.tonerLevel < 0){
            System.out.println("Toner Level is empty!");
        }
    }

    public int tonerBalance(){
        return this.tonerLevel;
    }

    public void pagesPrinted(int pages){
        this.pagesPrinted += pages;
        if (duplex){
            System.out.println((this.pagesPrinted/2) + "-pages have been printed");
        }else {
            System.out.println(this.pagesPrinted + "-pages have been printed");
        }
    }

}
