package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkWithdrawalAmount(int amt) {
        return amt >= 0;
    }

    // Method to reverse the transaction
    public boolean reverse() {
        return true;
    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this.toString());
    }

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */
    public void apply(BankAccount ba) {
        if (!checkWithdrawalAmount(this.getAmount())) {
            throw new IllegalArgumentException("Withdrawal amount must be non-negative");
        }
        
        double curr_balance = ba.getBalance();
        if (curr_balance >= getAmount()) {
            ba.setBalance(curr_balance - getAmount());
        } else {
            throw new IllegalStateException("Insufficient funds for withdrawal");
        }
    }

    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
}

