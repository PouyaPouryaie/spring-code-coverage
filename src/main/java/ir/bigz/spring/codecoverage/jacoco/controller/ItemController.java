package ir.bigz.spring.codecoverage.jacoco.controller;

import ir.bigz.spring.codecoverage.jacoco.service.ItemService;
import ir.bigz.spring.codecoverage.jacoco.view.ItemRequest;
import ir.bigz.spring.codecoverage.jacoco.view.ItemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item/v1")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody ItemRequest itemRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(itemRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllItem(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItem());
    }
}
