import java.util.Scanner;

// =============================
// ABSTRACT PRODUCTS
// =============================

interface Doctor {
    void treatPatient();
}

interface Nurse {
    void assist();
}

interface Equipment {
    void operate();
}


// =============================
// PUBLIC HOSPITAL PRODUCTS
// =============================

class PublicDoctor implements Doctor {

    @Override
    public void treatPatient() {
        System.out.println("[Public Doctor] Treating patient using standard healthcare procedures.");
    }
}

class PublicNurse implements Nurse {

    @Override
    public void assist() {
        System.out.println("[Public Nurse] Assisting the doctor and monitoring the patient.");
    }
}

class PublicEquipment implements Equipment {

    @Override
    public void operate() {
        System.out.println("[Public Equipment] Operating basic medical equipment.");
    }
}


// =============================
// PRIVATE HOSPITAL PRODUCTS
// =============================

class PrivateDoctor implements Doctor {

    @Override
    public void treatPatient() {
        System.out.println("[Private Doctor] Treating patient using premium healthcare services.");
    }
}

class PrivateNurse implements Nurse {

    @Override
    public void assist() {
        System.out.println("[Private Nurse] Providing personalized assistance to the patient.");
    }
}

class PrivateEquipment implements Equipment {

    @Override
    public void operate() {
        System.out.println("[Private Equipment] Operating advanced medical technology.");
    }
}


// =============================
// ABSTRACT FACTORY
// =============================

interface HospitalFactory {

    Doctor createDoctor();

    Nurse createNurse();

    Equipment createEquipment();
}


// =============================
// CONCRETE FACTORIES
// =============================

class PublicHospitalFactory implements HospitalFactory {

    @Override
    public Doctor createDoctor() {
        return new PublicDoctor();
    }

    @Override
    public Nurse createNurse() {
        return new PublicNurse();
    }

    @Override
    public Equipment createEquipment() {
        return new PublicEquipment();
    }
}


class PrivateHospitalFactory implements HospitalFactory {

    @Override
    public Doctor createDoctor() {
        return new PrivateDoctor();
    }

    @Override
    public Nurse createNurse() {
        return new PrivateNurse();
    }

    @Override
    public Equipment createEquipment() {
        return new PrivateEquipment();
    }
}


// =============================
// FACTORY PRODUCER
// =============================

class HospitalFactoryProducer {

    public static HospitalFactory getFactory(int choice) {

        if (choice == 1) {
            return new PublicHospitalFactory();
        }

        if (choice == 2) {
            return new PrivateHospitalFactory();
        }

        return null;
    }
}


// =============================
// MAIN CLASS
// =============================

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Hospital Management System ===");
        System.out.println("Select hospital type:");
        System.out.println("1. Public Hospital");
        System.out.println("2. Private Hospital");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        HospitalFactory factory = HospitalFactoryProducer.getFactory(choice);

        if (factory == null) {
            System.out.println("Invalid option. Please restart and select a valid hospital type.");
            scanner.close();
            return;
        }

        System.out.println("\nInitializing hospital system...\n");

        Doctor doctor = factory.createDoctor();
        Nurse nurse = factory.createNurse();
        Equipment equipment = factory.createEquipment();

        doctor.treatPatient();
        nurse.assist();
        equipment.operate();

        System.out.println("\nHospital system execution completed successfully.");

        scanner.close();
    }
}