import java.util.Scanner;
public class ATM {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.print("Enter initial account balance: $");
 double initialBalance = input.nextDouble();
 BankAccount userAccount = new BankAccount(initialBalance);
     ATMController atmController = new ATMController(userAccount);
     atmController.run();
    }
}
class BankAccount {
   private double balance;
 public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
public String deposit(double amount) {
      this.balance += amount;
      return String.format("Deposited $%.2f. New balance: $%.2f", amount, this.balance);
    }
public String withdraw(double amount) {
       if (amount > this.balance) {
            return "Insufficient funds. Withdrawal failed.";
        } else {
            this.balance -= amount;
           return String.format("Withdrew $%.2f. New balance: $%.2f", amount, this.balance);
        }
    }
public String checkBalance() {
        return String.format("Current balance: $%.2f", this.balance);
    }
}
class ATMController {
    private BankAccount userAccount;
    private Scanner scanner;
 public ATMController(BankAccount userAccount) {
       this.userAccount = userAccount;
      this.scanner = new Scanner(System.in);
    }
public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
    }
public void executeOption(int option) {
        switch (option) {
            case 1:
               System.out.print("Enter withdrawal amount: $");
              double withdrawAmount = scanner.nextDouble();
              System.out.println(userAccount.withdraw(withdrawAmount));
                break;
            case 2:
              System.out.print("Enter deposit amount: $");
              double depositAmount = scanner.nextDouble();
              System.out.println(userAccount.deposit(depositAmount));
                break;
            case 3:
              System.out.println(userAccount.checkBalance());
              break;
            default:
System.out.println("Invalid option. Please choose a valid option.");
        }
    }
 public void run() {
        while (true) {
            displayOptions();
            System.out.print("Choose an option (1-3, 0 to exit): ");
            int option = scanner.nextInt();
            if (option == 0) {
                System.out.println("Exiting ATM. Thank you!");
                break;
            }
            executeOption(option);
        }
    }
}
