package com.github.nclsbayona.common.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String age;

    public String calculateNickname(){
        return firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase() + age;
    }
}
