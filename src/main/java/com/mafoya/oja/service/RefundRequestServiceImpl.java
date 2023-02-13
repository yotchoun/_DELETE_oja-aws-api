package com.mafoya.oja.service;

import com.mafoya.oja.dto.RefundRequestDto;
import com.mafoya.oja.exception.DataNotFoundException;
import com.mafoya.oja.helper.OjaMapper;
import com.mafoya.oja.model.RefundRequest;
import com.mafoya.oja.repository.RefundRequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RefundRequestServiceImpl  implements RefundRequestService {

    private final RefundRequestRepository refundRequestRepository;

    public RefundRequestServiceImpl(RefundRequestRepository refundRequestRepository) {
        this.refundRequestRepository = refundRequestRepository;
    }

    @Override
    public RefundRequestDto getById(String authorization, String id) {
        RefundRequestDto refundRequestDto;
        Optional<RefundRequest> refundRequestOptional = refundRequestRepository.findById(id);
        if (refundRequestOptional.isPresent()) {
            refundRequestDto = OjaMapper.mapRefundRequestDto(refundRequestOptional.get());
            return refundRequestDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public RefundRequestDto create(String authorization, RefundRequestDto refundRequestDto) {
        RefundRequest refundRequest = OjaMapper.mapRefundRequestDo(refundRequestDto);
        refundRequestRepository.save(refundRequest);
        return refundRequestDto;
    }

    @Override
    public RefundRequestDto update(String authorization, RefundRequestDto refundRequestDto, String id) {
        Optional<RefundRequest> refundRequestOptional = refundRequestRepository.findById(id);
        if (refundRequestOptional.isPresent()) {
            RefundRequest refundRequest = OjaMapper.mapRefundRequestDo(refundRequestDto);
            refundRequest.setId(id);
            refundRequestRepository.save(refundRequest);
            return refundRequestDto;
        }
        throw new DataNotFoundException("Id not found for  " + id);
    }


    @Override
    public List<RefundRequestDto> getAll(String authorization) {
        List<RefundRequest> doList = (List<RefundRequest>) refundRequestRepository.findAll();
        return doList.stream().map(objectDo -> getById(authorization, objectDo.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void delete(String authorization, String id) {
        refundRequestRepository.deleteById(id);
    }
}

