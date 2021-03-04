package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class Faculty {
    private final long id;
    private final String name;
}
