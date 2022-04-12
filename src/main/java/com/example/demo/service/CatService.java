package com.example.demo.service;

import com.example.demo.dto.CatDTO;
import com.example.demo.entity.Cat;
import com.example.demo.repository.CatsRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.mapper.CatDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatDTOMapper catMapper;

    private final CatsRepository catsRepository;

    private final UsersRepository usersRepository;

    public Optional<Cat> read(UUID catId) {
        Optional<Cat> cat = catsRepository.findById(catId);
        if (!cat.isPresent()) {
            throw new EntityNotFoundException("Cat with that ID do not exists");
        }
        return cat;
    }

    @Transactional
    public void createCat(CatDTO catDTO) {
        catsRepository.save(catMapper.toEntity(catDTO));
    }

    public boolean catExists(String catName) {
        return catsRepository.existsByNameIgnoreCase(catName);
    }

    public List<Cat> getCatsByName(String catName) {
        return catsRepository.findTop3ByNameContaining(catName);
    }

    public List<Cat> getCatsByUsername(String username) {
        return catsRepository.findByOwner(usersRepository.findByUsername(username).get());
    }

    public Page<CatDTO> getAll(Pageable pageable) {
        return catsRepository.findAll(pageable).map(catMapper::toDTO);
    }
}
