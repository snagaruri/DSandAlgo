import java.util.*;

public class PlaySongs {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>(Arrays.asList(20,70,90,30,60,110));
        List<Integer> result = foo(110, (ArrayList<Integer>) arrList);
        System.out.println(result);
    }

    public static List<Integer> foo(int flightDuration, ArrayList<Integer> movieDuration) {
        if (movieDuration == null || movieDuration.isEmpty()) {
            return new ArrayList<Integer>();
        }

        int remainingDuration = flightDuration - 30;

        HashMap<Integer, Integer> songIndexes = new HashMap<>();
        HashMap<Integer, Integer> dupSongIndexes = new HashMap<>();

        for (int i = 0; i < movieDuration.size(); i++) {
            if (songIndexes.containsKey(movieDuration.get(i))) {
                if (!dupSongIndexes.containsKey(movieDuration.get(i))) {
                    dupSongIndexes.put(movieDuration.get(i), i);
                }
            } else {
                songIndexes.put(movieDuration.get(i), i);
            }
        }

        Collections.sort(movieDuration, Collections.reverseOrder());

        int maxDuration1 = 0;
        int maxDuration2 = 0;
        int maxDuration1Index = 0;
        int maxDuration2Index = 0;
        int previousBreak = movieDuration.size();
        for (int i = 0; i < movieDuration.size(); i++) {
            for (int j = i; j < previousBreak; j++) {
                int totalDuration = movieDuration.get(i) + movieDuration.get(j);
                if (totalDuration <= remainingDuration && totalDuration > maxDuration1 + maxDuration2) {
                    maxDuration1 = movieDuration.get(i);
                    maxDuration2 = movieDuration.get(j);
                    maxDuration1Index = songIndexes.get(movieDuration.get(i));
                    maxDuration2Index = songIndexes.get(movieDuration.get(j));
                    previousBreak = j + 1;
                    break;
                }
            }
        }

        ArrayList<Integer> output = new ArrayList<>();
        if (maxDuration1 != 0) {
            output.add(maxDuration1Index);
            output.add(maxDuration2Index);

            Collections.sort(output);
        } else {
            output.add(-1);
            output.add(-1);
        }

        return output;
    }
}