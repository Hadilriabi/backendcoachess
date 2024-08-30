package com.example.stagecochess.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
    String message;
    Boolean status;
     Long userId; // Ajouter l'ID de l'utilisateur

    public LoginResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

}
