package com.roctiv.debtcontroll.api.controller;

import com.roctiv.debtcontroll.api.entity.Divida;
import com.roctiv.debtcontroll.api.entity.User;
import com.roctiv.debtcontroll.api.model.DividaModel;
import com.roctiv.debtcontroll.api.response.DividaResponse;
import com.roctiv.debtcontroll.api.response.UserResponse;
import com.roctiv.debtcontroll.api.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dividas")
@CrossOrigin(origins = "*")
public class DividaController {

    @Autowired
    private DividaService dividaService;

    @PostMapping
    public ResponseEntity insert(@RequestBody DividaModel dividaModel) throws NoSuchAlgorithmException {

        DividaResponse response = new DividaResponse(this.dividaService.create(dividaModel));

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DividaResponse>> listByUser(@RequestHeader String username) throws NoSuchAlgorithmException {
        List<DividaResponse> response = this.getDividas(this.dividaService.listByUser(username));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity listById(@PathVariable Long id) throws NoSuchAlgorithmException {
        DividaResponse response = new DividaResponse(this.dividaService.listById(id));
        return ResponseEntity.ok(response);
    }

    private List<DividaResponse> getDividas(List<Divida> dividas){
        List<DividaResponse> dividaResponses = new ArrayList<>();
        for(Divida divida : dividas){
            dividaResponses.add(new DividaResponse(divida));
        }
        return dividaResponses;
    }
}
