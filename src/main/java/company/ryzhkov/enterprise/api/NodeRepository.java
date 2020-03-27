package company.ryzhkov.enterprise.api;

import company.ryzhkov.enterprise.dto.LinkDto;
import company.ryzhkov.enterprise.dto.NodeInfoDto;

import java.util.List;


/**
 * The interface Node repository.
 * @author Stanislav Ryzhkov
 * Created 27/03/2020
 */
public interface NodeRepository {
    List<NodeInfoDto> getAllNodeInfos();
    List<LinkDto> getLinksByNodeName(String nodeName);
}
