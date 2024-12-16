package JavaFundamentals;

public class Methods {
    
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5,6,7,8,9};
        int result = summation(numbers);
        System.out.println(result);
        
    }
    static int summation(int numbers[]){
       int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        } 
        return sum;

    }
}
