package com.prova.controller;

import com.prova.controller.dto.RevenueDto;
import com.prova.mapper.RevenueMapper;
import com.prova.model.RevenueModel;
import com.prova.service.RevenueService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        revenueService.createRevenue(RevenueMapper.toModel(revenueDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RevenueModel> getAllRevenues() {
        return revenueService.getAllRevenues();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping("/update/{id}")
    public void updateRevenue(@PathVariable Long id, @Valid @RequestBody RevenueDto revenueDto) {
        revenueService.updateRevenue(RevenueMapper.toModel(revenueDto), id);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRevenue(@PathVariable Long id) {
        revenueService.deleteRevenue(id);
    }
}
