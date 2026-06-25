
import java.util.*;

public class ClinicAnalytics {

    List<Treatment> treatments = new ArrayList<>();
    FenwickTree fenwick;

    public ClinicAnalytics(int days) {
        fenwick = new FenwickTree(days);
    }

    public void addTreatment(Treatment t) {
        treatments.add(t);
        fenwick.update(t.day, 1);
    }

    public int totalTreatmentsTillDay(int day) {
        return fenwick.query(day);
    }

    public int totalRevenue() {
        int sum = 0;
        for (Treatment t : treatments) {
            sum += t.cost;
        }
        return sum;
    }

    public void mostCommonDisease() {

        HashMap<String, Integer> map = new HashMap<>();

        for (Treatment t : treatments) {
            map.put(t.disease,
                    map.getOrDefault(t.disease, 0) + 1);
        }

        String maxDisease = "";
        int max = 0;

        for (String d : map.keySet()) {
            if (map.get(d) > max) {
                max = map.get(d);
                maxDisease = d;
            }
        }

        System.out.println("Most Common Disease: " + maxDisease);
        System.out.println("Cases: " + max);
    }
}