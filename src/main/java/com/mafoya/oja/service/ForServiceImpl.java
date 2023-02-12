package com.mafoya.oja.service;

import com.mafoya.oja.dto.ForDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.For;
import com.mafoya.oja.model.For;
import com.mafoya.oja.repository.ForRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ForServiceImpl  implements ForService {

    private final ForRepository forSerRepository;

    public ForServiceImpl(ForRepository forSerRepository) {
        this.forSerRepository = forSerRepository;
    }

    @Override
    public ForDto getById(String authorization, String id) {
        ForDto forSerDto;
        Optional<For> forSerOptional = forSerRepository.findById(id);
        if (forSerOptional.isPresent()) {
            forSerDto = OjaMapper.mapForDto(forSerOptional.get());
            return forSerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public ForDto create(String authorization, ForDto forSerDto) {
        For forSer = OjaMapper.mapForDo(forSerDto);
        forSerRepository.save(forSer);
        return forSerDto;
    }

    @Override
    public ForDto update(String authorization, ForDto forSerDto, String id) {
        Optional<For> forSerOptional = forSerRepository.findById(id);
        if (forSerOptional.isPresent()) {
            For forSer = OjaMapper.mapForDo(forSerDto);
            forSer.setId(id);
            forSerRepository.save(forSer);
            return forSerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<ForDto> getAll(String authorization) {
        List<For> doList = (List<For>) forSerRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        forSerRepository.deleteById(id);
    }
}

