package OA;

public class MinDaysForMissions {
    public static void main(String []args){
        System.out.println("Hello World");
        int[] levelArr = new int[]{5,8,2,7};
        int[] levelArr1 = new int[]{2,5,9,2,1,4};
        int[] levelArr2 = new int[]{1,12,10,4,5,2};
        System.out.println(solution(levelArr, 3));
        System.out.println(solution(levelArr1, 4));
        System.out.println(solution(levelArr2, 2));

    }

    public static int solution(int[] levelArr, int x) {
        int count = 0;
        int j = 0;
        for(int i = 0; i < levelArr.length; ) {
            int localMin = levelArr[i];
             int localMax = levelArr[i];
            count++;
            for(j = i+1; j < levelArr.length; j++) {
                if((Math.abs(levelArr[j] - levelArr[j-1])) > x || (Math.abs(levelArr[j] - localMin)) > x || (Math.abs(levelArr[j] - localMax)) > x) {
                    break;
                }
                if(levelArr[j] < localMin) {
                    localMin = levelArr[j];
                }
                if(levelArr[j] > localMax) {
                    localMax = levelArr[j];
                }
            }
            // count++;
            i = j;
        }
        return count;
    }
}
