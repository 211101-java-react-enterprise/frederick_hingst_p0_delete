package hingst.bank;

import java.util.Scanner;
//Set up input methods and screen, connectivity, etc.
public class BankofFred {

    private String firstName;
    private String lastName;
    private Double acctBalance;
    private String acctType;
    private Long acctNumber;

//Put login/registration programming here for starters
    //allow creation of accounts and log in with credentials
   Scanner scan = new Scanner(System.in);
    public void displayAccountDetails() {

        System.out.println("Name on Account: " + firstName + " " + lastName);
        System.out.println("The account number given was: " + acctNumber);
        System.out.println("The account type registered is a: " + acctType);
        System.out.println(firstName + " " + lastName + "'s" + acctType + " account" + "has a balance of: $" + acctBalance);
    }

    public void makeDeposit() {

        double amt;
        System.out.println("Please enter the amount you wish to deposit ");
        amt = scan.nextDouble();
        acctBalance = acctBalance + amt;
        
    }
    }





