package hingst.bank;

import hingst.bank.util.AppState;
import hingst.bank.BankofFred;
import java.util.Scanner;

public class BankofFredApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the number of accounts you want to inquire about: ");
        int number = scan.nextInt();

        BankofFred details[] = new BankofFred[number];

        for (int i = 0; i < details.length; i++){
            //show tie-in
            details[i] = new BankofFred();
            details[i].openNew();
        }
        int choice;

        do {
            System.out.println("\nWelcome to the Bank of Fred");
            System.out.println("Type in 1 to display the account details\n2 if you wish to search by account number\n3 if you desire to make a deposit\n4 to make a withdrawal\n5 to exit");
            System.out.println("Type choice now: ");
            choice = scan.nextInt();

            switch (choice) {

                case 1:
                    for (int i = 0; i < details.length; i++){
                        details[i].displayAccountDetails();
                    }
                    break;
                case 2:
                    System.out.println(" Enter the account number you are interested in: ");
                    long acct_Number = scan.nextLong();
                    boolean found = false;

                    for (int i = 0; i < details.length; i++){
                        found = details[i].find(acct_Number);
                        if(found){
                            break;
                        }

                    }
                    if(!found){
                        System.out.println("We are unable to locate this account")  ;
                    }
                    break;
                case 3:
                    System.out.println("Please enter the account number: ");
                    acct_Number = scan.nextLong();
                    found = false;

                    for (int i = 0; i < details.length; i++){
                        found = details[i].find(acct_Number);
                        if(found) {
                            details[i].makeDeposit();
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("We were unable to locate this account");
                    }
                    break;
                case 4:
                    System.out.println("Please enter the account number: ");
                    acct_Number = scan.nextLong();

                    found = false;

                    for(int i = 0; i < details.length; i++){
                        found = details[i].find(acct_Number);
                        if (found){
                            details[i].makeWithdrawal();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("We are sorry, but we could not locate this account");

                    }
                    break;
                case 5:
                    System.out.println("Thank you for your loyal patronage");
                    break;
            }
        }
        while (choice != 5);

        //commented out code ties in with persistence and authentication using DB1

        AppState app = new AppState();
        app.startup();
    }
            }
