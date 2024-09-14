package com.fabio.market.web.controller;

import com.fabio.market.domain.Purchase;
import com.fabio.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "purchases", description = "the purchases API")
@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Purchase All", description = "Get All supermarket purchases.", tags = { "purchases" })
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>>getAll(){
        return  new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Purchase by client", description = "Get Purchase by client id.", tags = { "purchases" })
    @GetMapping("/client/{idClient}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Purchase not found")
    })
    public  ResponseEntity<List<Purchase>>getByClient(@Parameter(description = "The id of the client", required = true, example = "4546221") @PathVariable("idClient") String idClient){
        return purchaseService.getByClient(idClient)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Save purchase", description = "save a purchase", tags = { "purchases" })
    @PostMapping("/save")
    public ResponseEntity<Purchase>save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.OK);
    }

}
