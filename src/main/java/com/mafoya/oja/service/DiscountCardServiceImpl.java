package com.mafoya.oja.service;

import com.mafoya.oja.dto.DiscountCardDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.DiscountCard;
import com.mafoya.oja.model.DiscountCard;
import com.mafoya.oja.repository.DiscountCardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiscountCardServiceImpl  implements DiscountCardService {

    private final DiscountCardRepository discountCardRepository;

    public DiscountCardServiceImpl(DiscountCardRepository discountCardRepository) {
        this.discountCardRepository = discountCardRepository;
    }

    @Override
    public DiscountCardDto getById(String authorization, String id) {
        DiscountCardDto discountCardDto;
        Optional<DiscountCard> discountCardOptional = discountCardRepository.findById(id);
        if (discountCardOptional.isPresent()) {
            discountCardDto = OjaMapper.mapDiscountCardDto(discountCardOptional.get());
            return discountCardDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public DiscountCardDto create(String authorization, DiscountCardDto discountCardDto) {
        DiscountCard discountCard = OjaMapper.mapDiscountCardDo(discountCardDto);
        discountCardRepository.save(discountCard);
        return discountCardDto;
    }

    @Override
    public DiscountCardDto update(String authorization, DiscountCardDto discountCardDto, String id) {
        Optional<DiscountCard> discountCardOptional = discountCardRepository.findById(id);
        if (discountCardOptional.isPresent()) {
            DiscountCard discountCard = OjaMapper.mapDiscountCardDo(discountCardDto);
            discountCard.setId(id);
            discountCardRepository.save(discountCard);
            return discountCardDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<DiscountCardDto> getAll(String authorization) {
        List<DiscountCard> doList = (List<DiscountCard>) discountCardRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        discountCardRepository.deleteById(id);
    }
}

