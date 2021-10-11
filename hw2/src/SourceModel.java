import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SourceModel {
    
    private double[][]probabilities;
    private String name;
    
    
    public SourceModel(String name, String path) throws IOException {
        this.name = name;
        
        int[][]matrix = new int[26][26];
        
        System.out.print("Training "+name+" model ... ");
        
        FileReader fr = new FileReader(path);
        int last = -1;
        
        int input;
        
        while((input = fr.read())!= -1 ) {
            char c = (char) input;
            if(Character.isAlphabetic(c)) {
                int x = Character.toLowerCase(c) - 'a';
                if(x >=0 && x<26) {
                    if(last!=-1) {
                        matrix[last][x]++;
                    }
                    last = x;
                    
                }
            }
        }
        
        probabilities = new double[26][26];
        
        for(int i = 0; i<26; i++) {
            int sum = 0;
            for(int j = 0; j<26; j++) {
                sum += matrix[i][j];
            }
            
            for(int j = 0; j<26; j++) {
                
                probabilities[i][j] = (matrix[i][j] == 0) ? .01 : 
                    (double) matrix[i][j] / sum;
            }

        }
        System.out.println("done.");     
    }
    
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("  ");
        for(int i = 0; i<26; i++) {
            sb.append("  "+(char)('a'+i));
        }
        sb.append("\n");
        
        for(int i = 0; i<26; i++) {
            sb.append((char)('a'+i));
            for(int j = 0; j<26; j++) {
                sb.append(String.format(" %.2f", probabilities[i][j]));
            }
            
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public double probability(String test) {
        double probability = 1.0;
        char last = ' ';
        for(int i = 0; i<test.length(); i++) {
            char cur = Character.toLowerCase(test.charAt(i));
            if(Character.isAlphabetic(cur) ) {
                if(last!=' ') {
                    probability *= probabilities[last-'a'][cur-'a'];
                }
                last = cur;
                
            }
        }
        return probability;
    }
    
    public static void main(String[]args) throws IOException {
        SourceModel[]source = new SourceModel[args.length-1];
        
        for(int i = 0; i<args.length-1; i++) {
            source[i] = new SourceModel(args[i].split("\\.")[0], args[i]);
        }
        double[]results = new double[source.length];
        
        double sum = 0;
        double max = 0;
        int maxIndex = 0;
        
        for(int i = 0; i<source.length; i++) {
            results[i] = source[i].probability(args[args.length-1]);
            sum+=results[i];
            
            if(results[i]>max) {
                max = results[i];
                maxIndex = i;
            }
        }
        
        for(int i = 0; i<source.length; i++) {
            System.out.print("Probability that test string is ");
            System.out.print(source[i].getName()+":");
            System.out.printf("%.2f", results[i]/sum);
            
            System.out.println();
        }
        
        System.out.print("Test string is most likely ");
        System.out.println(source[maxIndex].getName()+".");
        
        
        
    }
}
