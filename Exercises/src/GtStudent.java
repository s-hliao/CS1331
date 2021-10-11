import java.util.Collections;
import java.util.*;

public class GtStudent implements Comparable<GtStudent> {
    private String name;
    private String major;
    private double GPA;
    private int year;
    
    @Override
    public int compareTo(GtStudent other) {
        return (int) Math.signum(GPA-other.GPA);
    }
    
    public static void main(String[]args) {
        List<GtStudent>gs = new ArrayList<>();
        Collections.sort(gs, new Comparator<GtStudent>() {

            @Override
            public int compare(GtStudent arg0, GtStudent arg1) {
                // TODO Auto-generated method stub
                return 0;
            }
            
        });
    }
    
}
