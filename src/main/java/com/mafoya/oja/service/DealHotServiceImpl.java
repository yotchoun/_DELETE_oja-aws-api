package com.mafoya.oja.service;

import com.mafoya.oja.dto.DealHotDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.DealHot;
import com.mafoya.oja.repository.DealHotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DealHotServiceImpl  implements DealHotService {

    private final DealHotRepository dealHotRepository;

    public DealHotServiceImpl(DealHotRepository dealHotRepository) {
        this.dealHotRepository = dealHotRepository;
    }

    @Override
    public DealHotDto getById(String authorization, String id) {
        DealHotDto dealHotDto;
        Optional<DealHot> dealHotOptional = dealHotRepository.findById(id);
        if (dealHotOptional.isPresent()) {
            dealHotDto = OjaMapper.mapDealHotDto(dealHotOptional.get());
            return dealHotDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public DealHotDto create(String authorization, DealHotDto dealHotDto) {
        DealHot dealHot = OjaMapper.mapDealHotDo(dealHotDto);
        dealHotRepository.save(dealHot);
        return dealHotDto;
    }

    @Override
    public DealHotDto update(String authorization, DealHotDto dealHotDto, String id) {
        Optional<DealHot> dealHotOptional = dealHotRepository.findById(id);
        if (dealHotOptional.isPresent()) {
            DealHot dealHot = OjaMapper.mapDealHotDo(dealHotDto);
            dealHot.setId(id);
            dealHotRepository.save(dealHot);
            return dealHotDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<DealHotDto> getAll(String authorization) {
        List<DealHot> doList = (List<DealHot>) dealHotRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        dealHotRepository.deleteById(id);
    }
}

