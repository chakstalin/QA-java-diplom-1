import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testIngredientTypeSauceTypeHasCorrectName() {
        assertEquals("Тип ингредиента не соответствует ожидаемому", "SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testIngredientTypeFillingTypeHasCorrectName() {
        assertEquals("Тип ингредиента не соответствует ожидаемому", "FILLING", IngredientType.FILLING.name());
    }
}
