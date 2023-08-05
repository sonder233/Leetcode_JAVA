package csdn.stringProblem;

import java.util.*;

public class P1_32 {
    public static class User{
        public int id;
        public int times;
        public int firstDay;

        public void addOneDay(){
            this.times++;
        }

        public User(int id, int times, int firstDay) {
            this.id = id;
            this.times = times;
            this.firstDay = firstDay;
        }

        public User(int id, int times) {
            this.id = id;
            this.times = times;
        }

    }
    public static void main(String[] args) {
        int N = 11;
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        for (int i = 0; i < 30; i++) {
            int[] day = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int employer : day) {
                map.put(employer,map.getOrDefault(employer,0)+1);
            }
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((a,b) -> {
            if (a.getValue() != b.getValue()){
                return b.getValue() - a.getValue();
            }else{
                return 0;
            }
        });
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = 0; i < Math.min(entries.size(),5); i++) {
            stringJoiner.add(entries.get(i).getKey()+"");
        }
        System.out.println(stringJoiner);
    }
}
