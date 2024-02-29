package by.upmebel.upmecutfile.upmetask.controller;

import by.upmebel.upmecutfile.upmetask.dto.FurnitureDetailDto;
import by.upmebel.upmecutfile.upmetask.service.FurnitureDetailService;
import jakarta.validation.Valid;
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
@RequestMapping("/api/v1/furniture")
@RequiredArgsConstructor
public class FurnitureDetailController {

    private final FurnitureDetailService service;

    @PostMapping
    public ResponseEntity<FurnitureDetailDto> create (@Valid @RequestBody FurnitureDetailDto detail){
        return new ResponseEntity<>(service.create(detail), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FurnitureDetailDto> update (@PathVariable Long id, @Valid @RequestBody FurnitureDetailDto detail){
        return new ResponseEntity<>(service.update(id, detail), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FurnitureDetailDto> getById (@PathVariable Long id){
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<FurnitureDetailDto>> getAll (){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
