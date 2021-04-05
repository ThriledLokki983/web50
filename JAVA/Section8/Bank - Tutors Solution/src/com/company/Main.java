package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Bank bank = new Bank("National Bank of Ghana");

        bank.addBranch("Accra");
        bank.addCustomer("Accra", "Gideon Nimoh",343.57);
        bank.addCustomer("Accra", "Kwame Agyin",75.07);
        bank.addCustomer("Accra", "Vincent Nsiah", 45.98);

        bank.addBranch("Kumasi");
        bank.addCustomer("Kumasi", "Nana Poku",54.37);
        bank.addCustomer("Kumasi", "Kwadwo Mensah",104.78);
        bank.addCustomer("Kumasi", "Ofosu Acheampong", 98.34);

        bank.addCustomerTransaction("Accra", "Gideon Nimoh", 45.32);
        bank.addCustomerTransaction("Accra", "Gideon Nimoh", 57.87);
        bank.addCustomerTransaction("Kumasi", "Ofosu Acheampong", 95.89);

        bank.listCustomers("Accra", true);
        bank.listCustomers("Kumasi", false);

    }

}
