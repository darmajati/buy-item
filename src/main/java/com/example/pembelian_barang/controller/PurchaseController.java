package com.example.pembelian_barang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pembelian_barang.model.Item;
import com.example.pembelian_barang.service.PurchaseService;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/best-combination")
    public ResponseEntity<List<Item>> getBestCombination(@RequestParam("budget") int budget) {
        List<Item> bestCombination = purchaseService.findBestCombination(budget);
        return ResponseEntity.ok(bestCombination);
    }
}
