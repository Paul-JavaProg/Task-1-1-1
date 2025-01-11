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

    //Creating Constructors of Users
    
        Users(int id,int pin,String name,double balance){
            this.id = id;
            this.pin = pin;
            this.name = name;
            this.balance = balance;
            this.transactionHistory = new ArrayList<>();
        }
        //Getters
        public int getId(){return id;}
        public int getPin(){return pin;}
        public String getName(){return name;}
        public double getBalance(){return balance;}
        public List<String> getTransactionHistory(){return transactionHistory;}

        //Setters
        public void setBalance(double balance){this.balance = balance;}
        public void setPin(int pin){this.pin = pin;}

        public void addTransaction(String transaction){
            transactionHistory.add(transaction);
        }
        
    
    }
    
public class Banking {
    public static final List<Users> users = new ArrayList<>(
    Arrays.asList(
        new Users(412435, 7452, "Chris Sandoval", 32000),
        new Users(264863, 1349, "Marc Yim", 1000)));
    
    public static Users loggedInUsers = null;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        while (true) {
            try{
                System.out.println("-----Banking App------");
    
            if (loggedInUsers == null) {
                System.out.println("Welcome Good Day!");
                System.out.println("1. Log In");
                System.out.println("2. Create New User");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");
    
                int option = getValidatedInt(input);
    
                if (option == 1) 
                    login(input);
                else if(option == 2)
                    registerUser(input);
                else if (option == 3)
                    System.out.println("Thankyou for using Banking App. Goodbye!");
                else{
                    System.out.println("Try Again");
                }         
            }
    
            else{
                System.out.println("How Can I Help You Today");
                System.out.println("1. Withdraw");
                System.out.println("2. Check Balance");
                System.out.println("3. Cash In");
                System.out.println("4. Money Transfer");
                System.out.println("5. Transaction History");
                System.out.println("6. Change Pin");
                System.out.println("7. Log out");
                System.out.print("Select an Option: ");
    
                int option = input.nextInt();
    
                switch (option) {
                    case 1:
                        withdraw(input);
                        break;
                    case 2:
                        checkBalance();
                        break;
                    case 3:
                        cashIn(input);
                        break;
                    case 4:
                        moneyTransfer(input);
                        break;
                    case 5:
                        viewTransactionHistory();
                        break;
                    case 6:
                        changePin(input);
                        break;
                    case 7:
                        logOut();
                        break;
                    default:
                        System.out.println("Invalid Option.");
                        break;
                 }
            }
                
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please input numbers only");
                input.nextLine();
            }

        }
    }
        
//Creating Method for Log In   
private static void login(Scanner input) {

    System.out.print("Enter you ID: ");
    int id = getValidatedInt(input);

    System.out.print("Enter your Pin: ");
    int pin = getValidatedInt(input);

    for (Users user : users) {

        if(user.getId() == id && user.getPin() == pin){
            loggedInUsers = user;
            System.out.println("Welcome "+ user.getName() + "!");
            return;
        }
        
    }
    System.out.println("Invalid Pin or Id. Try Again");
    
}
//Creating New Users
private static void registerUser(Scanner input){
    System.out.println("Enter new user ID: ");
    int id = getValidatedInt(input);

    for (Users user : users) {
        if(user.getId() == id){
            System.out.println("ID Already exist!. Try Again");
            return;
        }
        
    }
    System.out.print("Enter Pin: ");
    int pin = getValidatedInt(input);

    System.out.print("Enter User Name: ");
    input.nextLine();
    String name = input.nextLine();

    System.out.print("Enter Balance: ");
    double balance = getValidatedDouble(input);

    Users newUsers = new Users(id, pin, name, balance);
    users.add(newUsers);

    System.out.println("Registered Successfully");
}
private static void withdraw(Scanner input){
    System.out.println("Enter amount to withdraw: ");
    double amount = getValidatedDouble(input);

    if (amount <= 0) {
        System.out.println("Invalid amount. Please enter a valid amount! "); 
        return;
    }
    if (amount > loggedInUsers.getBalance()){
        System.out.println("Insufficient amount. Transacton failed!");
    }
    double newBalance = loggedInUsers.getBalance() - amount;
    loggedInUsers.setBalance(newBalance);

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formatedTimeDate = now.format(formatter);

    String log = "Withdraw: " + amount + "|New Balance: " + newBalance + " | " + formatedTimeDate;
    loggedInUsers.addTransaction(log);
}

//Creating Method for Checking Balance
private static void checkBalance() {
        System.out.println("Hello " + loggedInUsers.getName() +" Your balance is $" + loggedInUsers.getBalance());

    }

//Creating Method for Cash In
private static void cashIn(Scanner input){

    System.out.print("Enter amount to cash in: ");
    double amount = getValidatedDouble(input);

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

//Creating Method for Money Transfer
private static void moneyTransfer(Scanner input){

    System.out.print("Enter ID Receipient: ");
    int idReceipient = getValidatedInt(input);

    System.out.print("Enter Amount to Transfer: ");
    double amount = getValidatedDouble(input);

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

//Creating Method for Viewing Transactions
private static void viewTransactionHistory(){
    System.out.println("Transaction History for " + loggedInUsers.getName() + " Break it down yow! hahah");
    System.out.println("----------------------");

    if (loggedInUsers.getTransactionHistory().isEmpty()) {
        System.out.println("No Transaction Found");
    } else {
        for(String log : loggedInUsers.getTransactionHistory()){
            System.out.println(log);
        }
    } 

}
//Method for Changing Pins
private static void changePin(Scanner input){
    System.out.print("Enter Current Pin: ");
    int currentPin = getValidatedInt(input);
    if (currentPin == loggedInUsers.getPin()) {
        int newPin;
        while (true) {
            System.out.print("Enter New Pin: ");
            newPin = getValidatedInt(input);

            if (String.valueOf(newPin).length() == 4) {
                break;   
            } else {
                System.out.println("Please input 4 digits pin only! ");
            }  
        }

        System.out.print("Confirm New Pin: ");
        int confirmNewPin = getValidatedInt(input);

        if (newPin == confirmNewPin) {
            loggedInUsers.setPin(newPin);
            System.out.println("Your PIN has successfuly change");
        } else {
            System.out.println("Pin doesn't match. Please try again");
        }
        
    } else {
        System.out.print("Invalid Pin. Please try again.");
        
    }
}

//Creating Methods for Log Out
private static void logOut(){
    System.out.println("Thank you for using this app. Goodbye! " + loggedInUsers.getName());
    loggedInUsers = null;  
    }  
//Creating Methods for Validation 
private static int getValidatedInt(Scanner input){
    while (true) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Invalid input. Please input a valid number: ");
            input.nextLine();
        }  
    }   
}
private static double getValidatedDouble(Scanner input){
    while (true) {
        try {
            return input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.print("Invalid input. Please input a valid number: ");
            input.nextDouble();
            }
        }
    }
}
    

