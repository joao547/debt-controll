package com.roctiv.debtcontroll.api.controller;

import com.roctiv.debtcontroll.api.entity.Pagamento;
import com.roctiv.debtcontroll.api.model.PagamentoModel;
import com.roctiv.debtcontroll.api.response.PagamentoResponse;
import com.roctiv.debtcontroll.api.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
@CrossOrigin(origins = "*")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity insert(@RequestBody PagamentoModel pagamentoModel) throws NoSuchAlgorithmException {

        PagamentoResponse response = new PagamentoResponse(this.pagamentoService.create(pagamentoModel));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/dividas/{id}")
    public ResponseEntity listByDivida(@PathVariable Long id) throws NoSuchAlgorithmException {

        List<PagamentoResponse> response = this.getPagamentos(this.pagamentoService.listByDivida(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity listByUser(@PathVariable Long id) throws NoSuchAlgorithmException {

        List<PagamentoResponse> response = this.getPagamentos(this.pagamentoService.listByUser(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mes")
    public ResponseEntity listByUserAndMonth(@RequestHeader Long id, @RequestHeader Integer mes, @RequestHeader Integer ano) throws NoSuchAlgorithmException {

        List<PagamentoResponse> response = this.getPagamentos(this.pagamentoService.listByUserAndMonth(id,mes, ano));
        return ResponseEntity.ok(response);
    }

    private List<PagamentoResponse> getPagamentos(List<Pagamento> pagamentos){
        List<PagamentoResponse> pagamentoResponses = new ArrayList<>();
        for(Pagamento pagamento : pagamentos){
            pagamentoResponses.add(new PagamentoResponse(pagamento));
        }
        return pagamentoResponses;
    }
}
