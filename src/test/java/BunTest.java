import praktikum.Bun;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private int bunPrice = 123;
    private String bunName = "test bun";


    @Test
    public void testGetNameValidBunShouldReturnName() {
        bun = new Bun(bunName, bunPrice);

        assertEquals("Название булочки не соответствует ожидаемому", bunName, bun.getName());
    }

    @Test
    public void testGetPriceValidBunShouldReturnPrice() {
        bun = new Bun(bunName, bunPrice);

        assertEquals("Цена булочки не соответствует ожидаемой", bunPrice, bun.getPrice(), 0);
    }
}
