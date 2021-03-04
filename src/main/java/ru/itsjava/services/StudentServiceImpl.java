package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.dao.StudentsJdbc;
import ru.itsjava.domain.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentsJdbc studentsJdbc;

    @Override
    public int countStudentsByFio(String fio) {
        return studentsJdbc.countStudentsByFio(fio);
    }

    @Override
    public void insertStudent(Student student) {
        studentsJdbc.insertStudent(student);
    }

    @Override
    public Student getById(long id) {
        return studentsJdbc.getStudentById(id);
    }
}