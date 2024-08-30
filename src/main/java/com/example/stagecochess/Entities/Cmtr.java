package com.example.stagecochess.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cmtr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCmnt;
    private String descCmnt;
    private String dateCmnt;
    @JsonIgnore
    @ManyToOne
    private User user;


    @JsonIgnore
    @ManyToOne
    private Post post;
}
