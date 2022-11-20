package com.jago.dsmeta.services;

import com.jago.dsmeta.entities.Sale;
import com.jago.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository _repository;

    public List<Sale> findSales(){
      return _repository.findAll();
    };
}
