package com.jfranbob.coursesmanagement.apirest.student;

import com.jfranbob.coursesmanagement.application.student.CreateStudentCommand;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @NotBlank(message = "First name is required")
        @Size(max = 50, message = "First name must be less than 50 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(max = 50, message = "Last name must be less than 50 characters")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^[0-9\\-+]{9,15}$", message = "Invalid phone format")
        String phone,

        @NotBlank(message = "Passport number is required")
        @Size(max = 20, message = "Passport number must be less than 20 characters")
        String passportNumber,

        @NotBlank(message = "Nationality is required")
        String nationality
) {
    public CreateStudentCommand toCommand() {
        return new CreateStudentCommand(firstName, lastName, email, phone, passportNumber, nationality);
    }
}
