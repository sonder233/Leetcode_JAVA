    package csdn.stringProblem;
    
    
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;
    
    public class P1_20 {
        public static void main(String[] args) {
            String s = "eg";
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();
    
            char[] minSArr = s.toCharArray();
            Arrays.sort(minSArr);
            String minS = new String(minSArr);
            if (minS.equals(s)){
                System.out.println(s);
                return;
            }
    
            char[] sArr = s.toCharArray();
    
            for (int i = 0; i < s.length(); i++) {
                if (sArr[i] != minSArr[i]){
                    char c = sArr[i];
                    sArr[i] = minSArr[i];
                    int lastIndex = s.lastIndexOf(minSArr[i]);
                    sArr[lastIndex] = c;
                    break;
                }
            }
            System.out.println(new String(sArr));
    
    
        }
    }
