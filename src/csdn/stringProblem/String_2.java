package csdn.stringProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class String_2 {
    static class Order{
        String command;
        String content;

        public Order(String command, String content) {
            this.command = command;
            this.content = content;
        }
    }
    public static void main(String[] args) {
        /*
1
ello
INSERT h

2
hllo
FORWARD 1
INSERT e

         */
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(text);
        List<Order> orderList = new ArrayList<>();
        int pointer = 0; //指在0之前
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            orderList.add(new Order(s[0],s[1]));
        }
        for (int i = 0; i < n; i++) {
            Order order = orderList.get(i);
            switch (order.command){
                case "FORWARD" :
                    pointer += Integer.parseInt(order.content);
                    if (pointer > stringBuilder.length()){
                        pointer = stringBuilder.length();
                    }
                    break;
                case "BACKWARD" :
                    pointer -= Integer.parseInt(order.content);
                    if (pointer < 0){
                        pointer = 0;
                    }
                    break;
                case "SEARCH-FORWARD" :
                    int step = stringBuilder.indexOf(order.content,pointer);
                    if (step != -1){
                        pointer = step;
                    }
                    break;
                case "SEARCH-BACKWARD" :
                    int step_1 = stringBuilder.lastIndexOf(order.content,pointer);
                    if (step_1 != -1){
                        pointer = step_1;
                    }
                    break;
                case "INSERT" :
                    stringBuilder.insert(pointer,order.content);
                    pointer += order.content.length();
                    break;
                case "REPLACE" :
                    stringBuilder.replace(pointer,pointer+order.content.length(), order.content);
                    break;
                case "DELETE" :
                    stringBuilder.delete(pointer,pointer+Integer.parseInt(order.content));
                    break;
                default:
                    break;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
