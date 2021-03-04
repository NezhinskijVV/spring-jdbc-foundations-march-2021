package ru.itsjava.dao;

import ru.itsjava.domain.Student;

public interface StudentsJdbc {
    int countStudentsByFio(String fio);
    void insertStudent(Student student);
    Student getStudentById(long id);
}
