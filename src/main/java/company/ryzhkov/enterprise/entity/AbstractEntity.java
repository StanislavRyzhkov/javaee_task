package company.ryzhkov.enterprise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Abstract entity.
 * @author Stanislav Ryzhkov
 * Created 24/03/2020
 */
@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
