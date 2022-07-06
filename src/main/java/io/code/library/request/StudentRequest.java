package io.code.library.request;

import io.code.library.entity.Student;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentRequest {

    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;

    public Student to(){

        return Student.builder()
                .studentId(UUID.randomUUID().toString())
                .name(name)
                .email(email)
                .build();


    }


}
