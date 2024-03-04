package by.upmebel.upmecutfile.upmetask.service.impl;

import by.upmebel.upmecutfile.upmetask.dao.HoleRepository;
import by.upmebel.upmecutfile.upmetask.dao.HoleRepository;
import by.upmebel.upmecutfile.upmetask.dto.FurnitureDetailDto;
import by.upmebel.upmecutfile.upmetask.dto.HoleDto;
import by.upmebel.upmecutfile.upmetask.dto.HoleDto;
import by.upmebel.upmecutfile.upmetask.mapper.FurnitureDetailMapper;
import by.upmebel.upmecutfile.upmetask.mapper.HoleMapper;
import by.upmebel.upmecutfile.upmetask.mapper.HoleMapper;
import by.upmebel.upmecutfile.upmetask.model.CoordinatePattern;
import by.upmebel.upmecutfile.upmetask.model.FurnitureDetail;
import by.upmebel.upmecutfile.upmetask.model.Hole;
import by.upmebel.upmecutfile.upmetask.service.FurnitureDetailService;
import by.upmebel.upmecutfile.upmetask.service.HoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class HoleServiceImpl implements HoleService {

    private final HoleRepository repository;
    private final HoleMapper mapper;

    @Override
    public Double calculateCoordinates(HoleDto dto) {
        CoordinatePattern pattern = new CoordinatePattern(dto.pattern());
        dto.variables().forEach(pattern::setVariables);

        Hole hole = Hole.builder()
                .diameter(dto.diameter())
                .depth(dto.depth())
                .entrySpeed(dto.entrySpeed())
                .exitSpeed(dto.exitSpeed())
                .coordinates(pattern)
                .build();

        log.info("Hole with coordinates {}, {}", hole.toString(), hole.getCoordinates().toString());

        return pattern.evaluate();
    }

    @Override
    @Transactional
    public HoleDto create(HoleDto hole) {
        log.info("DTO {}", hole.toString());
        Hole toSave = mapper.toEntity(hole);
        log.info("Hole toSave {}", toSave.toString());
        Hole saved = repository.save(toSave);
        log.info("saved entity {}", saved.toString());
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public HoleDto update(Long id, HoleDto hole) {
        Hole updatedHole = mapper.toEntity(hole);
        updatedHole.setId(id);
        Hole saved = repository.save(updatedHole);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<HoleDto> getById(Long id) {
        Hole furnitureDetail = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Check detail's id " + id));
        return Optional.ofNullable(mapper.toDto(furnitureDetail));
    }

    @Override
    public List<HoleDto> getAll() {
        List<Hole> holes = repository.findAll();
        return mapper.toDtoList(holes);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
