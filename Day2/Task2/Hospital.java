/* 2(L3).Create a simple hospital management system using inheritance in Java */


import java.util.*;
class Person 
 {
    String name;
    int age;

    public Person(String name,int age)
    {
        this.name = name;
        this.age = age;
     }

    public void display()
    {
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
}

class Doctor extends Person
 {
    String specialization;
    String appointmentTime;
    ArrayList<Patient> patients;
    ArrayList<String> prescriptions;

   public Doctor(String name,int age,String specialization,String appointmentTime) 
    {
        super(name, age);
        this.specialization = specialization;
        this.appointmentTime = appointmentTime;
        this.patients = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

  public void displayDoctor() 
    {
        System.out.println("----Doctor Details---- ");
        super.display();
        System.out.println("Specialization: "+specialization);
        System.out.println("Appointment Time: "+appointmentTime);
        System.out.println();
        if(!patients.isEmpty()) 
 	  {
            System.out.println("Prescriptions:");
            for(int i=0;i<patients.size();i++)
	    {
                System.out.println("Dr "+name+" prescribes "+prescriptions.get(i)+" to "+patients.get(i).name);
            }
            System.out.println();
          } 
	else
	 {
            System.out.println("No prescriptions given yet.");
         }
    }

    public void prescribe(Patient patient,String medicine)
    {
        patients.add(patient);
        prescriptions.add(medicine);
        patient.receivePrescription(medicine);
    }

 public void viewPrescriptions() 
	{
         if(!patients.isEmpty()) 
	   {
             System.out.println("Prescriptions:");
             for(int i=0;i<patients.size();i++)
	     {
                System.out.println("Dr "+name+" prescribed "+prescriptions.get(i)+" to "+patients.get(i).name);
             }
         } 
	else
	 {
            System.out.println("No prescriptions given");
         }
    }
}

class Patient extends Person 
  {
    String problem;
    String prescription;

    public Patient(String name,int age,String problem) 
     {
        super(name,age);
        this.problem = problem;
     }

   public void displayPatient() 
    {
        System.out.println("-----Patient Details------ ");
        super.display();
        System.out.println("Problem: "+problem);
        if(prescription != null) 
	{
            System.out.println("Prescription: "+prescription);
        }
	else
	 {
            System.out.println("No prescription received yet.");
         }
        System.out.println();
    }

    public void receivePrescription(String medicine)
    {
        prescription = medicine;
    }
}

public class Hospital
 {
    public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);

    Doctor doctor = new Doctor("Abhishek",35,"Neurologist","11 AM");
    Patient patient1 = new Patient("Abdul",23,"Headache");
    Patient patient2 = new Patient("Sara",30,"Back Pain");

    doctor.prescribe(patient1,"Aspirin");
    doctor.prescribe(patient2,"Painkillers");

    doctor.displayDoctor();
    patient1.displayPatient();
    patient2.displayPatient();

    System.out.println("Viewing prescriptions for Doctor "+doctor.name);
    doctor.viewPrescriptions();
    }
}
