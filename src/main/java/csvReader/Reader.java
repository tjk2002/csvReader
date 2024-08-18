package csvReader;

import com.opencsv.CSVReader; //Import the csv reader class from the opencsv library

import java.io.FileReader;
import java.util.ArrayList;

public class Reader {

    // Define the Student class
    public static class Student {
    	//Fields for student information
        String id;
        String name;
        int math;
        int science;
        int english;
        int history;

        // Constructor for the Student class
        public Student(String id, String name, int math, int science, int english, int history) {
            this.id = id;
            this.name = name;
            this.math = math;
            this.science = science;
            this.english = english;
            this.history = history;
        }
    }

    // Method to read CSV file and create a list of Student objects
    public static ArrayList<Student> readIn(String fileName) {
        ArrayList<Student> records = new ArrayList<>(); //Create an ArrayList to store student objects

        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) { //Use a try with resources statement to automatically close the file handler
       
        	
        	String[] header = csvReader.readNext(); //Read and ignore the header row (column names)
        	
        	//Loop through each row of the csv file
            String[] values;
            while ((values = csvReader.readNext()) != null) { //Read the next line of the file
                // Convert each row into a Student object and add it to the list
                String id = values[0]; //Get student id from the first column
                String name = values[1]; //Grt student name from the second column
                int math = Integer.parseInt(values[2]); //Get math score from the third column and convert to int
                int science = Integer.parseInt(values[3]); //Get science score from the third column and convert to int
                int english = Integer.parseInt(values[4]); //Get english score from the third column and convert to int
                int history = Integer.parseInt(values[5]); //Get history score from the third column and convert to int
                
                //Create a new Student object with the extracted values
                Student student = new Student(id, name, math, science, english, history);
                records.add(student); //Add the new student object to the list
            }
        } catch (Exception e) { //Catch any errors that occur during file reading or parsing
            e.printStackTrace(); //Print the stack trace for debugging purposes
        }

        return records; //Return the ArrayList of student objects
    }

    // Main method
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String fileName = "C:\\Users\\tobia\\Documents\\Book1.csv";

        // Call the readIn method to get a list of Student objects
        ArrayList<Student> records = readIn(fileName);

        // Display the data from the CSV file
        for (Student student : records) {
            System.out.println("ID: " + student.id + " Name: " + student.name + " Math: " + student.math
                    + " Science: " + student.science + " English: " + student.english + " History: " + student.history);
        }
    }
}
