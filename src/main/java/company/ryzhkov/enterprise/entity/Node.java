package company.ryzhkov.enterprise.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * The type Node.
 * @author Stanislav Ryzhkov
 * Created 24/03/2020
 * Класс, описывающий сущность - узел
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "nodes")
@NamedQuery(name = "findAllNodes", query = "SELECT n FROM Node n")
public class Node extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "street")
    private String street;

    @Column(name = "building", length = 32)
    private String building;

    @OneToMany(mappedBy = "node", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConnectionUnit> connectionUnits;
}
