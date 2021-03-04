package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.domain.Student;
import ru.itsjava.services.StudentService;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {
        var context
                = SpringApplication.run(Application.class);

        StudentService studentService = context.getBean(StudentService.class);
        studentService.insertStudent(new Student(2L, "Petrov II", 38));;

        System.out.println("Количество студентов:" +
                studentService.countStudentsByFio("Иванов ИИ"));

        System.out.println(studentService.getById(1L));

        Console.main();
    }
}
