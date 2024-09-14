package com.fabio.market.web.controller;

import com.fabio.market.domain.Product;
import com.fabio.market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
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
import java.util.Optional;

@Tag(name = "products", description = "the product API")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Product All", description = "Get All supermarket products.", tags = { "products" })
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Search Product", description = "Search a product an ID", tags = { "products" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OKI"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@Parameter(description = "The id of the product", required = true, example = "7") @PathVariable("productId") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Products by category", description = "List all products in a category", tags = { "products" })
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@Parameter(description = "The id of the category", required = true, example = "1") @PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Save product", description = "save a product", tags = { "products" })
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody  Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @Operation(summary = "Delete products", description = "Delete a product by ID", tags = { "products" })
    @DeleteMapping("/delete/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity delete(@Parameter(description = "The id of the product", required = true, example = "1") @PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
