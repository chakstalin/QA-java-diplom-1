import praktikum.Bun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private String name;
    private float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {"", 0},
                {"not valid bun", -1}
        };
    }

    @Test
    public void testBunNotValidParametersShouldntCreateBun() {
        Bun bun = new Bun(name, price);

        assertTrue("Цена булочки принимает отрицательные значения",bun.getPrice() >= 0);
        assertNotEquals("Название булочки принимает пустую строку", "", bun.getName());
        }
    }
