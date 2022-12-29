package com.knowledge_hub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;


@Entity
@Table(name = "problem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User us;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Department")
    private String Department;

    @Column(name = "problem")
    private String problem;

    @Column(name = "solution")
    private String solution;

    @Column(name = "category")
    private String category;
    @Column(name = "sub_category")
    private String sub_category;

    @Column(name = "status")
    private String Status;

    @Column(name = "title")
    private String Title;
    @Temporal(TemporalType.TIME)
    @Column(name = "creation_time")
    private LocalTime CreationTime = LocalTime.now();

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private LocalDate CreationDate = LocalDate.now();



    // Overriding the toString method to find all the values
    @Override
    public String toString()
    {

        return "Problem [id="
                + id + ", Department="
                + Department + ", Problem="
                + problem + ", Solution="
                + solution + ", Category="
                + category + ", Sub_Category="
                + sub_category + ", Status="
                + Status + ", Title="
                + Title + ", CreationTime="
                + CreationTime + ", CreationDate="
                + CreationDate + "]";
    }

}