package com.knowledge_hub.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {


    @OneToMany(mappedBy="us")
    private Set<Problem> problem;

    public User(Integer user_id, String mobileNumber, String email,
                String firstName, String lastName, String password)
    {
        super();

        this.user_id = user_id;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "mobile_number")
    private String mobileNumber;


    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @JsonIgnore
    @Column(name="password")
    private String password;

    // Overriding the toString method to find all the values
    @Override
    public String toString()
    {

        return "user [User ID="
                + user_id + ", Password="
                + password + ", First Name="
                + firstName + ", Last Name="
                + lastName + ", MobileNumber="
                + mobileNumber + "]";
    }

}