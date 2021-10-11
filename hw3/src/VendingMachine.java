import java.util.Random;

/**
 * Represents a vending machine that sells multiple types of VendingItems,
 * 
 * @author henry
 * @version 1.0
 */
public class VendingMachine {
    private static double totalSales;
    private VendingItem[][][] shelf;
    private int luckyChance;
    private Random rand;
    
    /**
     * Constructs an empty VendingMachine.
     */
    public VendingMachine() {
        totalSales = 0;
        shelf = new VendingItem[6][3][5];
        luckyChance = 0;
        rand = new Random();
    }

    /**
     * Sells a VendingItem given a valid code.
     * @param code A valid code in letter-number format e.g. "A3"
     * @return null if code is invalid, otherwise the item sold
     */
    public VendingItem vend(String code) {
        if (code.length() != 2) {
            System.out.println("Code is not 2 letters in length.");
            return null;
        }

        int row = code.charAt(0) - 'A';
        if (row < 0 || row >= 6) {
            System.out.println("Row is not a letter in range.");
            return null;
        }

        int col = code.charAt(1) - '1';
        if (col < 0 || col >= 3) {
            System.out.println("Column is not a number in range.");
            return null;
        }
        
        if(shelf[row][col][0]==null) {
            System.out.println("No item at given position.");
            return null;
        }
        
        if(!free()) {
            totalSales+=shelf[row][col][0].getPrice();
        } else {
            System.out.println("Item was given for free!");
        }
        
        VendingItem item = shelf[row][col][0];
        
        for(int i = 0; i<4; i++) {
            shelf[row][col][i] = shelf[row][col][i+1];
        }
        shelf[row][col][4] = null;
        
        return item;
    }

    /**
     * Determines the chance of the VendingItem being sold for free.
     * @return
     */
    private boolean free() {
        if (rand.nextInt(100) < luckyChance) {
            luckyChance = 0;
            return true;
        }
        luckyChance++;
        return false;
    }

    /**
     * Refills the VendingMachine with random items.
     */
    public void restock() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    shelf[i][j][k] = VendingItem.values()[rand.nextInt(16)];
                }
            }
        }
    }

    /**
     * @return the total sales made by all VendingMachines
     */
    public static double getTotalSales() {
        return totalSales;
    }

    /**
     * Counts the number of items in the VendingMachine.
     * @return the number of items in the VendingMachine
     */
    public int getNumberOfItems() {
        int number = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (shelf[i][j][k] != null) {
                        number++;
                    }
                }
            }
        }
        return number;
    }
    
    /**
     * Calculates the total value of items in the VendingMachine.
     * @return the total value of items in the VendingMachine
     */
    public double getTotalValue() {
        double total = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (shelf[i][j][k] != null) {
                        total += shelf[i][j][k].getPrice();
                    }
                }
            }
        }
        return total;
    }

    /**
     * @return the chance out of 100 that an item is given for free.
     */
    public int getLuckyChance() {
        return luckyChance;
    }

    /**
     * Provides a user interface for interacting with the VendingMachine.
     * @return A string representation of the VendingMachine.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                            VendaTron 9000                "
            + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                    (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("There are %d items with a total "
            + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
            + "is now: $%.2f.%n", getTotalSales()));
        return s.toString();
    }
}
