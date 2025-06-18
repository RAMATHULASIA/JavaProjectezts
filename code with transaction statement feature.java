import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Customer {
        String name;
        int cid;
        int accno;
        String branch;
        String bank;
        int inibal = 0;
        int mypin = 5566;
        List<String> transactions = new ArrayList<>();

        public Customer(String name, int cid, int accno, String branch, String bank) {
            this.name = name;
            this.cid = cid;
            this.accno = accno;
            this.branch = branch;
            this.bank = bank;
        }

        public void display() {
            System.out.println("\n--- Customer Details ---");
            System.out.println("Name: " + name);
            System.out.println("Customer ID: " + cid);
            System.out.println("Account Number: " + accno);
            System.out.println("Branch: " + branch);
            System.out.println("Bank: " + bank);
            System.out.println("-------------------------\n");
        }

        public void deposit(int amount) {
            if (amount > 0) {
                inibal += amount;
                transactions.add("Deposited: ₹" + amount);
                System.out.println("Deposit sucessful!");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(int pin, int amount) {
            if (pin == mypin && amount <= inibal) {
                inibal -= amount;
                transactions.add("Withdrawn: ₹" + amount);
                System.out.println("withdrawal successful!");
            } else {
                System.out.println("Insufficient Balance or Wrong PIN");
            }
        }

        public void checkBalance(int pin) {
            if (pin == mypin) {
                System.out.println(" Balance: ₹" + inibal);
            } else {
                System.out.println("Incorrect PIN");
            }
        }

        public void changePin(Scanner sc, int pin) {
            if (pin == mypin) {
                System.out.print("Enter your new PIN: ");
                int newpin = sc.nextInt();
                mypin = newpin;
                System.out.println("PIN changed successfully.");
            } else {
                System.out.println("Incorrect current PIN");
            }
        }

        public void getStatement(int pin) {
            if (pin == mypin) {
                System.out.println("\n----Transaction Statement ---");
                if (transactions.isEmpty()) {
                    System.out.println("No transactions yet.");
                } else {
                    for (String t : transactions) {
                        System.out.println(t);
                    }
                }
                System.out.println("--------------------------------\n");
            } else {
                System.out.println("Incorrect PIN");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input customer details
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();

        System.out.print("Enter Account Number: ");
        int accno = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Bank: ");
        String bank = sc.nextLine();

        // Create customer object
        Customer c1 = new Customer(name, cid, accno, branch, bank);

        // Display customer info
        c1.display();

        // Deposit money
        System.out.print("Enter amount to deposit: ");
        int depositAmount = sc.nextInt();
        c1.deposit(depositAmount);

        // Check balance
        System.out.print("Enter your PIN to check balance: ");
        int pinToCheck = sc.nextInt();
        c1.checkBalance(pinToCheck);

        // Withdraw money
        System.out.print("Enter your PIN to withdraw: ");
        int pinToWithdraw = sc.nextInt();
        System.out.print("Enter amount to withdraw: ");
        int withdrawAmount = sc.nextInt();
        c1.withdraw(pinToWithdraw, withdrawAmount);

        // Change PIN
        System.out.print("Enter your PIN to change PIN: ");
        int oldPin = sc.nextInt();
        c1.changePin(sc, oldPin);

        // Check final balance
        System.out.print("Enter PIN to check final balance: ");
        int finalPin = sc.nextInt();
        c1.checkBalance(finalPin);

        // Get transaction statement
        System.out.print("Enter PIN to view transaction statement: ");
        int pinForStatement = sc.nextInt();
        c1.getStatement(pinForStatement);

        sc.close();
    }
}
