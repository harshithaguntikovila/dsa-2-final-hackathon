import java.util.*;

public class PetCare {

    // Pet class
    static class Pet {
        int id;
        String name;
        String owner;
        int age;

        Pet(int id, String name, String owner, int age) {
            this.id = id;
            this.name = name;
            this.owner = owner;
            this.age = age;
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store pets
        ArrayList<Pet> petList = new ArrayList<>();

        // Medical records
        HashMap<Integer, ArrayList<String>> records = new HashMap<>();

        // Appointments
        ArrayList<String> appointments = new ArrayList<>();

        // Vaccination schedules
        HashMap<Integer, ArrayList<String>> vaccinations = new HashMap<>();

        int choice;

        do {
            System.out.println("\n--- PET CARE SYSTEM ---");
            System.out.println("1. Add Pet");
            System.out.println("2. View Pets");
            System.out.println("3. Search Pet");
            System.out.println("4. Add Medical Record");
            System.out.println("5. View Medical History");
            System.out.println("6. Add Appointment");
            System.out.println("7. View Appointments");
            System.out.println("8. Add Vaccination Schedule");
            System.out.println("9. View Vaccination Schedule");
            System.out.println("10. Vaccination Reminders");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Add Pet
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Owner: ");
                    String owner = sc.next();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    petList.add(new Pet(id, name, owner, age));
                    System.out.println("Pet added successfully!");
                    break;

                // View Pets
                case 2:
                    System.out.println("\nPet List:");
                    for (Pet p : petList) {
                        System.out.println(p.id + " | " + p.name + " | " + p.owner + " | Age: " + p.age);
                    }
                    break;

                // Search Pet
                case 3:
                    System.out.print("Enter Pet ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Pet p : petList) {
                        if (p.id == searchId) {
                            System.out.println("Found: " + p.name + " (Owner: " + p.owner + ")");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Pet not found!");
                    }
                    break;

                // Add Medical Record
                case 4:
                    System.out.print("Enter Pet ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter treatment: ");
                    String treatment = sc.nextLine();

                    if (!records.containsKey(rid)) {
                        records.put(rid, new ArrayList<String>());
                    }

                    records.get(rid).add(treatment);
                    System.out.println("Medical record added!");
                    break;

                // View Medical History
                case 5:
                    System.out.print("Enter Pet ID: ");
                    int vid = sc.nextInt();

                    if (records.containsKey(vid)) {
                        System.out.println("Medical History:");
                        for (String t : records.get(vid)) {
                            System.out.println("- " + t);
                        }
                    } else {
                        System.out.println("No records found!");
                    }
                    break;

                // Add Appointment
                case 6:
                    sc.nextLine();

                    System.out.print("Enter appointment details: ");
                    String appt = sc.nextLine();

                    appointments.add(appt);
                    System.out.println("Appointment added!");
                    break;

                // View Appointments
                case 7:
                    System.out.println("Appointments:");
                    for (String a : appointments) {
                        System.out.println(a);
                    }
                    break;

                // Add Vaccination Schedule
                case 8:
                    System.out.print("Enter Pet ID: ");
                    int vacId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter vaccination details: ");
                    String vaccine = sc.nextLine();

                    if (!vaccinations.containsKey(vacId)) {
                        vaccinations.put(vacId, new ArrayList<String>());
                    }

                    vaccinations.get(vacId).add(vaccine);

                    System.out.println("Vaccination schedule added!");
                    break;

                // View Vaccination Schedule
                case 9:
                    System.out.print("Enter Pet ID: ");
                    int viewVac = sc.nextInt();

                    if (vaccinations.containsKey(viewVac)) {
                        System.out.println("Vaccination Schedule:");
                        for (String v : vaccinations.get(viewVac)) {
                            System.out.println("- " + v);
                        }
                    } else {
                        System.out.println("No vaccination records found!");
                    }
                    break;

                // Vaccination Reminders
                case 10:
                    System.out.println("Vaccination Reminders:");

                    for (Integer petId : vaccinations.keySet()) {
                        System.out.println("Pet ID: " + petId);

                        for (String v : vaccinations.get(petId)) {
                            System.out.println("Reminder: " + v);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}