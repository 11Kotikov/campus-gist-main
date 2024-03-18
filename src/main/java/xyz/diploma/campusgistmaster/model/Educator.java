package xyz.diploma.campusgistmaster.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "educator")
public class Educator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

}
