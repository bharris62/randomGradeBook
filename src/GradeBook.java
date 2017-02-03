import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GradeBook {


    public static void createMap(String name){
        Map<String, List<String>> gradeBook = new HashMap<>();

        ArrayList<String> letterGrade = new ArrayList<>();
        for(int i =0; i < 10; i++) {
            letterGrade.add(createRandomGrade());
        }
        gradeBook.put(name, letterGrade);
        printPrettyMap((HashMap<String, List<String>>) gradeBook);

    }

    public static void printPrettyMap(HashMap<String, List<String>> map){
        int numericGrade = 0;
        double numberOfGrades = 0;
        for(String name : map.keySet()){
            String key = name.toString();
            System.out.printf("%-8s", key + ": ");
            for (String letter : map.get(name)){
                System.out.print(letter.charAt(0) + " ");
                numericGrade += getNumberGrade(letter.charAt(0));
                numberOfGrades++;
            }
            System.out.print(" " + (numericGrade / numberOfGrades));
            System.out.println();
        }
    }

    public static int getNumberGrade(char letter){
        int letterGrade = 0;
        switch (letter){
            case 'A' : letterGrade = 90;
                break;
            case 'B' : letterGrade = 80;
                break;
            case 'C' : letterGrade = 70;
                break;
            case 'D' : letterGrade = 60;
                break;
            case 'F' : letterGrade = 50;
                break;
        }
        return letterGrade;
    }


    public static void assignStudent(){
        String[] student = {"Joe", "Sally", "Adam", "Sue", "Alex", "Jacob"};
        System.out.println("Name        GRADES            AVG");
        for(String name : student) {
            createMap(name);
        }
    }


    public static int createRandomNum(){
        Random rand = new Random();
        int x = rand.nextInt(13);

        return x;
    }


    public static String createRandomGrade(){
        String[] grades = {"A","A+","A-","B","B+","B-","C","C+","C-","D","D+","D-","F"};

        return grades[createRandomNum()];
    }
}