package company.ryzhkov.enterprise.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The type Point.
 *  @author Stanislav Ryzhkov
 *  Created 24/03/2020
 *  Данный класс содержит описание штекера, в который подключается провод
 *  Провод является связью один-к-одному между двумя точками.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "points")
public class Point extends AbstractEntity {

    @ManyToOne
    private ConnectionUnit connectionUnit;

    @Column(name = "number", nullable = false)
    private Integer number;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "opposite_point_id", nullable = true)
    private Point oppositePoint;
}
