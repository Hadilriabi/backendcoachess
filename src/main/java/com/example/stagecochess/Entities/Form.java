package com.example.stagecochess.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long formId;

    String question;
    Float response;

    @Enumerated(EnumType.STRING)
    FormEnum stringResponse;

    @ManyToOne
     private User user;





}
