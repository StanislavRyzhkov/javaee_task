package company.ryzhkov.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import company.ryzhkov.enterprise.api.NodeRepository;
import company.ryzhkov.enterprise.dto.NodeInfoDto;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * The type Main controller.
 * Сессионный бин, отвечающий за отображение данных на главной странице:
 * список узлов
 * @author Stanislav Ryzhkov Created 27/03/2020
 */
@Named("mainBean")
@SessionScoped
@URLMapping(id = "main", pattern = "/", viewId = "/WEB-INF/views/index.xhtml")
public class MainBean implements Serializable {
    private List<NodeInfoDto> nodeInfoDtoList;

    @Inject
    private NodeRepository nodeRepository;

    @PostConstruct
    public void init() {
        nodeInfoDtoList = nodeRepository.getAllNodeInfos();
    }

    public List<NodeInfoDto> getNodeInfoDtoList() {
        return nodeInfoDtoList;
    }

    public String redirectToNodePage(String nodeName) {
        return "node?faces-redirect=true&nodeName=" + nodeName;
    }
}
