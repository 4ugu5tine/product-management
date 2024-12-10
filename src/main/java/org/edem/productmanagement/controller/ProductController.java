package org.edem.productmanagement.controller;

import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.product.CreateProductRequest;
import org.edem.productmanagement.dto.product.ProductResponse;
import org.edem.productmanagement.dto.product.UpdateProductRequest;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createProduct(@RequestBody CreateProductRequest request){
        return productService.createProduct(request);
    }

    @GetMapping("/all")
    public Page<ProductResponse> getProducts(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size){

        return productService.getAllProducts(page,size);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage updateProduct(@PathVariable("id") Long id , @RequestBody UpdateProductRequest request){
        return productService.updateProduct(id,request);
    }



    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/{keyword}")
    public Page<ProductResponse> search(
            @PathVariable("keyword") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        return productService.search(keyword,page,size);
    }
}


