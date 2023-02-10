package com.mafoya.oja.service;

import com.mafoya.oja.model.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerService {
    Seller create(String authorization, Seller seller);

    Seller update(String authorization, Seller seller, String id);

    Optional<Seller> getById(String authorization, String id);

    List<Seller> getAll(String authorization);

    void delete(String authorization, String id);
}
