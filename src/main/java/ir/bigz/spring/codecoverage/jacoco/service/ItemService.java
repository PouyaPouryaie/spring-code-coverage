package ir.bigz.spring.codecoverage.jacoco.service;

import ir.bigz.spring.codecoverage.jacoco.dto.ItemDto;
import ir.bigz.spring.codecoverage.jacoco.entities.Item;
import ir.bigz.spring.codecoverage.jacoco.view.ItemRequest;
import ir.bigz.spring.codecoverage.jacoco.view.ItemResponse;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemDto itemDto;

    public ItemService(ItemDto itemDto) {
        this.itemDto = itemDto;
    }

    public ItemResponse createItem(ItemRequest itemRequest) {

        Item item = new Item();
        item.setItemName(itemRequest.getItemName());
        item.setQuantity(itemRequest.getQuantity());
        item.setPrice(itemRequest.getPrice());

        if (itemRequest.getCategory() != null && !itemRequest.getCategory().equals("")) {
            item.setCategory(itemRequest.getCategory());
        }

        itemDto.save(item);

        return ItemResponse.builder()
                .id(item.getId())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .itemName(item.getItemName())
                .category(item.getCategory()).build();
    }
}
