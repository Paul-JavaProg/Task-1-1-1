interface Animal {
    boolean feed(boolean timeToEat);
    void groom();
    void pet();
}
class Gorilla implements Animal{
    public boolean feed(boolean timeToEat){
        // put gorilla food into cage
        if (timeToEat){
            System.out.println("Feeding the Gorilla");
            return true;
        }else {
            System.out.println("Its not feeding time");
            return false;
        }
    }
    @Override
    public void groom(){
        // lather, rinse, repeat
        System.out.println("Gromming the Gorilla");
    }
    @Override
    public void pet(){
        // pet at your own risk
        System.out.println("Pet at your own risk");
    }
}
public class Tasksheet129 {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();
        System.out.println("Feeding " + gorilla.feed(true));
        gorilla.groom();
        gorilla.pet();
    }
    
}
