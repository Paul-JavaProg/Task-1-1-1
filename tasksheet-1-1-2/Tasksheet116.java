import java.util.Scanner;

public class Tasksheet116 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter any ");
        String input = scan.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();

        if (input.equals(reversed)) 
            System.out.println("The input string is a palindrome.");
        else System.out.println("The input string is not a palindrome.");

        scan.close();
    }
    
}
