package by.upmebel.upmecutfile.upmetask.controller;

import by.upmebel.upmecutfile.upmetask.dto.HoleDto;
import by.upmebel.upmecutfile.upmetask.service.HoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hole")
@RequiredArgsConstructor
public class HoleController {

    private final HoleService service;

    @PostMapping("/coordinates")
    public ResponseEntity<Double> calculateCoordinates(@RequestBody HoleDto hole) {
        return new ResponseEntity<>(service.calculateCoordinates(hole), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HoleDto> create(@RequestBody HoleDto hole) {
        return new ResponseEntity<>(service.create(hole), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HoleDto> update(@PathVariable Long id, @RequestBody HoleDto hole) {
        return new ResponseEntity<>(service.update(id, hole), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoleDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<HoleDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
