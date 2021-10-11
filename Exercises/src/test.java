
public class test {
    
    public static int cursor = 0;

    public static void main(String[] args) {
        
        
        System.out.println(hello());
        System.out.println(cursor);
    }
    
    public static int hello() {
        int[]arr = {2, 3, 4, 5};
        
        return arr[cursor++];
        
    }

}
