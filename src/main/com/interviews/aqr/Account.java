package main.com.interviews.aqr;

public abstract class Account{

    private String accId;
    private String nameOfHolder;
    private long accBalance;

    public void debit(int sum){
        validateBalanceForDebit(sum);
        //Logic
    }

    abstract public boolean validateBalanceForDebit(int sum);
}

class SavingsAccount extends Account{
    @Override
    public boolean validateBalanceForDebit(int sum){
        // Logic
        System.out.println("Concrete validation for savings account.");
        return false;
    }
}

class CheckingAccount extends Account{
    @Override
    public boolean validateBalanceForDebit(int sum){
        // Logic
        System.out.println("Concrete validation for checking account.");
        return false;
    }
}

class Driver{
    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount();
        acc.debit(10);

        CheckingAccount chAcc = new CheckingAccount();
        chAcc.debit(10);
    }
}