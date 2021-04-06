package OA;

import java.util.*;

/*
* This was asked in the 'Qualtrics' phone interview.
* e.g: [["SEA", "SLC"], ["SLC", "LXA"], ["SLC", "SEA"], ["SEA", "SLC"]], k=2, src = "SEA", dest = "LXA"
* */
public class DestinationWithKTickets {
    public static void main(String[] args){
        List<String> ticket0 = new ArrayList<>(Arrays.asList("SEA", "BULG"));
        List<String> ticket1 = new ArrayList<>(Arrays.asList("SEA", "SLC"));
        List<String> ticket2 = new ArrayList<>(Arrays.asList("SLC", "LXA"));
        List<String> ticket3 = new ArrayList<>(Arrays.asList("SLC", "SEA"));
        List<String> ticket4 = new ArrayList<>(Arrays.asList("SEA", "SLC"));

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(ticket0);
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);

        System.out.println(isPossibleToReach(tickets, "SEA", "LXA", 3));

    }
    public static boolean isPossibleToReach(List<List<String>> tickets, String src, String dest, int k) {
        Map<String, List<String>> ticketMap = new HashMap<>();
        for(List<String> ticket : tickets) {
            if(ticketMap.containsKey(ticket.get(0))) {
                ticketMap.get(ticket.get(0)).add(ticket.get(1));
            } else {
                ticketMap.put(ticket.get(0), new ArrayList<>());
                ticketMap.get(ticket.get(0)).add(ticket.get(1));
            }
        }
        boolean result = isPossibleToReachHelper(src, dest, k, 0, ticketMap);
        return result;
    }
    public static boolean isPossibleToReachHelper(String src, String dest, int k, int count, Map<String, List<String>> ticketMap) {
        /*if(ticketMap.containsKey(src) && ticketMap.get(src).size() > 0) {
            for(String str : ticketMap.get(src)) {
                count++;
                if(str.equals(dest) && count == k) {
                    return true;
                }
                ticketMap.get(src).remove(str);
                if(isPossibleToReachHelper(str, dest, k, count, ticketMap)) {
                    return true;
                }
            }
        }*/
        if(src.equals(dest) && count == k) {
            return true;
        }
        List<String> destinations = ticketMap.get(src);
        while(destinations != null && destinations.size() > 0) {
            count++;
            if(isPossibleToReachHelper(destinations.remove(0), dest, k, count, ticketMap)) {
                return true;
            }
            count--;
        }
        return false;
    }
}
