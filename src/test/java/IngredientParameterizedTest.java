import praktikum.IngredientType;
import praktikum.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {IngredientType.FILLING, "valid filling", 321},
                {IngredientType.SAUCE, "valid sauce", 123},
                {IngredientType.SAUCE, "", 0},
                {IngredientType.FILLING, "not valid filling", -1}
        };
    }

    @Test
    public void testIngredientValidParametersShouldCreateIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals("Тип ингредиента не соответствует ожидаемому", type, ingredient.getType());
        assertEquals("Название ингредиента не соответствует ожидаемому", name, ingredient.getName());
        assertEquals("Цена ингредиента не соответствует ожидаемой", price, ingredient.getPrice(), 0);
    }

    @Test
    public void testIngredientLessThanZeroPriceShouldntLessThanZero() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertTrue("Цена ингредиента принимает отрицательные значения",ingredient.getPrice() >= 0);
    }

    @Test
    public void testIngredientEmptyStringNameCantBeEmpty() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertNotEquals("Название ингредиента принимает пустую строку", "", ingredient.getName());
    }
}
