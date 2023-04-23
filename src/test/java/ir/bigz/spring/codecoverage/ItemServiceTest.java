package ir.bigz.spring.codecoverage;

import com.github.javafaker.Faker;
import ir.bigz.spring.codecoverage.jacoco.dto.ItemDto;
import ir.bigz.spring.codecoverage.jacoco.service.ItemService;
import ir.bigz.spring.codecoverage.jacoco.view.ItemRequest;
import ir.bigz.spring.codecoverage.jacoco.view.ItemResponse;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = {"classpath:application.yml"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DataJpaTest
public class ItemServiceTest {

    @Autowired
    private ItemDto itemDto;

    private ItemService itemService;

    private Faker faker = new Faker();

    @BeforeAll
    void setUp(){
        itemService = new ItemService(itemDto);
    }

    @Test
    @Rollback(value = false)
    public void add_item_into_database(){

        //given
        ItemRequest itemRequest = new ItemRequest("Item Mobile", "mobile", 10, new BigDecimal("10.000"));

        //when
        ItemResponse item = itemService.createItem(itemRequest);

        //then
        Assertions.assertNotNull(item.getId());
    }
}
