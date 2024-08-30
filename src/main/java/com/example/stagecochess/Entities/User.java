package com.example.stagecochess.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long UserId;

    String username;
    String email;
    String password;



    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Needs> needs;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Cmtr> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Form> forms;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

    // Constructeur avec paramètres nécessaires
    public User(String UserName, String Email, String Password) {
        this.username = UserName;
        this.email = Email;
        this.password = Password;
    }




}
