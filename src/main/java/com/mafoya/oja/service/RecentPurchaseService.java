package com.mafoya.oja.service;

import com.mafoya.oja.model.RecentPurchase;

import java.util.List;
import java.util.Optional;

public interface RecentPurchaseService {
    RecentPurchase create(String authorization, RecentPurchase recentPurchase);

    RecentPurchase update(String authorization, RecentPurchase recentPurchase, String id);

    Optional<RecentPurchase> getById(String authorization, String id);

    List<RecentPurchase> getAll(String authorization);

    void delete(String authorization, String id);
}
