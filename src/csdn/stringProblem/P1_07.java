package csdn.stringProblem;

import java.util.*;

public class P1_07 {

    class MyData{
        int data;
        int priority;

        public MyData(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }

    }

    public static void main(String[] args) {
        //(10,1),(20,1),(30,2),(40,3)

//        String line = "(10,1),(10,1),(30,2),(40,3)";
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.substring(1, line.length() - 1).split("\\),\\(");
        int[][] task = Arrays.stream(split)
                .map(s -> Arrays.stream(s.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        for (int i = 0; i < task.length; i++) {
            for (int j = 0; j < task[i].length; j++) {
                System.out.print(task[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        Map<Integer, LinkedHashSet<Integer> > treeMap = new TreeMap<>((a,b)-> b - a);
        for (int i = 0; i < task.length; i++) {
            int key = task[i][1];
            int value = task[i][0];
            if (treeMap.containsKey(key)){
                treeMap.get(key).add(value);
            }else{
                LinkedHashSet<Integer> temp = new LinkedHashSet<>();
                temp.add(task[i][0]);
                treeMap.put(key,temp);
            }
        }

        StringJoiner sj = new StringJoiner(",");

        treeMap.forEach( (key, value) -> {
            value.forEach(i ->{
                sj.add(i+"");
            });
        });
        System.out.println(sj);

//        for (String s : split) {
//            System.out.println(s);
//        }



    }
}
