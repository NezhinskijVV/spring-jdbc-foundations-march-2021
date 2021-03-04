package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Student {
    private final long id;
    private final String fio;
    private final int age;
    private Faculty faculty;
}
