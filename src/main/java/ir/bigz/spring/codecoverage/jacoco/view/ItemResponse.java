package ir.bigz.spring.codecoverage.jacoco.view;

import java.math.BigDecimal;

public class ItemResponse {

    private String id;
    private String itemName;
    private String category;
    private long quantity;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public long getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String itemName;
        private String category;
        private long quantity;
        private BigDecimal price;

        public Builder id(String itemId){
            this.id = itemId;
            return this;
        }

        public Builder itemName(String itemName){
            this.itemName = itemName;
            return this;
        }

        public Builder category(String category){
            this.category = category;
            return this;
        }

        public Builder quantity(long quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder price(BigDecimal price){
            this.price = price;
            return this;
        }

        public ItemResponse build(){
            return new ItemResponse(this);
        }
    }

    public ItemResponse(Builder builder) {
        this.id = builder.id;
        this.itemName = builder.itemName;
        this.category = builder.category;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    @Override
    public String toString() {
        return "ItemResponse{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
