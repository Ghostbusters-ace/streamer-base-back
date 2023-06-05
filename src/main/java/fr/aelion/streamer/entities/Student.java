package fr.aelion.streamer.entities;

import fr.aelion.streamer.entities.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personne")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   private String lastName;
   private String firstName;
   private String email;
   private String login;
   private String password;
   private String phoneNumber;
    private String answer;
    private Role role;
}
