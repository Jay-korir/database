package databases.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private  int pinNumber;

    private double checkingBalance = 0;
    private double  savingBalance = 0;


    Scanner input = new Scanner(System.in);
    DecimalFormat moneyF = new DecimalFormat("'$',###,##0.00");
    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerName) {
        this.customerNumber = customerName;
        return customerNumber;

    }

    public int getPinNumber() {
        return pinNumber;

    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
    public double calCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }
    public double calSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
public  double calCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
}
public double calSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
}
public void getCheckingWithdrawInput(){
    System.out.println("checking account balance :"+ moneyF.format(checkingBalance));
    System.out.println("amount to withdraw:  ");
    double amount = input.nextDouble();

    if ((checkingBalance - amount) >= 0){
        calCheckingWithdraw(amount);
        System.out.println("new balance is: "+ moneyF.format(checkingBalance));

    }else
        System.out.println("insufficient balance");
}
    public void getSavingWithdrawInput(){
        System.out.println("checking account balance :"+ moneyF.format(savingBalance));
        System.out.println("amount to withdraw:  ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0){
            calSavingWithdraw(amount);
            System.out.println("new balance is: "+ moneyF.format(savingBalance));

        }else
            System.out.println("insufficient balance");
    }
    public void getCheckingDepositInput(){
        System.out.println("balance: "+ moneyF.format(checkingBalance));
        System.out.println("enter amount to deposit");
        double amount = input.nextDouble();
        if ((checkingBalance + amount) >= 0){
            calCheckingDeposit(amount);
            System.out.println("new balance :" + moneyF.format(checkingBalance));

        }else
            System.out.println("negative balance"+ "\n");
    }
    public void getSavingDepositInput(){
        System.out.println("balance: "+ moneyF.format(savingBalance));
        System.out.println("enter amount to deposit");
        double amount = input.nextDouble();
        if ((savingBalance + amount) >= 0){
            calSavingDeposit(amount);
            System.out.println("new balance :" + moneyF.format(savingBalance));

        }else
            System.out.println("negative balance"+ "\n");
    }
}
