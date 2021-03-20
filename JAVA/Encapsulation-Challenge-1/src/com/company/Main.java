package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Printer printer = new Printer(150, 45, true);
        printer.pagesPrinted(23);
        //printer.fillUpToner(98);
        System.out.println("Remaining Toner = " + printer.tonerBalance());


        System.out.println("#############################");
        Printer printer1 = new Printer(23, 45, false);
        printer1.pagesPrinted(23);
        printer.fillUpToner(143);
        System.out.println("Remaining Toner = " + printer.tonerBalance());
    }
}
