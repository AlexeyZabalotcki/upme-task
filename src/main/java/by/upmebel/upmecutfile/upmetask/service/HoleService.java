package by.upmebel.upmecutfile.upmetask.service;

import by.upmebel.upmecutfile.upmetask.dto.HoleDto;

import java.util.List;
import java.util.Optional;

public interface HoleService {

    HoleDto create (HoleDto hole);
    HoleDto update (Long id, HoleDto hole);
    Optional<HoleDto> getById(Long id);
    List<HoleDto> getAll();
    void delete (Long id);
}
