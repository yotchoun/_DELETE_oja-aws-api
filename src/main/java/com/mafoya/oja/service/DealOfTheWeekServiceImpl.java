package com.mafoya.oja.service;

import com.mafoya.oja.dto.DealOfTheWeekDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.DealOfTheWeek;
import com.mafoya.oja.repository.DealOfTheWeekRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DealOfTheWeekServiceImpl  implements DealOfTheWeekService {

    private final DealOfTheWeekRepository dealOfTheWeekRepository;

    public DealOfTheWeekServiceImpl(DealOfTheWeekRepository dealOfTheWeekRepository) {
        this.dealOfTheWeekRepository = dealOfTheWeekRepository;
    }

    @Override
    public DealOfTheWeekDto getById(String authorization, String id) {
        DealOfTheWeekDto dealOfTheWeekDto;
        Optional<DealOfTheWeek> dealOfTheWeekOptional = dealOfTheWeekRepository.findById(id);
        if (dealOfTheWeekOptional.isPresent()) {
            dealOfTheWeekDto = OjaMapper.mapDealOfTheWeekDto(dealOfTheWeekOptional.get());
            return dealOfTheWeekDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public DealOfTheWeekDto create(String authorization, DealOfTheWeekDto dealOfTheWeekDto) {
        DealOfTheWeek dealOfTheWeek = OjaMapper.mapDealOfTheWeekDo(dealOfTheWeekDto);
        dealOfTheWeekRepository.save(dealOfTheWeek);
        return dealOfTheWeekDto;
    }

    @Override
    public DealOfTheWeekDto update(String authorization, DealOfTheWeekDto dealOfTheWeekDto, String id) {
        Optional<DealOfTheWeek> dealOfTheWeekOptional = dealOfTheWeekRepository.findById(id);
        if (dealOfTheWeekOptional.isPresent()) {
            DealOfTheWeek dealOfTheWeek = OjaMapper.mapDealOfTheWeekDo(dealOfTheWeekDto);
            dealOfTheWeek.setId(id);
            dealOfTheWeekRepository.save(dealOfTheWeek);
            return dealOfTheWeekDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<DealOfTheWeekDto> getAll(String authorization) {
        List<DealOfTheWeek> doList = (List<DealOfTheWeek>) dealOfTheWeekRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        dealOfTheWeekRepository.deleteById(id);
    }
}

