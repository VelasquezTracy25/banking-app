import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        BankAccount obj1 = new BankAccount("Jason Derulo", "BA0001");
        obj1.showMenu();

        BankAccount obj2 = new BankAccount("Tamera Campbell", "BA0002");
        obj2.showMenu();

        BankAccount obj3 = new BankAccount("Lizzie McGuire", "BA0003");
        obj3.showMenu();


    }

}


class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String custName, String custId) {
        customerName = custName;
        customerId = custId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0)
            balance = balance - amount;
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    void showMenu() {

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("==================================");
            System.out.println("Enter an option");
            System.out.println("==================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("---------------------");
                    System.out.println("Balance : " + balance);
                    System.out.println("---------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("---------------------");
                    System.out.println("Enter a deposit amount:");
                    System.out.println("---------------------");
                    int depAmount = scanner.nextInt();
                    deposit(depAmount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("---------------------");
                    System.out.println("Enter a withdrawal amount:");
                    System.out.println("---------------------");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("---------------------");
                    getPreviousTransaction();
                    System.out.println("---------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("****************************");
                    break;

                default:
                    System.out.println("Invalid option. PLease try again.");
            }
            } while (option != 'E');
        System.out.println("Thanks for stopping by!");
    }
}