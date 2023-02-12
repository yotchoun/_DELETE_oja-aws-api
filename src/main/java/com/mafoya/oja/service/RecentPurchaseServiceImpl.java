package com.mafoya.oja.service;

import com.mafoya.oja.dto.RecentPurchaseDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.RecentPurchase;
import com.mafoya.oja.model.RecentPurchase;
import com.mafoya.oja.repository.RecentPurchaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecentPurchaseServiceImpl  implements RecentPurchaseService {

    private final RecentPurchaseRepository recentPurchaseRepository;

    public RecentPurchaseServiceImpl(RecentPurchaseRepository recentPurchaseRepository) {
        this.recentPurchaseRepository = recentPurchaseRepository;
    }

    @Override
    public RecentPurchaseDto getById(String authorization, String id) {
        RecentPurchaseDto recentPurchaseDto;
        Optional<RecentPurchase> recentPurchaseOptional = recentPurchaseRepository.findById(id);
        if (recentPurchaseOptional.isPresent()) {
            recentPurchaseDto = OjaMapper.mapRecentPurchaseDto(recentPurchaseOptional.get());
            return recentPurchaseDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public RecentPurchaseDto create(String authorization, RecentPurchaseDto recentPurchaseDto) {
        RecentPurchase recentPurchase = OjaMapper.mapRecentPurchaseDo(recentPurchaseDto);
        recentPurchaseRepository.save(recentPurchase);
        return recentPurchaseDto;
    }

    @Override
    public RecentPurchaseDto update(String authorization, RecentPurchaseDto recentPurchaseDto, String id) {
        Optional<RecentPurchase> recentPurchaseOptional = recentPurchaseRepository.findById(id);
        if (recentPurchaseOptional.isPresent()) {
            RecentPurchase recentPurchase = OjaMapper.mapRecentPurchaseDo(recentPurchaseDto);
            recentPurchase.setId(id);
            recentPurchaseRepository.save(recentPurchase);
            return recentPurchaseDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<RecentPurchaseDto> getAll(String authorization) {
        List<RecentPurchase> doList = (List<RecentPurchase>) recentPurchaseRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        recentPurchaseRepository.deleteById(id);
    }
}

