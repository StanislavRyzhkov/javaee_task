package company.ryzhkov.enterprise.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The type Node info dto.
 *  @author Stanislav Ryzhkov
 *  Created 27/03/2020
 *  Data transfer object.
 *  Содержит информацию для главное страницы веб-приложения:
 *  узел с его адрес, а также общее количество точек, относящихся к
 *  данносу узлу и количество свободных точек
 */
@Getter
@RequiredArgsConstructor
public class NodeInfoDto {
    private final String name;
    private final String region;
    private final String street;
    private final String building;
    private final long allPointsCount;
    private final long freePointsCount;
}
