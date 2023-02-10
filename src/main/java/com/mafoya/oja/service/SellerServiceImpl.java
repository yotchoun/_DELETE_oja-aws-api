package com.mafoya.oja.service;

import com.mafoya.oja.model.Seller;
import com.mafoya.oja.repository.SellerRepository;

import java.util.List;
import java.util.Optional;

public class SellerServiceImpl  implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller create(String authorization, Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller update(String authorization, Seller seller, String id) {
        return sellerRepository.save(seller);
    }

    @Override
    public Optional<Seller> getById(String authorization, String id) {
        return sellerRepository.findById(id);
    }

    @Override
    public List<Seller> getAll(String authorization) {
        return (List<Seller>) sellerRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        sellerRepository.deleteById(id);
    }
}

