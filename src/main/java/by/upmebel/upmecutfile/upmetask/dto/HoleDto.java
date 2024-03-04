package by.upmebel.upmecutfile.upmetask.dto;

import java.util.Map;

public record HoleDto(
        Double diameter,
        Double depth,
        Double entrySpeed,
        Double exitSpeed,
        String pattern,
        Map<String, Object> variables,
        Long furnitureDetailId
) {
}

