package ru.itsjava.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Faculty;
import ru.itsjava.domain.Student;

@JdbcTest
@Import(StudentsJdbcImpl.class)
public class StudentsJdbcImplTest {

    @Autowired
    private StudentsJdbc studentsJdbc;

    @Test
    public void shouldHaveCorrectInsert(){
        Student testStudent = new Student(2L, "Test fio", 21);
        studentsJdbc.insertStudent(testStudent);
        Assertions.assertEquals(testStudent, studentsJdbc.getStudentById(2L));
    }
}
