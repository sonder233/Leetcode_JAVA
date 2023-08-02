package csdn.stringProblem;

import java.util.*;

public class P1_31 {
    public static class Record{
        String id ;
        int time ;
        int distance;
        String actualDeviceNumber;
        String registeredDeviceNumber;

        public Record(String id, int time, int distance, String actualDeviceNumber, String registeredDeviceNumber) {
            this.id = id;
            this.time = time;
            this.distance = distance;
            this.actualDeviceNumber = actualDeviceNumber;
            this.registeredDeviceNumber = registeredDeviceNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getActualDeviceNumber() {
            return actualDeviceNumber;
        }

        public void setActualDeviceNumber(String actualDeviceNumber) {
            this.actualDeviceNumber = actualDeviceNumber;
        }

        public String getRegisteredDeviceNumber() {
            return registeredDeviceNumber;
        }

        public void setRegisteredDeviceNumber(String registeredDeviceNumber) {
            this.registeredDeviceNumber = registeredDeviceNumber;
        }

        @Override
        public String toString() {
            return id + "," + time +
                    "," + distance +
                    "," + actualDeviceNumber +
                    "," + registeredDeviceNumber;
        }
    }
    public static void main(String[] args) {
        int n = 2;


        Scanner scanner = new Scanner(System.in);
//        n = Integer.parseInt(scanner.nextLine());
        String[] clockRecords = new String[n];
        clockRecords[0] = "100000,10,1,ABCD,ABCD";
        clockRecords[1] = "100000,50,10,ABCD,ABCD";
//        for (int i = 0; i < n; i++) {
//            clockRecords[i] = scanner.nextLine();
//        }
        List<Record> recordList = new ArrayList<>();
        int[] flag = new int[n];
        Arrays.fill(flag,0);

        for (String record : clockRecords) {
            Record r = getRecordByString(record);
            recordList.add(r);
        }
        //筛选设备号出错的
        for (int i = 0; i < recordList.size(); i++) {
            Record record = recordList.get(i);
            if (!record.actualDeviceNumber.equals(record.registeredDeviceNumber)){
                flag[i] = 1;
            }
        }
        if (recordList.size() == 1){
            System.out.println(clockRecords[0]);
            return;
        }
        //筛选距离和时间出错的
            //暴力双重循环
        for (int i = 0; i < recordList.size(); i++) {
            for (int j = i+1; j < recordList.size(); j++) {
                Record record_1 = recordList.get(i);
                Record record_2 = recordList.get(j);
                if ( record_1.id.equals(record_2.id)
                        && Math.abs(record_1.time - record_2.time) < 60
                        && Math.abs(record_1.distance - record_2.distance) > 5){
                    flag[i] = flag[j] = 1;
                }
            }
        }

        StringJoiner sj = new StringJoiner(";");
        for (int i =0;i < flag.length ;i++) {
            int symbol = flag[i];
            if (symbol == 1){
                sj.add(recordList.get(i).toString());
            }
        }
        if (sj.length() == 0){
            System.out.println("null");
        }else{
            System.out.println(sj);
        }

    }
    public static Record getRecordByString(String recordStr){
        String[] split = recordStr.split(",");
        return new Record(split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2])
                ,split[3],split[4]);
    }
}
