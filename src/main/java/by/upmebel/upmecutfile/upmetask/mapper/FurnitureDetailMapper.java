package by.upmebel.upmecutfile.upmetask.mapper;

import by.upmebel.upmecutfile.upmetask.dto.FurnitureDetailDto;
import by.upmebel.upmecutfile.upmetask.model.FurnitureDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FurnitureDetailMapper {

    public FurnitureDetailDto toDto(FurnitureDetail furnitureDetail) {
        return new FurnitureDetailDto(furnitureDetail.getHeight());
    }

    public FurnitureDetail toEntity(FurnitureDetailDto dto) {
        return FurnitureDetail.builder()
                .height(dto.height())
                .build();
    }

    public List<FurnitureDetailDto> toDtoList(List<FurnitureDetail> details) {
        List<FurnitureDetailDto> dtos = new ArrayList<>();
        for (FurnitureDetail n : details) {
            dtos.add(toDto(n));
        }
        return dtos;
    }

    public List<FurnitureDetail> toEntityList(List<FurnitureDetailDto> dtos) {
        List<FurnitureDetail> details = new ArrayList<>();
        for (FurnitureDetailDto dto : dtos) {
            details.add(toEntity(dto));
        }
        return details;
    }
}

