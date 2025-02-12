package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*; // JPA annotations for ORM
import lombok.*;    // Lombok annotations for automatic getter, setter, and constructor generation
import javax.validation.constraints.NotNull; // Validation annotations
import javax.validation.constraints.Size;

import java.time.LocalDateTime; //Store date/time

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="media") // Specifies the name of the table in the database
public class Media {

    // Define fields for the Media entity

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="media_id")
    @NotNull(message = "Media Id cannot be null")
    private int mediaId;

    //Future foreign key
    @Column(name="capsule_id")
    @NotNull(message = "Capsule Id cannot be null")
    private int capsuleId;

    @Column(name="media_type")
    @NotNull(message = "Media Type cannot be null")
    @Size(min = 1, max = 45, message = "Title must be between 1 and 45 characters")
    private String mediaType;

    @Column(name="media_description")
    @Size(min = 0, max = 200, message = "Title must be no more than 200 characters")
    private String mediaDescription;

    @Column(name="file_path")
    @NotNull(message = "File Path cannot be null")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String filePath;

    @Column(name="upload_date")
    private LocalDateTime uploadDate;

}








