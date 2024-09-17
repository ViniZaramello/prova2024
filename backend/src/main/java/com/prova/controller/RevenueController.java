package com.prova.controller;

import com.prova.controller.dto.RevenueDto;
import com.prova.model.RevenueModel;
import com.prova.service.RevenueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("/revenues")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @PostMapping
    @RequestMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRevenue(@Valid @RequestBody RevenueDto revenueDto) {
        revenueService.createRevenue(revenueDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RevenueModel> getRevenue() {
        return revenueService.getRevenue();
    }
}
