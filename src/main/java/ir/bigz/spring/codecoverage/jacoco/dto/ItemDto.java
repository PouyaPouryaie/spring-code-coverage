package ir.bigz.spring.codecoverage.jacoco.dto;

import ir.bigz.spring.codecoverage.jacoco.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDto extends JpaRepository<Item, String> {

}
