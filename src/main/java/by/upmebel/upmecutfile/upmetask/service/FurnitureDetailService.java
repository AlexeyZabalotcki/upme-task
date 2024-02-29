package by.upmebel.upmecutfile.upmetask.service;

import by.upmebel.upmecutfile.upmetask.dto.FurnitureDetailDto;

import java.util.List;
import java.util.Optional;

public interface FurnitureDetailService {

    FurnitureDetailDto create(FurnitureDetailDto furnitureDetail);

    FurnitureDetailDto update(Long id, FurnitureDetailDto furnitureDetail);

    Optional<FurnitureDetailDto> getById(Long id);

    List<FurnitureDetailDto> getAll();

    void delete(Long id);
}
