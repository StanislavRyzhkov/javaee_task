package company.ryzhkov.enterprise.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/**
 * The type Connection unit.
 * @author Stanislav Ryzhkov
 * Created 24/03/2020
 * Класс, описывающий сущность - коннектор
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "connection_units")
public class ConnectionUnit extends AbstractEntity {

    @ManyToOne
    private Node node;

    @Column(name = "name")
    private String name;

    @OrderBy("number")
    @OneToMany(mappedBy = "connectionUnit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Point> points;
}
