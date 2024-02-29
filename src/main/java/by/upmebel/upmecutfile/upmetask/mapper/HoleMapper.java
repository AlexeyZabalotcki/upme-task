package by.upmebel.upmecutfile.upmetask.mapper;

import by.upmebel.upmecutfile.upmetask.dao.FurnitureDetailRepository;
import by.upmebel.upmecutfile.upmetask.dto.HoleDto;
import by.upmebel.upmecutfile.upmetask.model.FurnitureDetail;
import by.upmebel.upmecutfile.upmetask.model.Hole;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class HoleMapper {

    private final FurnitureDetailRepository furnitureDetailRepository;


    public HoleDto toDto(Hole hole) {
        return new HoleDto(hole.getDiameter(), hole.getDepth(),
                hole.getEntrySpeed(), hole.getExitSpeed(), hole.getCoordinates(), hole.getFurnitureDetail().getId());
    }

    public Hole toEntity(HoleDto dto) {
        FurnitureDetail furnitureDetail = furnitureDetailRepository.findById(dto.furnitureDetailId())
                .orElseThrow(() -> new EntityNotFoundException("Check detail's id " + dto.furnitureDetailId()));
        return Hole.builder()
                .diameter(dto.diameter())
                .depth(dto.depth())
                .entrySpeed(dto.entrySpeed())
                .exitSpeed(dto.exitSpeed())
                .coordinates(dto.coordinates())
                .furnitureDetail(furnitureDetail)
                .build();
    }

    public List<HoleDto> toDtoList(List<Hole> holes) {
        List<HoleDto> dtos = new ArrayList<>();
        for (Hole n : holes) {
            dtos.add(toDto(n));
        }
        return dtos;
    }

    public List<Hole> toEntityList(List<HoleDto> dtos) {
        List<Hole> holes = new ArrayList<>();
        for (HoleDto dto : dtos) {
            holes.add(toEntity(dto));
        }
        return holes;
    }
}
