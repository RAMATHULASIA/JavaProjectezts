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

        public Customer(String name, int cid, int accno, String branch, String bank) {
            this.name = name;
            this.cid = cid;
            this.accno = accno;
            this.branch = branch;
            this.bank = bank;
        }

        public void display() {
            System.out.println("Name is: " + name);
            System.out.println("Customer ID is: " + cid);
            System.out.println("Account Number is: " + accno);
            System.out.println("Branch is: " + branch);
            System.out.println("Bank is: " + bank);
        }

        public void deposit(int amount) {
            if (amount > 0) {
                inibal += amount;
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Invalid amount.");
            }
        }

        public void withdraw(int pin, int amount) {
            if (pin == mypin && amount <= inibal) {
                inibal -= amount;
                System.out.println("Withdrawal successful!");
            } else {
                System.out.println("Insufficient Balance or Wrong PIN");
            }
        }

        public void checkBalance(int pin) {
            if (pin == mypin) {
                System.out.println("Balance is: " + inibal);
            } else {
                System.out.println("Incorrect PIN");
            }
        }

        public void changePin(Scanner sc, int pin) {
            if (pin == mypin) {
                System.out.print("Enter your new PIN: ");
                int newpin = sc.nextInt();
                mypin = newpin;
                System.out.println("PIN changed successfully to " + mypin);
            } else {
                System.out.println("Incorrect current PIN");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept user input for customer details
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

        // Create Customer object
        Customer c1 = new Customer(name, cid, accno, branch, bank);

        // Display details
        c1.display();

        // Interact with user: deposit, withdraw, check balance, etc.
        System.out.print("Enter amount to deposit: ");
        int depositAmount = sc.nextInt();
        c1.deposit(depositAmount);

        System.out.print("Enter your PIN to check balance: ");
        int pinToCheck = sc.nextInt();
        c1.checkBalance(pinToCheck);

        System.out.print("Enter your PIN to withdraw: ");
        int pinToWithdraw = sc.nextInt();
        System.out.print("Enter amount to withdraw: ");
        int withdrawAmount = sc.nextInt();
        c1.withdraw(pinToWithdraw, withdrawAmount);

        System.out.print("Enter your PIN to change PIN: ");
        int oldPin = sc.nextInt();
        c1.changePin(sc, oldPin);

        System.out.print("Enter PIN to check final balance: ");
        int finalPin = sc.nextInt();
        c1.checkBalance(finalPin);

        sc.close();
    }
}
