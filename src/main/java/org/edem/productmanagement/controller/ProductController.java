package org.edem.productmanagement.controller;

import org.edem.productmanagement.dto.CreateProductRequest;
import org.edem.productmanagement.dto.ProductResponse;
import org.edem.productmanagement.dto.UpdateProductRequest;
import org.edem.productmanagement.entities.Product;
import org.edem.productmanagement.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new-product")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request){
        productService.createProduct(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Page<ProductResponse> getProducts(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size){

        return productService.getAllProducts(page,size);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long id , @RequestBody UpdateProductRequest request){
        productService.updateProduct(id,request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

