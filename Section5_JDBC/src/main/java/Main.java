package main.java;

import java.sql.*;
import java.util.Scanner;

// Steps to run this program:
// 1. Download the SQLite JDBC driver and SLF4J (if needed).
// 2. Compile the program.
// 3. Run the program.

// Compile command: javac -cp "lib/*" src/main/java/Main.java -d bin
// Run command: java -cp "lib/*:bin" main.java.Main

public class Main {
    private static final String URL = "jdbc:sqlite:students.db";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Create a connection to the database
            connection = DriverManager.getConnection(URL);

            // Scanner for reading user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an action: add, display, update, delete");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("add")) {
                addNewStudent(connection, scanner);
            } else if (action.equalsIgnoreCase("display")) {
                displayStudents(connection);
            } else if (action.equalsIgnoreCase("update")) {
                updateStudent(connection, scanner);
            } else if (action.equalsIgnoreCase("delete")) {
                deleteStudent(connection, scanner);
            } else {
                System.out.println("Invalid action. Use 'add', 'display', 'update', or 'delete'.");
            }

            scanner.close();

        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex.getMessage());
            }
        }
    }

    private static void addNewStudent(Connection connection, Scanner scanner) {
        System.out.print("Enter student number: ");
        int studentNum = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student GPA: ");
        double gpa = scanner.nextDouble();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();

            // Check if the student number already exists
            String checkSql = "SELECT COUNT(*) AS count FROM students WHERE student_num = " + studentNum;
            rs = stmt.executeQuery(checkSql);

            if (rs.next() && rs.getInt("count") > 0) {
                System.out.println("Student number " + studentNum + " already exists.");
            } else {
                // Insert the new student
                String insertSql = "INSERT INTO students (student_num, name, gpa) VALUES (" + studentNum + ", '" + name + "', " + gpa + ")";
                stmt.executeUpdate(insertSql);
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            closeResources(rs, stmt);
        }
    }

    private static void displayStudents(Connection connection) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            String sql = "SELECT * FROM students";
            rs = stmt.executeQuery(sql);

            // Print the results
            while (rs.next()) {
                int studentNum = rs.getInt("student_num");
                String name = rs.getString("name");
                double gpa = rs.getDouble("gpa");

                System.out.println("Student Number: " + studentNum);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            closeResources(rs, stmt);
        }
    }

    private static void updateStudent(Connection connection, Scanner scanner) {
        System.out.print("Enter student number to update: ");
        int studentNum = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new student GPA: ");
        double gpa = scanner.nextDouble();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            // Update the student
            String updateSql = "UPDATE students SET name = '" + name + "', gpa = " + gpa + " WHERE student_num = " + studentNum;
            int rowsAffected = stmt.executeUpdate(updateSql);

            if (rowsAffected > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student number " + studentNum + " does not exist.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            closeResources(null, stmt);
        }
    }

    private static void deleteStudent(Connection connection, Scanner scanner) {
        System.out.print("Enter student number to delete: ");
        int studentNum = scanner.nextInt();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            // Delete the student
            String deleteSql = "DELETE FROM students WHERE student_num = " + studentNum;
            int rowsAffected = stmt.executeUpdate(deleteSql);

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student number " + studentNum + " does not exist.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            closeResources(null, stmt);
        }
    }

    private static void closeResources(ResultSet rs, Statement stmt) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
    }
}