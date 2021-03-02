package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class StudentsJdbcImpl implements StudentsJdbc{
    private final JdbcOperations jdbcOperations;


    @Override
    public int countStudentsByFio(String fio) {
        return jdbcOperations.
                queryForObject(
                        "select count(*) from students where fio = '" + fio + "'",
                        Integer.class);
    }
}