package rvt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CsvManager {

    public static final String HOBBIES_CSV = "data/hobbies.csv";
    public static final String STUDENT_CSV = "data/students.csv";
    
    private Resource resource;

    public CsvManager(String filePath) {
        this.resource = new ClassPathResource(filePath);
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();

            try (CSVReader reader = new CSVReader(new FileReader(this.resource.getFile()))) {
                String[] nextLine;
                reader.readNext(); // Skip the header line
            while ((nextLine = reader.readNext()) != null) {
                Student student = new Student(nextLine[0], nextLine[1], nextLine[2], nextLine[3]);
                studentList.add(student);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (CsvValidationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(studentList.size());
        return studentList;
    }

    public void addStudentToCSV(Student student) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(this.resource.getFile(), true))) {
            writer.writeNext(student.toArray());
            writer.flush();
        }
        catch (IOException e) {
            System.out.println("Error writing to CSV file!");
        }
    }
}
