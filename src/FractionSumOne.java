import java.util.HashSet;
import java.util.Set;

public class FractionSumOne {
    public static void main(String []args){
        int[] x = new int[]{1,1,2};
        int[] y = new int[]{3,2,3};
        System.out.println(findNumOfFranctionPairs(x, y));
    }

    // This is not the correct process.
    // Reference: Original question and its solution
    // Leetcode: https://leetcode.com/discuss/interview-question/684355/
    public static int findNumOfFranctionPairs(int[] nume, int[] denom){
       int result = 0;
        double[] fractions = new double[nume.length];
       for(int i = 0; i < nume.length; i++) {
           fractions[i] = (double) nume[i] / denom[i];
           System.out.println(fractions[i]);
       }

       Set<Double> fractSet = new HashSet<>();
       for(int i = 0; i < fractions.length; i++) {
           if(fractSet.contains(1-fractions[i])) {
               result++;
           }
           fractSet.add(fractions[i]);
       }

       return result;
    }

}
