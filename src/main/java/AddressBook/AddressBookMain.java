package AddressBook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program!");

        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while(true){
            System.out.println("Choose an option: ");
            System.out.println("1. Add Contact");
            System.out.println("2. Quit");
            String option = sc.nextLine();

            switch(option){
                case "1":
                    addressBook.addContact(sc);
                    break;
                case "2":
                    System.out.println("Exiting Address Book Program");
                    return;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 5.");
            }
        }
    }
}