import java.sql.SQLOutput;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       // BankAccount obj1 = new BankAccount("XYZ","BA0009");
      //  obj1.showMenu();

        BankAccount obj2 = new BankAccount("Kuldeep","AK0989");
        obj2.showMenu();
    }

}
class BankAccount{

    int balance;
    int prevTransction;
    String custName;
    String custId;

    BankAccount(String cusname, String cusid){
        custName = cusname;
        custId = cusid;
    }

    void deposit(int amount){
        if(amount > 0){
            balance += amount; ///
            prevTransction = amount;
        }

    }

    void withdrawn(int amount){
        if (amount !=0){
            balance -= amount;
            prevTransction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (prevTransction > 0){
            System.out.println("Deposited " + prevTransction);
        } else if (prevTransction < 0) {
            System.out.println("Withdrawn " + Math.abs(prevTransction));
        } else {
            System.out.println("No Transaction is occured");
        }
    }

    void showMenu(){
        char options = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + custName);
        System.out.println("Your ID is " + custId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit Balance");
        System.out.println("C. Withdrawn Balance");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("==============================================================");
            System.out.println("Enter an option");
            System.out.println("==============================================================");
            options = sc.next().charAt(0);
            System.out.println("\n");

            switch (options){
                case 'A':
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("----------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Enter an amount to deposit:");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("------------------------------------------------------------");
                    int amount2 = sc.nextInt();
                    withdrawn(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("------------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("-------------------------------------------------------------");
                    break;

                default:
                    System.out.println("Invalid option!!.Please enter again");
                    break;
            }
        } while (options != 'E');
        System.out.println("Thank you for using our service");
    }
}
