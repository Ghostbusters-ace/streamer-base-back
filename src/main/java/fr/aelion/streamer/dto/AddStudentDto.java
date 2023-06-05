package fr.aelion.streamer.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStudentDto {

    @NotBlank(message = "Lastname cannot be null")
    private String lastName;

    private String firstName;

    @NotNull
    @Email
    private String email;

    private String phoneNumber;

    @NotBlank(message = "login cannot be null")
    @Size(min =8, message = "Login must have at least 8 chars")
    private String login;

    @NotBlank(message = "password can not be null")

    //@Min(8)
    private String password;
}
