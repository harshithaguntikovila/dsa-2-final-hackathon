public class Treatment {
    int treatmentId;
    int petId;
    String disease;
    int cost;
    int day;

    public Treatment(int treatmentId, int petId, String disease, int cost, int day) {
        this.treatmentId = treatmentId;
        this.petId = petId;
        this.disease = disease;
        this.cost = cost;
        this.day = day;
    }
}