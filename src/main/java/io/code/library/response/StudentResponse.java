package io.code.library.response;

import io.code.library.entity.Student;
import io.code.library.service.StudentService;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {


    private Long id;
    private String studentId;
    private String name;
    private String email;

    public static StudentResponse from(Student student){
        return StudentResponse.builder()
                .id(student.getId())
                .studentId(student.getStudentId())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }

}
