package PORTFOLIO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Users{
    private int id;
    private int pin;
    private String name;
    private double balance;
    private List<String> transactionHistory;
    
        Users(int id,int pin,String name,double balance){
            this.id = id;
            this.pin = pin;
            this.name = name;
            this.balance = balance;
            this.transactionHistory = new ArrayList<>();
        }
        public int getId(){return id;}
        public int getPin(){return pin;}
        public String getName(){return name;}
        public double getBalance(){return balance;}
        public void setBalance(double balance){this.balance = balance;}
        public List<String> getTransactionHistory(){return transactionHistory;}

        public void addTransaction(String transaction){
            transactionHistory.add(transaction);
        }
    
    }
    
public class Banking {
    public static final Users[] users = {
        new Users(412435, 7452, "Chris Sandoval", 32000),
        new Users(264863, 1349, "Marc Yim", 1000)};
    
    public static Users loggedInUsers = null;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        while (true) {
                System.out.println("-----Banking App------");
    
            if (loggedInUsers == null) {
                System.out.println("Welcome! Pogi. Good Day!");
                System.out.println("1. Log In");
                System.out.println("2. Exit");
                System.out.print("Choose option: ");
    
                int option = input.nextInt();
    
                if (option == 1) 
                    login(input);
                else if (option == 2)
                    System.out.println("Thankyou for using Banking App. Goodbye!");
                else{
                    System.out.println("Try Again");
                }         
            }
    
            else{
    
                System.out.println("1. Check Balance");
                System.out.println("2. Cash In");
                System.out.println("3. Money Transfer");
                System.out.println("4. Transaction History");
                System.out.println("5. Log out");
                System.out.print("Select an Option: ");
    
                int option = input.nextInt();
    
                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        cashIn(input);
                        break;
                    case 3:
                        moneyTransfer(input);
                        break;
                    case 4:
                        viewTransactionHistory();
                        break;
                    case 5:
                        logOut();
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                 }
            }

        }
    }
        
    
private static void login(Scanner input) {

    System.out.print("Enter you ID: ");
    int id = input.nextInt();

    System.out.print("Enter your Pin: ");
    int pin = input.nextInt();

    for (Users user : users) {

        if(user.getId() == id && user.getPin() == pin){
            loggedInUsers = user;
            System.out.println("Welcome "+ user.getName() + "!");
            return;
        }
        
    }
    System.out.println("Invalid Pin or Id. Try Again");
    
}
private static void checkBalance() {
        System.out.println("Hello " + loggedInUsers.getName() +" Your balance is $" + loggedInUsers.getBalance());

    }
private static void cashIn(Scanner input){

    System.out.print("Enter amount to cash in: ");
    double amount = input.nextDouble();

    if (amount <= 0) {
        System.out.println("Enter a valid number");
        return;
    }

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formatedTimeDate = now.format(formatter);

    double newBalance = loggedInUsers.getBalance() + amount;
    loggedInUsers.setBalance(newBalance);

    String log = "Cash In: $" + amount + "|New Balance: $" + newBalance + " | " + formatedTimeDate;
    loggedInUsers.addTransaction(log);

    System.out.println("Deposited Successfuly. New Balance: $" + loggedInUsers.getBalance());
    }

private static void moneyTransfer(Scanner input){

    System.out.print("Enter ID Receipient: ");
    int idReceipient = input.nextInt();

    System.out.print("Enter Amount to Transfer: ");
    double amount = input.nextDouble();

    if (amount <= 0){
        System.out.println("Invalid Input");
        return;
    }

    boolean receipientFound = false;

    for (Users user : users) {
            
        if (user.getId() == idReceipient){
            receipientFound = true;

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatedDateTime = now.format(formatter);


            if(loggedInUsers.getBalance() >= amount){
                loggedInUsers.setBalance(loggedInUsers.getBalance() - amount);
                user.setBalance(user.getBalance() + amount);

                String senderLog = "Transfer: $" + amount + " to " + user.getName() + " |New Balance: $" + loggedInUsers.getBalance() + " | " + formatedDateTime;
                loggedInUsers.addTransaction(senderLog);

                String reciepientLog = "Transfer: $" + amount + " from " + loggedInUsers.getName() + " |New Balance: $" + user.getBalance() + " | "  + formatedDateTime;
                user.addTransaction(reciepientLog);

                System.out.println("Transferred $" + amount + " to " + user.getName());
                System.out.println("Your New Balance: $" + loggedInUsers.getBalance());
            }
            else{
            System.out.println("Insufficient Balance");
            }
            return;
        }   
    }
    if(!receipientFound){
        System.out.println("Receipient not found!");
    }

}
private static void viewTransactionHistory(){
    System.out.println("Transaction History for " + loggedInUsers.getName() + " Break it down yow! hahah");
    System.out.println("--------------");

    if (loggedInUsers.getTransactionHistory().isEmpty()) {
        System.out.println("No Transaction Found");
    } else {
        for(String log : loggedInUsers.getTransactionHistory()){
            System.out.println(log);
        }
    } 

}
private static void logOut(){
    System.out.println("Thank you for using this app. Goodbye! " + loggedInUsers.getName());
    loggedInUsers = null;  
    }
}

    

