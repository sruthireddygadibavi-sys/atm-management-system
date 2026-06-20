import java.util.Scanner;

public class atm {

    static Scanner sc = new Scanner(System.in);

    static int pin = 2007;
    static double balance = 7000;
    static int attempts = 5;
    static boolean isBlocked = false;

    public static void main(String[] args) {

        System.out.println("===== Welcome to ATM =====");

        if (!verifyPIN()) {
            System.out.println("Card blocked! Please contact bank.");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdrawMoney();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    changePIN();
                    break;
                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // PIN Verification
    static boolean verifyPIN() {
        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                System.out.println("PIN verified successfully!");
                return true;
            } else {
                attempts--;
                System.out.println("Wrong PIN! Attempts left: " + attempts);
            }
        }
        isBlocked = true;
        return false;
    }

    // Withdraw Money
    static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Please collect cash.");
            System.out.println("Remaining Balance: Rs. " + balance);
        }
    }

    // Deposit Money
    static void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance += amount;
            System.out.println("Amount deposited successfully.");
            System.out.println("Current Balance: Rs. " + balance);
        }
    }

    // Balance Inquiry
    static void checkBalance() {
        System.out.println("Available Balance: Rs. " + balance);
    }

    // Change PIN
    static void changePIN() {
        System.out.print("Enter old PIN: ");
        int oldPin = sc.nextInt();

        if (oldPin == pin) {
            System.out.print("Enter new PIN: ");
            pin = sc.nextInt();
            System.out.println("PIN changed successfully!");
        } else {
            System.out.println("Incorrect old PIN!");
        }
    }
}