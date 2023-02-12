package com.mafoya.oja.service;

import com.mafoya.oja.dto.DiscountOfferDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.DiscountOffer;
import com.mafoya.oja.model.DiscountOffer;
import com.mafoya.oja.repository.DiscountOfferRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiscountOfferServiceImpl  implements DiscountOfferService {

    private final DiscountOfferRepository discountOfferRepository;

    public DiscountOfferServiceImpl(DiscountOfferRepository discountOfferRepository) {
        this.discountOfferRepository = discountOfferRepository;
    }

    @Override
    public DiscountOfferDto getById(String authorization, String id) {
        DiscountOfferDto discountOfferDto;
        Optional<DiscountOffer> discountOfferOptional = discountOfferRepository.findById(id);
        if (discountOfferOptional.isPresent()) {
            discountOfferDto = OjaMapper.mapDiscountOfferDto(discountOfferOptional.get());
            return discountOfferDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public DiscountOfferDto create(String authorization, DiscountOfferDto discountOfferDto) {
        DiscountOffer discountOffer = OjaMapper.mapDiscountOfferDo(discountOfferDto);
        discountOfferRepository.save(discountOffer);
        return discountOfferDto;
    }

    @Override
    public DiscountOfferDto update(String authorization, DiscountOfferDto discountOfferDto, String id) {
        Optional<DiscountOffer> discountOfferOptional = discountOfferRepository.findById(id);
        if (discountOfferOptional.isPresent()) {
            DiscountOffer discountOffer = OjaMapper.mapDiscountOfferDo(discountOfferDto);
            discountOffer.setId(id);
            discountOfferRepository.save(discountOffer);
            return discountOfferDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<DiscountOfferDto> getAll(String authorization) {
        List<DiscountOffer> doList = (List<DiscountOffer>) discountOfferRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        discountOfferRepository.deleteById(id);
    }
}

