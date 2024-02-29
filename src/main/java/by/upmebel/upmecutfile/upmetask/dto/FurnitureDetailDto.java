package by.upmebel.upmecutfile.upmetask.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record FurnitureDetailDto (
        @Min(4)
        @Max(5)
        Double height
){}

