package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.services.StudentService;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SQLException {
        var context
                = SpringApplication.run(Application.class);

        System.out.println("Количество студентов:" +
                context.getBean(StudentService.class).countStudentsByFio("Иванов ИИ"));

        Console.main();
    }
}
