package company.ryzhkov.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import company.ryzhkov.enterprise.api.NodeRepository;
import company.ryzhkov.enterprise.dto.LinkDto;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * The type Node bean.
 * Сессионный бин, отвечающий за отображение линий, подключенных к кокретному узлу:
 * @author Stanislav Ryzhkov Created 27/03/2020
 */
@Named("nodeBean")
@SessionScoped
@URLMapping(id = "node", pattern = "/node", viewId = "/WEB-INF/views/node.xhtml")
public class NodeBean implements Serializable {
    private String nodeName;

    @Inject
    private NodeRepository nodeRepository;

    public List<LinkDto> getLinkDtoList() {
        return nodeRepository.getLinksByNodeName(nodeName);
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
