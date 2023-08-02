package csdn.stringProblem;

import java.util.Scanner;

public class P1_30 {
    public static void main(String[] args) {
        String line_1 = "1.02-001";
        String line_2 = "1.5.1-a";

//        Scanner scanner = new Scanner(System.in);
//        line_1 = scanner.nextLine();
//        line_2 = scanner.nextLine();

        String[] split_1 = line_1.split("[^0-9a-zA-z]");
        String[] split_2 = line_2.split("[^0-9a-zA-z]");
//        Version version_1 = new Version(Integer.parseInt(split_1[0]),Integer.parseInt(split_1[1]));
//        Version version_2 = new Version(Integer.parseInt(split_2[0]),Integer.parseInt(split_2[1]));
        int major_1 = Integer.parseInt(split_1[0]);
        int major_2 = Integer.parseInt(split_2[0]);
        if (major_1 > major_2){
            System.out.println(line_1);
            return;
        }else if (major_1 < major_2){
            System.out.println(line_2);
            return;
        }

        int minor_1 = Integer.parseInt(split_1[1]);
        int minor_2 = Integer.parseInt(split_2[1]);

        if (minor_1 > minor_2){
            System.out.println(line_1);
            return;
        }else if (minor_1 < minor_2){
            System.out.println(line_2);
            return;
        }else{
            if (split_1.length == 2 && split_2.length == 2){
                System.out.println(line_1);
                return;
            }
        }

        if (split_1.length < split_2.length){
            System.out.println(line_2);
            return;
        }else if (split_1.length > split_2.length){
            System.out.println(line_1);
            return;
        }else {
            int more_1 = Integer.parseInt(split_1[2]);
            int more_2 = Integer.parseInt(split_2[2]);
            if (more_1 > more_2){
                System.out.println(line_1);
                return;
            }else if (more_1 < more_2){
                System.out.println(line_2);
                return;
            }else{
                if (split_1.length < split_2.length){
                    System.out.println(line_2);
                    return;
                }else if (split_1.length > split_2.length){
                    System.out.println(line_1);
                    return;
                }else{
                    if (split_1.length == 3 && split_2.length == 3){
                        System.out.println(line_1);
                        return;
                    }else{
                        String tail_1 = split_1[3];
                        String tail_2 = split_1[3];
                        if (tail_1.compareTo(tail_2) > 0){
                            System.out.println(line_1);
                            return;
                        }else{
                            System.out.println(line_2);
                            return;
                        }
                    }
                }

            }
        }





    }

}

