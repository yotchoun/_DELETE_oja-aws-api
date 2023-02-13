package com.mafoya.oja.service;

import com.mafoya.oja.dto.SellerDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.Seller;
import com.mafoya.oja.repository.SellerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SellerServiceImpl  implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerDto getById(String authorization, String id) {
        SellerDto sellerDto;
        Optional<Seller> sellerOptional = sellerRepository.findById(id);
        if (sellerOptional.isPresent()) {
            sellerDto = OjaMapper.mapSellerDto(sellerOptional.get());
            return sellerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public SellerDto create(String authorization, SellerDto sellerDto) {
        Seller seller = OjaMapper.mapSellerDo(sellerDto);
        sellerRepository.save(seller);
        return sellerDto;
    }

    @Override
    public SellerDto update(String authorization, SellerDto sellerDto, String id) {
        Optional<Seller> sellerOptional = sellerRepository.findById(id);
        if (sellerOptional.isPresent()) {
            Seller seller = OjaMapper.mapSellerDo(sellerDto);
            seller.setId(id);
            sellerRepository.save(seller);
            return sellerDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<SellerDto> getAll(String authorization) {
        List<Seller> doList = (List<Seller>) sellerRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        sellerRepository.deleteById(id);
    }
}

