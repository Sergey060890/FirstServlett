package service;

import DTO.StudentDTO;
import entity.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private static final List<StudentEntity> repositoryStudent = List.of(
            StudentEntity.builder().id("1").name("Vasya").age("25").address("Monaco").mark("5").build(),
            StudentEntity.builder().id("2").name("Dima").age("25").address("Miami").mark("3").build(),
            StudentEntity.builder().id("3").name("Egor").age("45").address("Monaco").mark("1").build(),
            StudentEntity.builder().id("4").name("Valera").age("25").address("Miami").mark("2").build()
    );

    @Override
    public List<StudentDTO> findALL(String name, String age) {
        return repositoryStudent.stream()
                .filter(studentEntity -> studentEntity.getName().equals(name) &&
                        studentEntity.getAge().equals(age))
                .map(studentEntity -> StudentDTO.builder()
                        .id(studentEntity.getId())
                        .name(studentEntity.getName())
                        .age(studentEntity.getAge())
                        .mark(studentEntity.getMark())
                        .build())
                .collect(Collectors.toList());
    }
}
