 //Save file name as AtmApp.java


import java.util.Scanner;

class Customer{
    String name;
    int cid;
    int accno;
    String branch;
    String bank;
    int inibal=0;
    int mypin=5566;
    public Customer(String name,int cid,int accno,String branch,String bank){
        this.name=name;
        this.cid=cid;
        this.accno=accno;
        this.branch=branch;
        this.bank=bank;
    }
    public void display(){
        System.out.println("Name is "+this.name);
        System.out.println("Cid is "+this.cid);
        System.out.println("AccNo is "+this.accno);
        System.out.println("Branch is "+this.branch);
        System.out.println("Bank is "+this.bank);
    }

    public void deposit(int amount){
        if(amount>0){
            inibal+=amount;
        }
        System.out.println("Deposit successfully!");
    }

    public void withdraw(int pin,int amount){
        
        if(pin==mypin && amount<=inibal){
            inibal-=amount;
            System.out.println("Done Successfully!");
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }





    public void checkBalance(int pin){
        
        if(pin==mypin){
            System.out.println("Balance is: "+inibal);
        }
        else{
            System.out.println("Sorry Incorrect Pin");
        }

    }
    Scanner sc=new Scanner(System.in);
    public void changePin(int pin){
        if(pin==mypin){
            System.out.println("Enter your new pin: ");
            int newpin=sc.nextInt();
            mypin=newpin;
            System.out.println("Pin changed successfully"+mypin);

        }
    }


