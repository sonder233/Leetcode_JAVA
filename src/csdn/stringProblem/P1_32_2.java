package csdn.stringProblem;

import java.util.*;

public class P1_32_2 {
    public static class User{
        int id;
        int times;
        int firstDay;

        public User(int id, int times, int firstDay) {
            this.id = id;
            this.times = times;
            this.firstDay = firstDay;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", times=" + times +
                    ", firstDay=" + firstDay +
                    '}';
        }
    }
    public static void main(String[] args) {

        Map<Integer,User> test = new HashMap<>();
        test.put(1,new User(1,1,1));
        test.put(2,new User(2,2,1));
        test.get(1).times++;
        test.entrySet().forEach(s -> System.out.println(s));
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<Integer,User> map = new HashMap<>();
        for (int i = 0; i < 30; i++) {//i是第几天
            int[] currDay = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int id : currDay) {
                if (map.containsKey(id)){
                    map.get(id).times++;
                }else{
                    map.put(id,new User(id,1,i));
                }
            }
        }
        ArrayList<Map.Entry<Integer, User>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a,b) -> {
            if (a.getValue().times != b.getValue().times){
                return b.getValue().times - a.getValue().times;
            }else{
                if (b.getValue().firstDay != a.getValue().firstDay){
                    return a.getValue().firstDay - b.getValue().firstDay;
                }else{
                    return a.getKey() - b.getKey();
                }
            }
        });
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = 0; i < Math.min(5,entries.size()); i++) {
            stringJoiner.add(entries.get(i).getKey()+"");
        }
        System.out.println(stringJoiner);
    }
}
