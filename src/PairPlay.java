import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

// Reference doc: https://stackoverflow.com/questions/28344312/hashset-usage-with-int-arrays
// See the Udemy Java course's HashSet video: https://www.udemy.com/course/java-in-depth-become-a-complete-java-engineer/learn/lecture/5162842#overview
public class PairPlay {
    public static void main(String []args){
         Set<int[]> intSet1 = new HashSet<>();
         intSet1.add(new int[]{1,2});
         intSet1.add(new int[]{1,2});
         System.out.println("intSet1 size is:" + intSet1.size());

         Set<int[]> intSet2 = new HashSet<>();
         intSet2.add(new int[]{1,2});
         intSet2.add(new int[]{1,2});
         System.out.println("intSet2 size is:" + intSet2.size());

         Set<Set<int[]>> intSet = new HashSet<>();
         intSet.add(intSet1);
         intSet.add(intSet2);
         System.out.println("intSet size is:" + intSet.size());

        Set<Pair<Integer, Integer>> pairSet1 = new HashSet<>();
        pairSet1.add(new Pair<>(1,2));
        pairSet1.add(new Pair<>(1,2));
        System.out.println("pairSet1 size is:" + pairSet1.size());

        Set<Pair<Integer, Integer>> pairSet2 = new HashSet<>();
        pairSet2.add(new Pair<>(1,2));
        pairSet2.add(new Pair<>(1,2));
        System.out.println("pairSet2 size is:" + pairSet2.size());

        Set<Set<Pair<Integer, Integer>>> pairSet = new HashSet<>();
        pairSet.add(pairSet1);
        pairSet.add(pairSet2);
        System.out.println("pairSet size is:" + pairSet.size());
    }
}
