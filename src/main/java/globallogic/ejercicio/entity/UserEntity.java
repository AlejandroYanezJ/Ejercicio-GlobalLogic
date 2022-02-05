package globallogic.ejercicio.entity;

import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "USERS")
@Transactional
public class UserEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String created;
    private String lastLogin;
    private String token;
    private Boolean isActive;
}
