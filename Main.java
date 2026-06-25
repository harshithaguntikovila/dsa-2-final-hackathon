public class Main {

    public static void main(String[] args) {

        ClinicAnalytics ca = new ClinicAnalytics(30);

        ca.addTreatment(new Treatment(1, 101, "Fever", 500, 1));
        ca.addTreatment(new Treatment(2, 102, "Cold", 300, 2));
        ca.addTreatment(new Treatment(3, 103, "Fever", 500, 3));
        ca.addTreatment(new Treatment(4, 104, "Infection", 800, 5));
        ca.addTreatment(new Treatment(5, 105, "Cold", 300, 6));

        System.out.println("Total Treatments till Day 5: "
                + ca.totalTreatmentsTillDay(5));

        System.out.println("Total Revenue: "
                + ca.totalRevenue());

        ca.mostCommonDisease();
    }
}