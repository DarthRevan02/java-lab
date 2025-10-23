// Base class for Bank Account
class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    
    public static void main(String args[]) {
        CurrentAccount ca = new CurrentAccount("CA123", "Alice", 5000, 1000);
        SavingsAccount sa = new SavingsAccount("SA456", "Bob", 3000, 4.5);

        ca.deposit(1000);
        ca.withdraw(6000);
        ca.displayDetails();

        sa.deposit(500);
        sa.addInterest();
        sa.displayDetails();
    }

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// Current Account class
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance + overdraftLimit >= amount) {
            balance -= amount;
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

// Savings Account class
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate / 100;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}