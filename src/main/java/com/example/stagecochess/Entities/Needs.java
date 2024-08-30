package com.example.stagecochess.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Needs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long NeedsId;

    String listOfNeeds;
    @ManyToOne
    private User user;

}
