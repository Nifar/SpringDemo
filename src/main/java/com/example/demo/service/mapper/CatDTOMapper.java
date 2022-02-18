package com.example.demo.service.mapper;

import com.example.demo.dto.CatDTO;
import com.example.demo.entity.Cat;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CatDTOMapper implements EntityToDTOMapper<Cat, CatDTO> {

    final private ModelMapper modelMapper = new ModelMapper();

    private final UserService userService;

    public CatDTOMapper(UserService userService) {
        super();
        this.userService = userService;
//        modelMapper.addMappings(new PropertyMap<Cat, CatDTO>() {
//            @Override
//            protected void configure() {
//                skip().setName(null);
//            }
//        });
    }

    @Override
    public CatDTO toDTO(Cat entity, Object... args) {
        CatDTO dto = modelMapper.map(entity, CatDTO.class);
        if (entity.getOwner() != null) {
            dto.setOwnerId(entity.getOwner().getId());
        }
        return dto;
    }

    @Override
    public Cat toEntity(CatDTO dto, Object... args) {
        Cat entity = modelMapper.map(dto, Cat.class);
        entity.setOwner(userService.read(dto.getOwnerId()).get());
        return entity;
    }

}
