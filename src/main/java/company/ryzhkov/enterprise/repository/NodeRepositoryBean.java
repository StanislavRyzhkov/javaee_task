package company.ryzhkov.enterprise.repository;

import company.ryzhkov.enterprise.api.NodeRepository;
import company.ryzhkov.enterprise.api.PointRepository;
import company.ryzhkov.enterprise.dto.LinkDto;
import company.ryzhkov.enterprise.dto.NodeInfoDto;
import company.ryzhkov.enterprise.entity.Node;
import company.ryzhkov.enterprise.entity.Point;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Node repository bean.
 * @author Stanislav Ryzhkov
 * Created 27/03/2020
 * Enterprise java bean без состояния.
 * Содержит бизнес-логику, объединяющую работу с узлами
 */
@Stateless
public class NodeRepositoryBean extends AbstractRepositoryBean implements NodeRepository, Serializable {

    @Inject
    private PointRepository pointRepository;

    @Override
    public List<NodeInfoDto> getAllNodeInfos() {
        return em.createNamedQuery("findAllNodes", Node.class)
                .getResultList()
                .stream()
                .map(node -> new NodeInfoDto(node.getName(),
                        node.getRegion(),
                        node.getStreet(),
                        node.getBuilding(),
                        pointRepository.allPointsInNode(node),
                        pointRepository.freePointsInNode(node)))
                .collect(Collectors.toList());
    }

    @Override
    public List<LinkDto> getLinksByNodeName(String nodeName) {
        List<Point> occupiedPointsByNodeName = pointRepository.getOccupiedPointsByNodeName(nodeName);
        return occupiedPointsByNodeName.stream()
                .map(point -> {
                    String originalNodeNAme = point.getConnectionUnit().getNode().getName();
                    String originalCUName = point.getConnectionUnit().getName();
                    int originalPointNumber = point.getNumber();

                    Point oppositePoint = point.getOppositePoint();

                    String oppositeNodeName = oppositePoint.getConnectionUnit().getNode().getName();
                    String oppositeCUName = oppositePoint.getConnectionUnit().getName();
                    int oppositePointNumber = oppositePoint.getNumber();

                    return new LinkDto(
                            originalNodeNAme,
                            originalCUName,
                            originalPointNumber,
                            oppositeNodeName,
                            oppositeCUName,
                            oppositePointNumber
                    );
                })
                .collect(Collectors.toList());
    }
}
