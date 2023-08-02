package csdn.stringProblem;

import java.util.*;

public class P1_29 {
    public static void main(String[] args) {
        int k = 5;
        String line = "1 2 2 4 2 1 1";

        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        scanner.nextLine();
        line = scanner.nextLine();

        int[] nums = Arrays.stream(line.split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num,numMap.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = numMap.entrySet();
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(numMap.entrySet());
        entryList.sort((a,b) -> b.getValue() - a.getValue() );
//        entries.forEach(e -> System.out.println(e));
        int maxValue = entryList.get(0).getValue();
        List<Integer> maxNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (entry.getValue() == maxValue){
                maxNumbers.add(entry.getKey());
            }
        }
        int minSize = nums.length;
        for (Integer number : maxNumbers) {
//            System.out.println(number);
            int start = nums.length-1;
            int end = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == number){
                    start = Math.min(start,i);
                    end = Math.max(end,i);
                }
            }
            minSize = Math.min(minSize,end -start+1);
        }
        System.out.println(minSize);



//        numMap.forEach((i,j )-> System.out.println(i));
    }
}
