package uz.khamroz.crudreportdemo.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import uz.khamroz.crudreportdemo.model.enums.Role;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Role role;


}
