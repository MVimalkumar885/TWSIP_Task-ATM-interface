import java.util.Scanner;

interface FinancialTransactor {
    void transferFunds(double amount);
    void depositAssets(double amount);
    double retrieveBalance();
    void displayTransactionOptions();
}

class FinancialTransactorImpl implements FinancialTransactor {
    private double accountBalance;

    public FinancialTransactorImpl(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    @Override
    public void transferFunds(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Transfer successful. New balance: " + accountBalance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    @Override
    public void depositAssets(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful. New balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public double retrieveBalance() {
        return accountBalance;
    }

    @Override
    public void displayTransactionOptions() {
        System.out.println("Transaction Options:");
        System.out.println("1. Transfer Funds");
        System.out.println("2. Deposit Assets");
        System.out.println("3. Retrieve Balance");
        System.out.println("4. Exit");
    }
}

public class ATMInterface{
    public static void main(String[] args) {
        FinancialTransactor transactor = new FinancialTransactorImpl(100000.0);

        while (true) {
            transactor.displayTransactionOptions();
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = new Scanner(System.in).nextDouble();
                    transactor.transferFunds(transferAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = new Scanner(System.in).nextDouble();
                    transactor.depositAssets(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + transactor.retrieveBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}