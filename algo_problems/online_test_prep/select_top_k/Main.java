import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        Solution sln = new Solution();

        Record r1 = new Record(1);
        Record r2 = new Record(2);
        Record r3 = new Record(3);
        ArrayList<Record> records = new ArrayList<Record>();
        records.add(r2);
        records.add(r3);
        records.add(r1);

        ArrayList<Record> result = sln.topK(records, 2);

        for (Record r : result) {
            System.out.println(r.val);
        }
    }
}
