package csdn.stringProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OD204 {

//    181 70
//    182 70
//    183 70
//    184 70
//    185 70
//    186 70
//    180 71
//    180 72
//    180 73
//    180 74
//    180 75



    //

    static class People{
        int height;
        int weight;

        public People(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<People> peopleList = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if ("".equals(line)){
                break;
            }else{
                String[] split = line.split(" ");
                int height = Integer.parseInt(split[0]);
                int weight = Integer.parseInt(split[1]);
                peopleList.add(new People(height,weight));
            }
        }

        peopleList.sort((a,b) ->
            a.height == b.height ? b.weight - a.weight : b.height - a.height
        );

        for (int i = 0; i < 10; i++) {
            People people = peopleList.get(i);
            System.out.println(people.height + " "+ people.weight);
        }

    }
}
