package com.example.demo.controller;

import com.example.demo.dto.CatDTO;
import com.example.demo.entity.Cat;
import com.example.demo.service.CatService;
import com.example.demo.service.mapper.CatDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/cats")
@RequiredArgsConstructor
@Validated
public class CatController {

    private final CatService catService;

    private final CatDTOMapper catMapper;

    @GetMapping
    public Page<CatDTO> getAll(@PageableDefault(sort = {"name"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return catService.getAll(pageable);
    }

    @PostMapping("/add")
    public void createCat(@RequestBody @Valid CatDTO cat) {
        catService.createCat(cat);
    }

    @GetMapping("/check")
    public boolean existsCat(@RequestParam @NotNull String catName) {
        return catService.catExists(catName);
    }

    @GetMapping("/get")
    public List<Cat> getCatByName(@RequestParam String catName) {
        return catService.getCatsByName(catName);
    }

    @GetMapping("/getByUsername")
    public List<Cat> getCatByUsername(@RequestParam String username) {
        return catService.getCatsByUsername(username);
    }

    @PostMapping("/testDtoMapper")
    public CatDTO testCatDTOMap(@RequestParam UUID catId) {
        return catMapper.toDTO(catService.read(catId).get());
    }

    @PostMapping("/testEntityMapper")
    public void testCatEntityMap(@RequestBody CatDTO cat) {
        catService.createCat(cat);
//        return catMapper.toEntity(cat);
    }

}
