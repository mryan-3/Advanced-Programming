package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(int amount, @NotNull Calendar date){
        super(amount, date);
    }
    private boolean checkDepositAmount(int amt){
        return amt >= 0;
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails(){
        System.out.println("Deposit Transaction: "+this.toString());
    }

    public void apply(BankAccount ba){
        double curr_balance = ba.getBalance();
    
        if (!checkDepositAmount(this.getAmount())) {
            throw new IllegalArgumentException("Deposit amount must be non-negative");
        }
        ba.setBalance(curr_balance + this.getAmount());
    }
}
