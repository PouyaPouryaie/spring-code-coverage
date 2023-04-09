package ir.bigz.spring.codecoverage;

import ir.bigz.spring.codecoverage.jacoco.Messages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMessages {

    @Test
    public void testNameDailyCodeBuffer(){
        Messages messages = new Messages();
        Assertions.assertEquals("Hello Daily CodeBuffer!", messages.getMessage("Daily CodeBuffer"));
    }

    @Test
    public void testNameBlank(){
        Messages messages = new Messages();
        Assertions.assertEquals("Please provide Name!", messages.getMessage(""));
    }

    @Test
    public void testNameNull(){
        Messages messages = new Messages();
        Assertions.assertEquals("Please provide Name!", messages.getMessage(null));
    }
}
