package company.ryzhkov.enterprise.api;

import company.ryzhkov.enterprise.entity.Node;
import company.ryzhkov.enterprise.entity.Point;

import java.util.List;

/**
 * The interface Point repository.
 * @author Stanislav Ryzhkov
 * Created 27/03/2020
 */
public interface PointRepository {
    long allPointsInNode(Node node);
    long freePointsInNode(Node node);
    List<Point> getOccupiedPointsByNodeName(String nodeName);
}
