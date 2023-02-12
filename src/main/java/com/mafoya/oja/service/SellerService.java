package com.mafoya.oja.service;

import com.mafoya.oja.dto.SellerDto;

import java.util.List;

public interface SellerService {
    SellerDto create(String authorization, SellerDto sellerDto);

    SellerDto update(String authorization, SellerDto sellerDto, String id);

    SellerDto getById(String authorization, String id);

    List<SellerDto> getAll(String authorization);

    void delete(String authorization, String id);
}
