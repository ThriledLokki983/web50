package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Printer printer = new Printer(50, 45, true);
        printer.pagesPrinted(23);
        //printer.fillUpToner(98);
        System.out.println("Remaining Toner = " + printer.tonerBalance());
        System.out.println("Remaining Toner = " + printer.pagesPrinted(4) + " New total of pages printed = " + printer.getPagesPrinted());



        System.out.println("#############################");
        Printer printer1 = new Printer(23, 45, false);
        printer1.pagesPrinted(23);
        printer.fillUpToner(3);
        //System.out.println("Remaining Toner = " + printer.tonerBalance());
        System.out.println("Remaining Toner = " + printer.pagesPrinted(4) + " New total of pages printed = " + printer.getPagesPrinted());
    }
}
