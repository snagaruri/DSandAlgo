import java.util.*;

public class TopNCompetitors {
    public static ArrayList<String> topNCompetitors (int numCompetitors, int topNCompetitors, List<String> competitors, int numReviews, List<String> reviews) {
        ArrayList<String> compList = new ArrayList<>();
        Map<String, Integer> compMap = new HashMap<>();
        for (String review: reviews) {
            for (String competitor: competitors) {
                if (review.indexOf(competitor) != -1) {
                    compMap.put(competitor, compMap.getOrDefault(competitor, 0) + 1);
                }
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> compQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry m:compMap.entrySet()) {
            compQueue.add(m);
        }

        while (topNCompetitors > 0 && !compQueue.isEmpty()) {
            compList.add(compQueue.poll().getKey());
            topNCompetitors--;
        }
        return compList;
    }

    public static void main(String[] args){
        List<String> competitors = new ArrayList<>(Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"));
        List<String> reviews = new ArrayList<>(Arrays.asList(
                "I love anacell best services provided by anacell in the town",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than eurocel",
                "betacellular is better than deltacellular"
        ));
        ArrayList<String> output = topNCompetitors(5,2, competitors, 3, reviews);
        for(String str: output) {
            System.out.println(str);
        }
    }

    /*"best services provided by anacell",
    "betacellular has great services",
    "anacell provides much better services than all other"*/
    class compNode{
        String name;
        String freq;
    }
}
