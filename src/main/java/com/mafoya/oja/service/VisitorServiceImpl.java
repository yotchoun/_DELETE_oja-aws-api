package com.mafoya.oja.service;

import com.mafoya.oja.dto.VisitorDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Visitor;
import com.mafoya.oja.model.Visitor;
import com.mafoya.oja.repository.VisitorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VisitorServiceImpl  implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }


    @Override
    public VisitorDto getById(String authorization, String id) {
        VisitorDto visitorDto;
        Optional<Visitor> visitorOptional = visitorRepository.findById(id);
        if (visitorOptional.isPresent()) {
            visitorDto = OjaMapper.mapVisitorDto(visitorOptional.get());
            return visitorDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public VisitorDto create(String authorization, VisitorDto visitorDto) {
        Visitor visitor = OjaMapper.mapVisitorDo(visitorDto);
        visitorRepository.save(visitor);
        return visitorDto;
    }

    @Override
    public VisitorDto update(String authorization, VisitorDto visitorDto, String id) {
        Optional<Visitor> visitorOptional = visitorRepository.findById(id);
        if (visitorOptional.isPresent()) {
            Visitor visitor = OjaMapper.mapVisitorDo(visitorDto);
            visitor.setId(id);
            visitorRepository.save(visitor);
            return visitorDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<VisitorDto> getAll(String authorization) {
        List<Visitor> doList = (List<Visitor>) visitorRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        visitorRepository.deleteById(id);
    }
}

