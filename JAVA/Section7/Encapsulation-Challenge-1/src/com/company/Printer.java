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

    public int fillUpToner(int tonerNumber){
        if (tonerNumber > 0 && tonerNumber <= 100){
            if (this.tonerLevel + tonerNumber > 100){
                return -1;
            }
            this.tonerLevel += tonerNumber;
            return this.tonerLevel;
        }
        return -1;
    }

    public int tonerBalance(){
        return this.tonerLevel;
    }

    public int pagesPrinted(int pages){
        this.pagesPrinted += pages;
        if (this.duplex){
            System.out.println(((this.pagesPrinted/2) + (this.pagesPrinted % 2)) + "-pages have been printed in Duplex Mode");
        }else {
            System.out.println(this.pagesPrinted + "-pages have been printed");
        }
        return this.pagesPrinted;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
