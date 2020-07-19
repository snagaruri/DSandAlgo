import java.util.HashSet;

public class DifferenceOne {
    public static void main(String []args){
        System.out.println(solution(new int[]{5,5,5,5}));
    }

    public static boolean solution(int[] A) {
        //base case
        if (A.length < 2) {
            return false;
        }

        HashSet<Integer> hs = new HashSet<>(A.length);
        for (int num: A) {
            hs.add(num);
        }

        for (int num: A) {
            if (hs.contains(num - 1) || hs.contains(num + 1)) {
                return true;
            }
        }

        return false;
    }
}
