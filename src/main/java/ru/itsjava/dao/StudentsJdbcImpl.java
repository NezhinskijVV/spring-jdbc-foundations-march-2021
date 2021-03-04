package ru.itsjava.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Faculty;
import ru.itsjava.domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@SuppressWarnings("ALL")
@Repository
@RequiredArgsConstructor
public class StudentsJdbcImpl implements StudentsJdbc {
    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;


    @Override
    public int countStudentsByFio(String fio) {
        return jdbcOperations.
                queryForObject(
                        "select count(*) from students where fio = '" + fio + "'",
                        Integer.class);
    }

    @Override
    public void insertStudent(Student student) {
        jdbcOperations.update("insert into students(id, fio, age) values (?,?,?) ",
                student.getId(), student.getFio(), student.getAge());
    }

    @Override
    public Student getStudentById(long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcOperations
                .queryForObject(
                        "select s.id, s.fio, s.age, f.id, f.name from students s, faculty f where s.id = :id and s.faculty_id = f.id",
                        params, new StudentMapper());
    }


    private static class StudentMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Student(resultSet.getLong("id"),
                    resultSet.getString("fio"),
                    resultSet.getInt("age"),
                    new Faculty(resultSet.getLong("faculty.id"),
                            resultSet.getString("faculty.name")));
        }
    }
}