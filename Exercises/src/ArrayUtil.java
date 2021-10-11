7/**
 * Utility methods for integer arrays.
 * 
 * @author hliao62
 * @version 1.0
 */
public class ArrayUtil {

    /**
     * Creates a new array with the first n elements of xs.
     * 
     * @param n the number of elements in return array
     * @param xs the source array
     * @return array of length n with first n elements of xs
     */
    public static int[] take(int n, int[] xs) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = xs[i];
        }
        return ret;
    }

    /**
     * Creates a new array with the last n elements of xs.
     * 
     * @param n the number of elements in return array
     * @param xs the source array
     * @return array of length n with last n elements of xs
     */
    public static int[] drop(int n, int[] xs) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = xs[n - 1 - i];
        }
        return ret;
    }

    /**
     * Determines whether the contents of two arrays are equal or not.
     * 
     * @param xs array 1
     * @param ys array 2
     * @return whether xs and ys are equal or not
     */
    public static boolean equals(int[] xs, int[] ys) {
        if (xs.length == ys.length) {
            for (int i = 0; i < xs.length; i++) {
                if (xs[i] != ys[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Concatenates array 1 and array 2.
     * 
     * @param xs source array 1
     * @param ys source array 2
     * @return array with elements of ys after xs
     */
    public static int[] concat(int[] xs, int[] ys) {
        int[] ret = new int[xs.length + ys.length];
        for (int i = 0; i < xs.length; i++) {
            ret[i] = xs[i];
        }

        for (int i = 0; i < ys.length; i++) {
            ret[i + xs.length] = ys[i];
        }
        return ret;
    }

    /**
     * @param xs source array
     * @return string representation of array
     */
    public static String toString(int[] xs) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < xs.length - 1; i++) {
            sb.append(xs[i] + ", ");
        }
        sb.append(xs[xs.length - 1] + "}");

        return sb.toString();
    }

    /**
     * @param as 2D source array
     * @return string representation of array
     */
    public static String toString(int[][] as) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < as.length - 1; i++) {
            sb.append(toString(as[i]) + ",\n");
        }
        sb.append(toString(as[as.length - 1]) + "}");

        return sb.toString();
    }

    /**
     * Returns and identity matrix of size n.
     * 
     * @param n size of square matrix
     * @return n x n identity matrix
     */

    public static int[][] identity(int n) {
        int[][] id = new int[n][n];
        for (int i = 0; i < n; i++) {
            id[i][i] = 1;
        }
        return id;
    }

}
