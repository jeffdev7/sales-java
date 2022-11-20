package com.jago.dsmeta.controller;

import com.jago.dsmeta.entities.Sale;
import com.jago.dsmeta.services.SaleService;
import com.jago.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService _service;
    @Autowired
    private SmsService _smsService;

    @GetMapping
    public Page<Sale> findSales(@RequestParam(value="minDate", defaultValue = "")
                                    String minDate,
                                @RequestParam(value="maxDate", defaultValue = "")
                                String maxDate,
                                Pageable pageable){
        return _service.findSales(minDate, maxDate, pageable);
    };

    @GetMapping("/{id}/notification")
    public void notifyClient(@PathVariable Long id)
    {
        _smsService.sendSms(id);
    }
}
