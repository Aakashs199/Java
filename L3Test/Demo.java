import java.util.ArrayList;
import java.util.Scanner;

class Patient 
{
    String id;
    String name;
    int[] inTime; 
    int doctorTime; 
    int[] outTime; 
    int waitingTime;
    int total;

    Patient(String id, String name, int[] inTime) 
  {
        this.id = id;
        this.name = name;
        this.inTime = inTime;
        this.doctorTime = generateDoctorTime(); 
        this.total = 0;
    }

    private int generateDoctorTime() 
    {
        return (int)(Math.random()*19)+2;
    }
}

class MedicalProfessional
  {
    void logComplaints(Patient patient)
    {
        patient.total+= 10;
    }
}

class Pharmacy 
   {
    void giveMedicines(Patient patient)
    {
        patient.total += 5;
    }
   }

class HospitalOPD
   {
    ArrayList<Patient> patients = new ArrayList<>();
    int[] lastOutTime = {0,0};
    int [] lastDoctorOutTime={0,0};
    int [] lastQueueOutTime={0,0};
    void addPatient(String id, String name, int[] inTime) 
     {
        Patient patient = new Patient(id, name, inTime);
        patients.add(patient);
    }

    void processPatients() 
     {
        MedicalProfessional medicalProfessional = new MedicalProfessional();
        Pharmacy pharmacy = new Pharmacy();

        for (Patient patient : patients)
        {
            medicalProfessional.logComplaints(patient);
            patient.total=calculateWaitingTime(patient.inTime, lastDoctorOutTime);
            patient.total += patient.doctorTime;
            pharmacy.giveMedicines(patient);
            patient.outTime = calculateOutTime(patient.inTime, patient.total);;
            lastOutTime = patient.outTime;
        }
    }

    int[] calculateOutTime(int[] inTime, int waitingTime)
     {
        int totalMinutes = inTime[0]*60+inTime[1]+waitingTime;
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return new int[]{hours, minutes};
     }

    int calculateWaitingTime(int[] inTime, int[] lastOutTime) 
    {
        int waitingTime = (inTime[0] * 60 + inTime[1]) - (lastOutTime[0] * 60 + lastOutTime[1]);
        return waitingTime > 0 ? 0 : waitingTime;
    }

    void displayPatients()
    {
        System.out.println("Patient Id\tDoctor Time\tOut Time\tTotal Waiting Time");
        for (Patient patient : patients) 
        {
            System.out.printf("%s\t\t%d min\t\t%02d:%02d\t%d min\n",
                    patient.id, patient.doctorTime, patient.outTime[0], patient.outTime[1], patient.waitingTime);
        }
    }
}

public class HospitalManagement 
{
    public static void main(String[] args)
    {
        HospitalOPD hospital = new HospitalOPD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of patients:");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter Patient Id:");
            String id = scanner.nextLine();
            System.out.println("Enter Patient Name:");
            String name = scanner.nextLine();
            System.out.println("Enter In Time (e.g., 15:00):");
            String[] inTimeStr = scanner.nextLine().split(":");
            int[] inTime = {Integer.parseInt(inTimeStr[0]), Integer.parseInt(inTimeStr[1])};
            hospital.addPatient(id, name, inTime);
        }
        hospital.processPatients();
        hospital.displayPatients();
    }
}
