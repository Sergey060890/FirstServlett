package service;

import DTO.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findALL(String name,String age);

}
