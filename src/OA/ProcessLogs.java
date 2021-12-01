package OA;

import java.util.*;

public class ProcessLogs {

    public static List<String> processLogs(List<String> logs, int maxSpan) {
        Map<Integer, List<Integer>> logMap = new HashMap<>();
        for(String log: logs) {
            String[] entries = log.split(" ");
            int id = Integer.valueOf(entries[0]);
            if(logMap.containsKey(id)) {
                if(entries[2].equals("sign-in")) {
                    logMap.get(id).add(0, Integer.valueOf(entries[1]));
                }
                if(entries[2].equals("sign-out")) {
                    logMap.get(id).add(1, Integer.valueOf(entries[1]));
                }
            } else {
                logMap.put(id, new ArrayList<>());
                if(entries[2].equals("sign-in")) {
                    logMap.get(id).add(0, Integer.valueOf(entries[1]));
                }
                if(entries[2].equals("sign-out")) {
                    System.out.println(id);
                    logMap.get(id).add(1, Integer.valueOf(entries[1]));
                }
            }
        }
        List<Integer> ids = new ArrayList<>();
        for(int key : logMap.keySet()) {
            int inVal = logMap.get(key).get(0);
            int outVal = logMap.get(key).size() > 1 ? logMap.get(key).get(1): Integer.MAX_VALUE;
            if((outVal - inVal) <= maxSpan) {
                ids.add(key);
            }
        }
        Collections.sort(ids);

        List<String> output = new ArrayList<>();
        for(int val : ids) {
            output.add(String.valueOf(val));
        }
        return output;
    }

    public static void main(String[] args) {
        List<String> inputlogs = new ArrayList<>();
        /*inputlogs.add("30 99 sign-in");
        inputlogs.add("30 105 sign-out");
        inputlogs.add("12 100 sign-in");
        inputlogs.add("20 80 sign-in");
        inputlogs.add("12 120 sign-out");
        inputlogs.add("20 101 sign-out");
        inputlogs.add("21 110 sign-in");*/

        /*inputlogs.add("99 1 sign-in");
        inputlogs.add("100 10 sign-in");
        inputlogs.add("50 20 sign-in");
        inputlogs.add("100 15 sign-out");
        inputlogs.add("50 26 sign-out");
        inputlogs.add("99 2 sign-out");*/

        inputlogs.add("60 12 sign-in");
        inputlogs.add("80 20 sign-out");
        inputlogs.add("10 20 sign-in");
        inputlogs.add("60 20 sign-out");

       // System.out.println(processLogs(inputlogs, 20));
       // System.out.println(processLogs(inputlogs, 5));
        System.out.println(processLogs(inputlogs, 100));
    }

}
