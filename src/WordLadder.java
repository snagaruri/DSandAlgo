import java.util.*;

public class WordLadder {
    public static void  main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength("hit", "cog", wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> begSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        begSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int step =1 ;
        while(!begSet.isEmpty()){
            System.out.println("begSet is:" + begSet);
            System.out.println("endSet is:" + endSet);
            if(begSet.size()>endSet.size()){
                //System.out.println("======================");
                //System.out.println("begSet is:" + begSet);
                //System.out.println("endSet is:" + endSet);
                System.out.println("begSet is exchanged");
                Set<String> set = begSet;
                begSet = endSet;
                endSet = set;
                System.out.println("begSet is:" + begSet);
                System.out.println("endSet is:" + endSet);
            }
            System.out.println("======================");
            Set<String> temp = new HashSet<>();
            //System.out.println("begSet is:" + begSet);
            for(String word: begSet){
                char[] chs = word.toCharArray();
                for(int i=0;i<chs.length;i++){
                    char old = chs[i];
                    for(char c='a';c<='z';c++){
                        chs[i]=c;
                        // String target = chs.toString();
                        String target = String.valueOf(chs);
                        if(endSet.contains(target))
                            return step+1;
                        if(!visited.contains(target)&&wordSet.contains(target)){
                            temp.add(target);
                            visited.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
            begSet =temp;
            step++;
        }
        return 0;
    }
}
