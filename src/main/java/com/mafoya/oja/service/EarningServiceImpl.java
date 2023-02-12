package com.mafoya.oja.service;

import com.mafoya.oja.dto.EarningDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Earning;
import com.mafoya.oja.model.Earning;
import com.mafoya.oja.repository.EarningRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EarningServiceImpl  implements EarningService {

    private final EarningRepository earningRepository;

    public EarningServiceImpl(EarningRepository earningRepository) {
        this.earningRepository = earningRepository;
    }

    @Override
    public EarningDto getById(String authorization, String id) {
        EarningDto earningDto;
        Optional<Earning> earningOptional = earningRepository.findById(id);
        if (earningOptional.isPresent()) {
            earningDto = OjaMapper.mapEarningDto(earningOptional.get());
            return earningDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public EarningDto create(String authorization, EarningDto earningDto) {
        Earning earning = OjaMapper.mapEarningDo(earningDto);
        earningRepository.save(earning);
        return earningDto;
    }

    @Override
    public EarningDto update(String authorization, EarningDto earningDto, String id) {
        Optional<Earning> earningOptional = earningRepository.findById(id);
        if (earningOptional.isPresent()) {
            Earning earning = OjaMapper.mapEarningDo(earningDto);
            earning.setId(id);
            earningRepository.save(earning);
            return earningDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<EarningDto> getAll(String authorization) {
        List<Earning> doList = (List<Earning>) earningRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        earningRepository.deleteById(id);
    }
}

