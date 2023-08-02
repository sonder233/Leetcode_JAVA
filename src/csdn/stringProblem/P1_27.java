package csdn.stringProblem;

import java.util.*;

public class P1_27 {
    static class Task{
        public int priority;
        public int oldIndex;
        public int newIndex;

        public Task(int priority, int oldIndex) {
            this.priority = priority;
            this.oldIndex = oldIndex;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getOldIndex() {
            return oldIndex;
        }

        public void setOldIndex(int oldIndex) {
            this.oldIndex = oldIndex;
        }

        public int getNewIndex() {
            return newIndex;
        }

        public void setNewIndex(int newIndex) {
            this.newIndex = newIndex;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", oldIndex=" + oldIndex +
                    ", newIndex=" + newIndex +
                    '}';
        }
    }

    public static void main(String[] args) {
        String line = "9,3,5";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();

        String[] split = line.split(",");
        int[] priorities = Arrays.stream(split).mapToInt(Integer::parseInt)
                                 .toArray();

        LinkedList<Task> taskList = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Task task = new Task(priorities[i],i);
            taskList.add(task);
        }
        Arrays.sort(priorities);
        int indexOfMaxPri = priorities.length-1;
        List<Task> sortList = new ArrayList<>();
        int curr = 0;
        while (taskList.size() > 0){
            Task firstTask = taskList.removeFirst();
            if (firstTask.priority == priorities[indexOfMaxPri]){
                indexOfMaxPri--;
                firstTask.setNewIndex(curr++);
                sortList.add(firstTask);
            }else{
                taskList.addLast(firstTask);
            }
        }
        sortList.sort(Comparator.comparingInt(a -> a.oldIndex));

        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < sortList.size(); i++) {
            Task task = sortList.get(i);
            sj.add(task.newIndex+"");
//            System.out.println(task);
        }
        System.out.println(sj);

        


    }
}
