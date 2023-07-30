package csdn.stringProblem;

import java.util.*;

public class P1_13 {
    public static void main(String[] args) {
        int index = 4;
        int num = 6;
        String[] words = {"word","dd","da","dc","dword","d"};

        Scanner scanner = new Scanner(System.in);
        index = scanner.nextInt();
        num = scanner.nextInt();
        words = new String[num];
        for (int i = 0; i < num; i++) {
            words[i] = scanner.next();
        }
        
        Map<Character,List<String>> dic = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        String currWord = words[index];
        stringBuilder.append(currWord);

        for (int i = 0; i < num; i++) {
            if (i == index) continue;
            String word = words[i];
            char c = word.charAt(0);
            if (dic.containsKey(c)){
                dic.get(c).add(word);
                dic.get(c).sort((a,b) -> {
                    if (a.length() != b.length()){
                        return b.length()-a.length();
                    }else{
                        return a.compareTo(b);
                    }
                });
            }else{
                List<String> tmp = new ArrayList<>();
                tmp.add(word);
                dic.put(c,tmp);
            }
        }

        while (dic.containsKey(currWord.charAt(currWord.length()-1))){
            char tail = currWord.charAt(currWord.length()-1);
            String nextWord = dic.get(tail).get(0);
            currWord = nextWord;
            dic.get(tail).remove(0);
            if (dic.get(tail).size()==0){
                dic.remove(tail);
            }
            stringBuilder.append(nextWord);
        }
        System.out.println(stringBuilder);







        Set<Character> characters = dic.keySet();


    }

//    void dfs(List<String> words,int[] visited,String currWord,List<String> path){
//
//    }

}
