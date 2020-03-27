package company.ryzhkov.enterprise.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The type Link dto.
 * @author Stanislav Ryzhkov
 * Created 27/03/2020
 * Data transfer object.
 * Содержит данные о всех соединениях данного штекера с указанием его коннектора и узла
 * c другим штекером с указанием его коннектора и узла
 */
@Getter
@RequiredArgsConstructor
public class LinkDto {
    private final String originalNodeName;
    private final String originalCUName;
    private final int originalPointNumber;

    private final String oppositeNodeName;
    private final String oppositeCUName;
    private final int oppositePointNumber;
}
