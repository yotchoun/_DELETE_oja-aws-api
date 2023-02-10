package com.mafoya.oja.service;

import com.mafoya.oja.model.RecentPurchase;
import com.mafoya.oja.repository.RecentPurchaseRepository;

import java.util.List;
import java.util.Optional;

public class RecentPurchaseServiceImpl  implements RecentPurchaseService {

    private final RecentPurchaseRepository recentPurchaseRepository;

    public RecentPurchaseServiceImpl(RecentPurchaseRepository recentPurchaseRepository) {
        this.recentPurchaseRepository = recentPurchaseRepository;
    }

    @Override
    public RecentPurchase create(String authorization, RecentPurchase recentPurchase) {
        return recentPurchaseRepository.save(recentPurchase);
    }

    @Override
    public RecentPurchase update(String authorization, RecentPurchase recentPurchase, String id) {
        return recentPurchaseRepository.save(recentPurchase);
    }

    @Override
    public Optional<RecentPurchase> getById(String authorization, String id) {
        return recentPurchaseRepository.findById(id);
    }

    @Override
    public List<RecentPurchase> getAll(String authorization) {
        return (List<RecentPurchase>) recentPurchaseRepository.findAll();
    }

    @Override
    public void delete(String authorization, String id) {
        recentPurchaseRepository.deleteById(id);
    }
}

