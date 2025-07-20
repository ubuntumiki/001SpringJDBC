package com.cbs.springcourse.dao;

import org.springframework.stereotype.Component;
import com.cbs.springcourse.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAO {
    private static int STUDENT_COUNT;

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/carsshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Student> index() {
        List<Student> students = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from student";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setLastname(resultSet.getString("lastname"));
                student.setAge(resultSet.getInt("age"));
                student.setPhone(resultSet.getString("phone"));
                student.setEmail(resultSet.getString("email"));

                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return students;
    }

    public Student show(int id) {
        Student student = null;

        try {
            PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM student WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            student = new Student();

            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString("name"));
            student.setLastname(resultSet.getString("lastname"));
            student.setAge(resultSet.getInt("age"));
            student.setPhone(resultSet.getString("phone"));
            student.setEmail(resultSet.getString("email"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    public void save(Student student) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO student VALUES(1, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getLastname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Student updatedStudent) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE student SET name=?, lastname=?, age=?, phone=?, email=? WHERE id=?");

            preparedStatement.setString(1, updatedStudent.getName());
            preparedStatement.setString(2, updatedStudent.getLastname());
            preparedStatement.setInt(3, updatedStudent.getAge());
            preparedStatement.setString(4, updatedStudent.getPhone());
            preparedStatement.setString(5, updatedStudent.getEmail());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
