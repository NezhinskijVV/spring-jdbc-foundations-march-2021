package ru.itsjava.services;

import ru.itsjava.domain.Student;

public interface StudentService {
    int countStudentsByFio(String fio);
    void insertStudent(Student student);
    Student getById(long id);
}