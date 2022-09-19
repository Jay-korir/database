package databases.atm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends  Account{

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyF = new DecimalFormat("'$',###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public  void getLogin(){
        int x = 1;
        do {
            try {
                data.put(952141,191904);
                data.put(989947,71976);

                System.out.println("Welcome");
                System.out.println("enter customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("enter your pin");
                setPinNumber(menuInput.nextInt());

            }catch (Exception e){
            System.out.println("\n" + "Invalid input.only numbers"+"\n");
            x =2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn)&&data.get(cn) == pn){
                getAccountType();
            }else
                System.out.println("wrong customer or pin number"+ "\n");

        }while (x==1);
    }

    public  void getAccountType(){
        System.out.println("select account :");
        System.out.println("type 1 - checking account");
        System.out.println("type 2 - saving account");
        System.out.println("type 3- exiting");

        int selection = menuInput.nextInt();
        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("thank you for choosing me");
                break;

            default:
                System.out.println("invalid choice");
        }
    }
    public  void getChecking(){
        System.out.println("welcome to check account");
        System.out.println("1 - view balance");
        System.out.println("2 - withdraw");
        System.out.println("3- deposit");
        System.out.println("4: exit");
        System.out.println("your Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("checking account balance: " + moneyF.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case  3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("thank you for-welcome again");
                getAccountType();
                break;
            default:
                System.out.println("invalid input");
                getChecking();
        }
    }
    public void getSaving(){
        System.out.println("welcome to savings account");
        System.out.println("1 - view balance");
        System.out.println("2 - withdraw");
        System.out.println("3- deposit");
        System.out.println("4: exit");
        System.out.println("your Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("checking account balance: " + moneyF.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case  3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("thank you for-welcome again");
                getAccountType();
                break;
            default:
                System.out.println("invalid input");
                getSaving();
        }
    }
}
