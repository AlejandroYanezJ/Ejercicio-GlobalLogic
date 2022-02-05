package globallogic.ejercicio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "PHONES")
@SuperBuilder
@IdClass(value = PhoneEntity.IdClass.class)
public class PhoneEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Id
    @Column(name="CONTRYCODE")
    private String contrycode;
    @Id
    @Column(name="CITYCODE")
    private int citycode;

    @Id
    @Column(name="NUMBER")
    private Long number;

    @Id
    @Column(name="USER_ID")
    private Long userId;

    @Data
    public static class IdClass implements Serializable {
        private Long id;
        private Long userId;
        private Long number;
        private int citycode;
        private String contrycode;
    }
}
