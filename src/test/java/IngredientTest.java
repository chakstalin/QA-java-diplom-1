import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;
    private int ingredientPrice = 123;
    private String ingredientName = "test filling";

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, ingredientName, ingredientPrice);
    }

    @Test
    public void testGetNameValidIngredientShouldReturnName() {
        assertEquals("Название ингредиента не соответствует ожидаемому", ingredientName, ingredient.getName());
    }

    @Test
    public void testGetPriceValidIngredientShouldReturnPrice() {
        assertEquals("Цена ингредиента не соответствует ожидаемой", ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetTypeValidIngredientShouldReturnType() {
        assertEquals("Тип ингредиента не соответствует ожидаемому", IngredientType.FILLING, ingredient.getType());
    }
}
