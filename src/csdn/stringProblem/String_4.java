package csdn.stringProblem;

import java.util.*;

public class String_4 {
    static class Student{
        String sid;
        String cid;
        int score_1 = -1;
        int score_2 = -1;

        public Student(String sid, String cid, int score_1, int score_2) {
            this.sid = sid;
            this.cid = cid;
            this.score_1 = score_1;
            this.score_2 = score_2;
        }

        int getSum(){
            return score_1 + score_2;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lesson_1 = scanner.nextLine().split(";");
        String[] lesson_2 = scanner.nextLine().split(";");

        HashMap<String,Student> students_1 = new HashMap<>();
        HashMap<String,Student> students_2 = new HashMap<>();
        for (int i = 0; i < lesson_1.length; i++) {
            String[] tmp = lesson_1[i].split(",");
            String sid = tmp[0];
            int score = Integer.parseInt(tmp[1]);
            String cid = sid.substring(0,5);
            students_1.putIfAbsent(sid,new Student(sid,cid,score,-1));
//            lesson_1_stu.add(new Student(sid,cid,score,-1));
        }
        for (int i = 0; i < lesson_2.length; i++) {
            String[] tmp = lesson_2[i].split(",");
            String sid = tmp[0];
            if (students_1.containsKey(sid)){
                Student student = students_1.get(sid);
                int score = Integer.parseInt(tmp[1]);//2
                String cid = sid.substring(0,5);
                students_2.putIfAbsent(sid,new Student(sid,cid,student.score_1,score));
            }
        }
        if (students_2.size() == 0){
            System.out.println("NULL");
            return;
        }
        //按照班分组
        HashMap<String,ArrayList<Student>> ans = new HashMap<>();
        students_2.forEach((sid,student) ->{
            ans.putIfAbsent(student.cid,new ArrayList<>());
            ans.get(student.cid).add(student);
        });
        ans.keySet().stream()
                .sorted(String::compareTo)
                        .forEach(cid -> {
                            System.out.println(cid);
                            ArrayList<Student> list = ans.get(cid);
                            list.sort((a,b) -> {
                                if (a.getSum() != b.getSum()){
                                    return b.getSum() - a.getSum();
                                }else{
                                    return a.sid.compareTo(b.sid);
                                }
                            });
                            StringJoiner sj = new StringJoiner(";");
                            for(Student student : list){
                                sj.add(student.sid);
                            }
                            System.out.println(sj.toString());
                        });
        System.out.println(students_2.size());
        /*
01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
         */

    }
}
