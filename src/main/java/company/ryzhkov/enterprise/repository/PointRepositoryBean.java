package company.ryzhkov.enterprise.repository;

import company.ryzhkov.enterprise.api.PointRepository;
import company.ryzhkov.enterprise.entity.Node;
import company.ryzhkov.enterprise.entity.Point;

import javax.ejb.Stateless;
import java.util.List;


/**
 * The type Point repository bean.
 * @author Stanislav Ryzhkov
 * Created 27/03/2020
 * Enterprise java bean без состояния.
 * Содержит бизнес-логику, объединяющую работу с точками
 */
@Stateless
public class PointRepositoryBean extends AbstractRepositoryBean implements PointRepository {

    /**
     * @return количество точек в узле
     */
    @Override
    public long allPointsInNode(Node node) {
        return em.createQuery("SELECT COUNT (p) FROM Point p WHERE p.connectionUnit.node = :node", Long.class)
                .setParameter("node", node)
                .getSingleResult();
    }

    /**
     * @return количество свободных точек в узле
     */
    @Override
    public long freePointsInNode(Node node) {
        return em.createQuery("SELECT COUNT (p) FROM Point p " +
                "WHERE (p.connectionUnit.node = :node) AND (p.oppositePoint IS NULL )", Long.class)
                .setParameter("node", node)
                .getSingleResult();
    }

    /**
     * @return список точек, относящихся к данному узлу
     */
    @Override
    public List<Point> getOccupiedPointsByNodeName(String nodeName) {
        return em.createQuery("SELECT p FROM Point p " +
                "WHERE (p.connectionUnit.node.name = :nodeName) AND (p.oppositePoint IS NOT NULL )", Point.class)
                .setParameter("nodeName", nodeName)
                .getResultList();
    }
}
