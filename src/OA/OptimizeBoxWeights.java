package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptimizeBoxWeights {
    public static void main(String []args){
       // List<Integer> weights = new ArrayList<>(Arrays.asList(1,2,2,3,4,5));
       // List<Integer> weights = new ArrayList<>(Arrays.asList(2,3,5,6,7));
        List<Integer> weights = new ArrayList<>(Arrays.asList(2,3,5,6,7));
        System.out.println(minimalHaviestWeight(weights));
    }

    public static List<Integer> minimalHaviestWeight(List<Integer> arr) {
        Collections.sort(arr);
        List<Integer> lSum = new ArrayList<>();
        List<Integer> rSum = new ArrayList<>();
        int lCumSum = 0;
        int size = arr.size();
        for(int i = 0; i < arr.size(); i++) {
            lCumSum += arr.get(i);
            lSum.add(lCumSum);
        }
        for(int i = 0; i < arr.size(); i++) {
            rSum.add(lCumSum - lSum.get(i));
        }

        int idx;
        for(idx = size-1; idx >= 0; idx--) {
            if(rSum.get(idx) > lSum.get(idx)) {
                break;
            }
        }
        List<Integer> output = new ArrayList<>();
        for(int i = idx+1; i < size;i++) {
            output.add(arr.get(i));
        }
        return output;
    }
}
