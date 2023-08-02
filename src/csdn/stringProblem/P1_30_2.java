package csdn.stringProblem;

import java.util.Arrays;
import java.util.Scanner;

public class P1_30_2 {
    public static class Version{
        int major ;
        int minor ;
        int more = -1;
        String tail = "";


        @Override
        public String toString() {
            return "Version{" +
                    "major=" + major +
                    ", minor=" + minor +
                    ", more=" + more +
                    ", tail='" + tail + '\'' +
                    '}';
        }

        public int getMore() {
            return more;
        }

        public void setMore(int more) {
            this.more = more;
        }

        public String getTail() {
            return tail;
        }

        public void setTail(String tail) {
            this.tail = tail;
        }

        public Version(int major, int minor) {
            this.major = major;
            this.minor = minor;
        }
    }
    public static void main(String[] args) {
        String line_1 = "1.5";
        String line_2 = "1.5.0";
        Scanner scanner = new Scanner(System.in);
        line_1 = scanner.nextLine();
        line_2 = scanner.nextLine();

        Version version_1 = getVersion(line_1);
        Version version_2 = getVersion(line_2);
//        System.out.println(version_1);
//        System.out.println(version_2);


        if (version_1.major > version_2.major){
            System.out.println(line_1);
        }else if (version_1.major < version_2.major){
            System.out.println(line_2);
        }else{
            //第一位相同
            if (version_1.minor > version_2.minor){
                System.out.println(line_1);
            }else if (version_1.minor < version_2.minor){
                System.out.println(line_2);
            }else {
                if (version_1.more > version_2.more){
                    System.out.println(line_1);
                }else if (version_1.more < version_2.more){
                    System.out.println(line_2);
                }else{
                    if ("".equals(version_1.tail) && "".equals(version_2.tail)){
                        System.out.println(line_1);
                    } else if ("".equals(version_1.tail) ) {
                        System.out.println(line_2);
                    }else if("".equals(version_2.tail)){
                        System.out.println(line_1);
                    }else{
                        if (version_1.tail.compareTo(version_2.tail) > 0){
                            System.out.println(line_1);
                        }else{
                            System.out.println(line_2);

                        }
                    }
                }
            }
        }
        //到这了说明前面都相同
//        if ()

    }

    public static Version getVersion(String line){
        //"1.5.1-a";

        Arrays.stream(line.split("-")[0].split(".")).forEach(s -> System.out.println(s));
        int[] headSplit = Arrays.stream(line.split("-")[0].split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] splitTail = line.split("-");
        Version version = new Version(headSplit[0],headSplit[1]);
        if (headSplit.length > 2){
            version.setMore(headSplit[2]);
        }
        if (splitTail.length > 1){
            version.setTail(splitTail[1]);
        }

        return version;

    }
}
