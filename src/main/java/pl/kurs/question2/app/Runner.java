package pl.kurs.question2.app;

import pl.kurs.question2.model.Doctor;
import pl.kurs.question2.model.Patient;
import pl.kurs.question2.model.Visit;

import javax.print.Doc;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("src/main/java/pl/kurs/question2/data/lekarze.txt");
        File file2 = new File("src/main/java/pl/kurs/question2/data/pacjenci.txt");
        File file3 = new File("src/main/java/pl/kurs/question2/data/wizyty.txt");

        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        List<Visit> visits = new ArrayList<>();

        try {
            Scanner doctorList = new Scanner(file1);
            doctorList.nextLine();

            while (doctorList.hasNextLine()) {
                String line = doctorList.nextLine();
                String[] linedata = line.split("\t");
                int id = Integer.parseInt(linedata[0]);
                String lastName = linedata[1];
                String firstName = linedata[2];
                String specialisation = linedata[3];
                LocalDate birthDate = LocalDate.parse(linedata[4]);
                String nipString = linedata[5].replace("-", "");
                long nip = Long.parseLong(nipString);
                long pesel = Long.parseLong(linedata[6]);

                boolean nipExists = false;
                for (Doctor doctor : doctors) {
                    if (doctor.getNip() == nip) {
                        nipExists = true;
                        break;
                    }
                }
                if (!nipExists) {
                    doctors.add(new Doctor(id, lastName, firstName, specialisation, birthDate, nip, pesel));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Scanner patientList = new Scanner(file2);
            patientList.nextLine();

            while (patientList.hasNextLine()) {
                String line = patientList.nextLine();
                String[] linedata = line.split("\t");
                int id = Integer.parseInt(linedata[0]);
                String lastName = linedata[1];
                String firstName = linedata[2];
                long pesel = Long.parseLong(linedata[3]);
                LocalDate birthDate = LocalDate.parse(linedata[4]);
                patients.add(new Patient(id, lastName, firstName, pesel, birthDate));

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Scanner visitList = new Scanner(file3);
            visitList.nextLine();

            while (visitList.hasNextLine()) {
                String line = visitList.nextLine();
                String[] linedata = line.split("\t");
                int doctorId = Integer.parseInt(linedata[0]);
                int patientId = Integer.parseInt(linedata[1]);
                LocalDate visitDate = LocalDate.parse(linedata[2]);

                boolean doctorExists = false;
                boolean patientExists = false;

                for (Doctor doctor : doctors) {
                    if (doctor.getId() == doctorId) {
                        doctorExists = true;
                        break;
                    }
                }

                for (Patient patient : patients) {
                    if (patient.getId() == patientId) {
                        patientExists = true;
                        break;
                    }
                }

                if (doctorExists && patientExists) {
                    visits.add(new Visit(doctorId, patientId, visitDate));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Patient patient : patients) {
            for (Visit visit : visits) {
                if (patient.getId() == visit.getPatientId()) {
                    patient.addVisit(visit);
                }
            }
        }

        for (Doctor doctor : doctors) {
            for (Visit visit : visits) {
                if (doctor.getId() == visit.getDoctorId()) {
                    doctor.addVisit(visit);
                }
            }
        }

        System.out.println(findMostPopularDoctor(doctors));
        System.out.println(findMostFrequentPatient(patients));
        System.out.println(findMostPopularSpecialization(doctors));
        System.out.println(findYearWithMostVisits(visits));
        System.out.println(findTopOldestDoctors(doctors));
        System.out.println(findTopMostPopularDoctors(doctors));
        System.out.println(findDoctorsWithOnePatient(doctors));
        System.out.println(findPatientsWithMinFiveDoctors(patients));


    }

    public static List<Doctor> findMostPopularDoctor(List<Doctor> doctors) {
        List<Doctor> mostPopularDoctors = new ArrayList<>();
        Doctor mostPopularDoctor = null;
        for (Doctor doctor : doctors) {
            if (mostPopularDoctor == null || mostPopularDoctor.getVisitList().size() > mostPopularDoctor.getVisitList().size()) {
                mostPopularDoctor = doctor;

            }
            ;
        }
        mostPopularDoctors.add(mostPopularDoctor);
        for (Doctor doctor : mostPopularDoctors) {
            if (!(mostPopularDoctor.equals(doctor)) && mostPopularDoctor.getVisitList().size() == doctor.getVisitList().size()) {
                mostPopularDoctors.add(doctor);
            }
        }
        return mostPopularDoctors;
    }

    public static List<Patient> findMostFrequentPatient(List<Patient> patients) {
        List<Patient> mostFrequentPatients = new ArrayList<>();
        Patient mostFrequentPatient = null;
        for (Patient patient : patients) {
            if (mostFrequentPatient == null || mostFrequentPatient.getVisitList().size() > mostFrequentPatient.getVisitList().size()) {
                mostFrequentPatient = patient;
            }
        }
        mostFrequentPatients.add(mostFrequentPatient);
        for (Patient patient : mostFrequentPatients) {
            if (!(mostFrequentPatient.equals(patient)) && mostFrequentPatient.getVisitList().size() == patient.getVisitList().size()) {
                mostFrequentPatients.add(patient);
            }
        }
        return mostFrequentPatients;
    }

    private static String findMostPopularSpecialization(List<Doctor> doctors) {
        String mostPopularSpecialization = null;
        int maxCount = 0;
        for (Doctor doctor : doctors) {
            int count = 0;
            for (Doctor doc : doctors) {
                if (doc.getSpecialisation().equals(doctor.getSpecialisation())) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostPopularSpecialization = doctor.getSpecialisation();
            }
        }
        return mostPopularSpecialization;
    }

    private static int findYearWithMostVisits(List<Visit> visits) {
        int maxYear = 0;
        int maxCount = 0;
        for (Visit visit : visits) {
            int year = visit.getVisitDate().getYear();
            int count = 0;
            for (Visit v : visits) {
                if (v.getVisitDate().getYear() == year) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxYear = year;
            }
        }
        return maxYear;
    }

    private static List<Doctor> findTopOldestDoctors(List<Doctor> doctors) {
        List<Doctor> oldestDoctors = new ArrayList<>();
        List<LocalDate> birthDates = new ArrayList<>();
        for (Doctor doctor : doctors) {
            birthDates.add(doctor.getBirthDate());
        }
        birthDates.sort(LocalDate::compareTo);
        for (int i = 0; i < 5; i++) {
            for (Doctor doctor : doctors) {
                if (doctor.getBirthDate().equals(birthDates.get(i))) {
                    oldestDoctors.add(doctor);
                }
            }
        }
        return oldestDoctors;
    }

    private static List<Doctor> findTopMostPopularDoctors(List<Doctor> doctors) {
        List<Doctor> mostPopularDoctors = new ArrayList<>();
        int[] visitSizes = new int[doctors.size()];
        for (int i = 0; i < visitSizes.length; i++) {
            visitSizes[i] = doctors.get(i).getVisitList().size();
        }
        Arrays.sort(visitSizes);
        for (int i = visitSizes.length - 1; i > visitSizes.length - 6; i--) {
            for (Doctor doctor : doctors) {
                if (doctor.getVisitList().size() == visitSizes[i]) {
                    mostPopularDoctors.add(doctor);
                    break;
                }
            }
        }
        return mostPopularDoctors;
    }

    private static List<Patient> findPatientsWithMinFiveDoctors(List<Patient> patients) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            List<Integer> uniqueDoctors = new ArrayList<>();
            for (Visit visit : patient.getVisitList()) {
                int doctorId = visit.getDoctorId();
                boolean alreadyExists = false;
                for (Integer uniqueDoctorId : uniqueDoctors) {
                    if (uniqueDoctorId == doctorId) {
                        alreadyExists = true;
                        break;
                    }
                }
                if (!alreadyExists) {
                    uniqueDoctors.add(doctorId);
                }
            }
            if (uniqueDoctors.size() >= 5) {
                result.add(patient);
            }
        }
        return result;
    }

    private static List<Doctor> findDoctorsWithOnePatient(List<Doctor> doctors) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            List<Integer> uniquePatients = new ArrayList<>();
            for (Visit visit : doctor.getVisitList()) {
                int patientId = visit.getPatientId();
                boolean alreadyExists = false;
                for (Integer uniquePatientId : uniquePatients) {
                    if (uniquePatientId == patientId) {
                        alreadyExists = true;
                        break;
                    }
                }
                if (!alreadyExists) {
                    uniquePatients.add(patientId);
                }
            }
            if (uniquePatients.size() == 1) {
                result.add(doctor);
            }
            //System.out.println("Doctor ID: " + doctor.getId() + ", unique patients count: " + uniquePatients.size());
        }
        return result;
    }

}


