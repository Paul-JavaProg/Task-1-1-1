public class Tasksheet114{
    public static void main(String[] args) {
        
        int check_number = 10;
        String message; 

        for(int i = 1; i <= check_number;){

            message = (i%2==0) ? i+" is even number" : i+" is odd number"; i++;
            System.out.println(message);
            
        } 
    }    
}