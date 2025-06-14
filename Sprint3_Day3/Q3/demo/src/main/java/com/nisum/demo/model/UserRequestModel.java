package com.nisum.demo.model;

import com.nisum.demo.validation.ValidUsername;
import jakarta.validation.constraints.*;

public class UserRequestModel {

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 20, message = "Name must be 2–20 characters")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 18, message = "Age must be 18 or more")
    private int age;



    //Getter

    public @NotNull(message = "Name is required") @Size(min = 2, max = 20, message = "Name must be 2–20 characters") String getName() {
        return name;
    }

    public @NotNull(message = "Email is required") @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public @Min(value = 18, message = "Age must be 18 or more") int getAge() {
        return age;
    }



    //Setter


    public void setName(@NotNull(message = "Name is required") @Size(min = 2, max = 20, message = "Name must be 2–20 characters") String name) {
        this.name = name;
    }

    public void setEmail(@NotNull(message = "Email is required") @Email(message = "Invalid email format") String email) {
        this.email = email;
    }

    public void setAge(@Min(value = 18, message = "Age must be 18 or more") int age) {
        this.age = age;
    }


}
