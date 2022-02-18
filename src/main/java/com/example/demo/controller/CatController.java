package com.example.demo.controller;

import com.example.demo.dto.CatDTO;
import com.example.demo.entity.Cat;
import com.example.demo.service.CatService;
import com.example.demo.service.UserService;
import com.example.demo.service.mapper.CatDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    private final CatDTOMapper catMapper;

//    @PostMapping("/add")
//    public void createCat(@RequestBody Cat cat) {
//        catService.createCat(cat);
//    }

    @GetMapping("/check")
    public boolean existsCat(@RequestParam String catName) {
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
