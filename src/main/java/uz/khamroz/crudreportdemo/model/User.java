package uz.khamroz.crudreportdemo.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.domain.Auditable;
import uz.khamroz.crudreportdemo.model.enums.Role;

@Entity
@Table(name = "users")
@Data
public class User extends UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String lastLogin;



}
