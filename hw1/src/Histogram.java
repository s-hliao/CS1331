import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Histogram {
    public static void main(String[] args) throws IOException {

        int numBins;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        if (args.length == 1) {
            Scanner input = new Scanner(System.in);
            System.out.println("How many bins would you like?");
            numBins = input.nextInt();
            input.close();
        } else {
            numBins = Integer.parseInt(args[1]);
        }

        int[] bins = new int[numBins];
        int binSize = 101 / numBins;

        int min = binSize - 1;
        int remainder = 101 % numBins;
        if (101 % numBins != 0) {
            min += remainder;
        }
        
        

        Scanner grades = new Scanner(new File(args[0]));
        while (grades.hasNextLine()) {
            String entry = grades.nextLine();
            String second = entry.split(",")[1];
            int index = second.length() - 1;
            while (index >= 0 && second.charAt(index) != ' ') {
                index--;
            }
            int score = Integer
                    .parseInt(second.substring(index + 1, second.length()));

            int bin = (score - remainder) / binSize;
            bins[bin]++;
        }

        for (int i = numBins - 1; i >= 0; i--) {
            int high = min + i * binSize;
            int low = (i==0) ? 0 : high - binSize + 1;


            String output = "";
            if (high < 10) {
                output += " ";
            }

            if (high != 100) {
                output += " ";
            }

            output += high + " - ";

            if (low < 10) {
                output += " ";
            }

            output += low + " | ";

            System.out.print(output);

            for (int j = 0; j < bins[i]; j++) {
                System.out.print("[]");
            }

            System.out.println();
            
        }
        throw new RuntimeException();
    }
}
