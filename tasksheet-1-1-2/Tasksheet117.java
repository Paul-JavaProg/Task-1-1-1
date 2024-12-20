import java.util.Scanner;
public class Tasksheet117 {
    public static void main(String[] args) {
              
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the first number:");
        int num1 = s.nextInt();
        System.out.print("Enter the second number:");
        int num2 = s.nextInt();
        System.out.print("Enter the third number:");
        int num3 = s.nextInt();

        printLargestNumber(num1, num2, num3);
        s.close();
    }
    static void printLargestNumber(int num1, int num2, int num3) {
        if (num1 == num2 && num2 == num3) 
            System.out.println("All numbers are equal"); 
        else{
            int largest = num1;
            if (largest < num2)
                largest = num2;
            if (largest < num3)
                largest = num3;
            System.out.println("The largest number is "+ largest);        
        } 
    }
    
}
