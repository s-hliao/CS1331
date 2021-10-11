import java.util.Scanner;
public class GuessNum {

    public static void main(String[] args) {
        int num = 1+ (int) (Math.random()*10);
        
        Scanner sc = new Scanner(System.in);
        
        boolean found = false;
        while(!found) {
            System.out.print("Guess a number: ");
            
            String guess = sc.next();
            if (guess.equals("quit")) {
                System.out.println("Lame. It was "+num+".");
                found = true;
            }
            else if(Integer.parseInt(guess)<num) {
                System.out.println("Higher");
            } else if (Integer.parseInt(guess)>num){
                System.out.println("Lower");
            } else if(Integer.parseInt(guess)==num) {
                System.out.println("Yay! You guessed it. It was "+num+".");
                found = true;
            }
        }

    }

}
