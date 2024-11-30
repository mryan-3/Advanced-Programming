package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private double originalBalance;
    private boolean isReversed = false

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
        this.originalBalance = 0;
    }

    private boolean checkWithdrawalAmount(int amt) {
        return amt >= 0;
    }

    // Method to reverse the transaction
    public boolean reverse( BankAccount ba) {
        if (isReversed) {
            System.out.println("Transaction already reversed");
            return false;
        }

        this.originalBalance = ba.getBalance();
        ba.setBalance(currentBalance + getAmount());
        isReversed = true;
        System.out.println("Transaction Reversed");
        return true;
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this.toString());
    }

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */
    public void apply(BankAccount ba) throws InsufficientFundsException {
         this.originalBalance = ba.getBalance();
        double currentBalance = ba.getBalance();
        double amountNotWithdrawn = 0;
        try {
           if (currentBalance >= getAmount()) {
              double new_balance = currentBalance - getAmount();
              ba.setBalance(new_balance);
           } else if(currentBalance > 0){
               ba.setBalance(0);
               amountNotWithdrawn = getAmount() - currentBalance;
               throw new InsufficientFundsException("Insufficient Funds. Amount not withdrawn: " + amountNotWithdrawn);
           } else{
               throw new InsufficientFundsException("Insufficient Funds");
           }

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("Transaction Completed");
        }
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
}

