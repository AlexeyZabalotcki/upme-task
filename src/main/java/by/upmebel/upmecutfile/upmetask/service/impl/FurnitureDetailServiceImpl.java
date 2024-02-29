package by.upmebel.upmecutfile.upmetask.service.impl;

import by.upmebel.upmecutfile.upmetask.dao.FurnitureDetailRepository;
import by.upmebel.upmecutfile.upmetask.dto.FurnitureDetailDto;
import by.upmebel.upmecutfile.upmetask.mapper.FurnitureDetailMapper;
import by.upmebel.upmecutfile.upmetask.model.FurnitureDetail;
import by.upmebel.upmecutfile.upmetask.service.FurnitureDetailService;
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
public class FurnitureDetailServiceImpl implements FurnitureDetailService {

    private final FurnitureDetailRepository repository;
    private final FurnitureDetailMapper mapper;

    @Override
    @Transactional
    public FurnitureDetailDto create(FurnitureDetailDto furnitureDetail) {
        FurnitureDetail toSave = mapper.toEntity(furnitureDetail);
        FurnitureDetail saved = repository.save(toSave);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public FurnitureDetailDto update(Long id, FurnitureDetailDto furnitureDetail) {
        FurnitureDetail updatedFurnitureDetail = mapper.toEntity(furnitureDetail);
        updatedFurnitureDetail.setId(id);
        FurnitureDetail saved = repository.save(updatedFurnitureDetail);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<FurnitureDetailDto> getById(Long id) {
        FurnitureDetail furnitureDetail = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Check detail's id " + id));
        return Optional.ofNullable(mapper.toDto(furnitureDetail));
    }

    @Override
    public List<FurnitureDetailDto> getAll() {
        List<FurnitureDetail> furnitureDetails = repository.findAll();
        return mapper.toDtoList(furnitureDetails);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
