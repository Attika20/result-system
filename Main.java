import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Stud> students = new ArrayList<>();
    static String[] courses = {"OOP", "MATH2", "WEB-TECH", "Software-Engg"};

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        // Check for duplicate ID
        for (Stud s : students) {
            if (s.id.equals(id)) {
                System.out.println("Student with this ID already exists.");
                return;
            }
        }

        Map<String, Result> results = new HashMap<>();

        for (String course : courses) {
            System.out.print("Enter " + course + " marks: ");
            double mark = sc.nextDouble();
            String grade = CalculGrade.notation(mark);
            results.put(course, new Result(mark, grade));
        }
        sc.nextLine(); // consume leftover newline

        students.add(new Stud(name, id, results));
        System.out.println("\nStudent added successfully.");
    }

    static void view_result() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }

        for (Stud s : students) {
            System.out.println("\n" + s.name + " (" + s.id + ")");
            for (String c : courses) {
                Result r = s.results.get(c);
                System.out.println(c + ": " + r.mark + " | Grade: " + r.grade);
            }
            System.out.printf("Average: %.2f%n", CalculGrade.avg(s));
        }
    }

    static void top_stud() {
        if (students.isEmpty()) {
            System.out.println("\nNo students yet.");
            return;
        }

        Stud top = students.get(0);
        for (Stud s : students) {
            if (CalculGrade.avg(s) > CalculGrade.avg(top)) {
                top = s;
            }
        }

        System.out.println("\nTop Student: " + top.name);
        System.out.printf("Average: %.2f%n", CalculGrade.avg(top));
    }

    static void view_stud() {
        System.out.print("Enter your student ID: ");
        String id = sc.nextLine();

        for (Stud s : students) {
            if (s.id.equals(id)) {
                System.out.println("\nWelcome " + s.name);
                for (String c : courses) {
                    Result r = s.results.get(c);
                    System.out.println(c + ": " + r.mark + " | Grade: " + r.grade);
                }
                System.out.printf("Average: %.2f%n", CalculGrade.avg(s));
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void T_menu() {
        while (true) {
            System.out.println("\n--- Teacher Menu ---");
            System.out.println("1. Add new student");
            System.out.println("2. View all results");
            System.out.println("3. View top student");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> view_result();
                case 3 -> top_stud();
                case 4 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void S_menu() {
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View my results");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> view_stud();
                case 2 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void menu() {
        while (true) {
            System.out.println("\n<3<3<3 Student Result Management System <3<3<3");
            System.out.println("===============================================");
            System.out.println("Are you a student or a teacher: ");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Exit");

            int role = sc.nextInt();
            sc.nextLine();

            switch (role) {
                case 1 -> T_menu();
                case 2 -> S_menu();
                case 3 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}