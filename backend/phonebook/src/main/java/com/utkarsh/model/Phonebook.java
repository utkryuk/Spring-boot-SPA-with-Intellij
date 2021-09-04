package com.utkarsh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phonebook {

    @Id
    private String id;

    @NotEmpty(message = "first name must not be empty")
    private String firstName;

    @NotEmpty(message = "last name must not be empty")
    private String lastName;

    @NotNull(message = "phone number must not be empty")
    private Integer phone;
}
