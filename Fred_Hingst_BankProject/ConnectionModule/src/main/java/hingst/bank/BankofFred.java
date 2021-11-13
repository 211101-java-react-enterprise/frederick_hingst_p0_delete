package hingst.bank;

import java.util.Scanner;
//Set up input methods and screen, connectivity, etc.
public class BankofFred {

    private String firstName;
    private String lastName;
    private Double acctBalance;
    private String acctType;
    private Long acctNumber;

    //Put login/registration tie-in here for starters
    //allow creation of accounts and log in with credentials
    Scanner scan = new Scanner(System.in);

    public void openNew() {

        System.out.println("Please enter your first name ");
        firstName = scan.nextLine();
        System.out.println("Now enter last name ");
        lastName = scan.nextLine();
        System.out.println("Is this a checking or savings account? ");
        acctType = scan.nextLine();
        System.out.println("Please enter your account number ");
        acctNumber = scan.nextLong();
        System.out.println("What is your current balance? ? ");
        acctBalance = scan.nextDouble();
    }
    public void displayAccountDetails() {

        System.out.println("Name on Account: " + firstName + " " + lastName);
        System.out.println("The account number given was: " + acctNumber);
        System.out.println("The account type registered is a: " + acctType);
        System.out.println(firstName + " " + lastName + "'s " + acctType + " account" + " has a balance of: $" + acctBalance);
    }

    public void makeDeposit() {

        double amt;
        System.out.println("Please enter the amount you wish to deposit ");
        amt = scan.nextDouble();
        acctBalance = acctBalance + amt;

    }

    public void makeWithdrawal() {

        double amt;
        System.out.println("Please enter amount you wish to withdraw ");
        amt = scan.nextDouble();

        if (acctBalance >= amt) {
            acctBalance = acctBalance - amt;
            System.out.println("Your remaining balance after withdrawal is: " + acctBalance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tPerhaps you should contact one of our loan specialists.  We are unable to process this transaction");
        }

        }
        //method to check account
     public boolean find(long acct_Number) {

        if (acctNumber == acct_Number){
            displayAccountDetails();
            return (true);

        }
          return (false);
     }
    }

