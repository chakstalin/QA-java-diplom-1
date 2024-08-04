import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static final int EXPECTED_INGREDIENT_COUNT = 1;
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        when(bun.getName()).thenReturn("mock bun");
        when(bun.getPrice()).thenReturn(50f);
        when(ingredient.getName()).thenReturn("mock ingredient");
        when(ingredient.getPrice()).thenReturn(25f);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void testSetBunsValidBunShouldSetBun() {
        burger.setBuns(bun);

        assertEquals("Булочка не была установлена корректно", bun, burger.bun);
    }

    @Test
    public void testAddIngredientValidIngredientShouldAddIngredient() {
        burger.addIngredient(ingredient);

        assertEquals("Ингредиент не был добавлен", EXPECTED_INGREDIENT_COUNT, burger.ingredients.size());
        assertEquals("Ингредиент не соответствует ожидаемому", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredientValidIndexShouldRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertEquals("Ингредиент не был удален", 0, burger.ingredients.size());
    }

    @Test
    public void testGetPriceValidBurgerShouldReturnPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = (bun.getPrice() * 2) + ingredient.getPrice();

        assertEquals("Цена бургера не соответствует ожидаемой", expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceiptValidBurgerShouldReturnReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt = "(==== mock bun ====)\r\n" + "= sauce mock ingredient =\r\n" + "(==== mock bun ====)\r\n\r" + "\nPrice: 125,000000\r\n";

        assertEquals("Чек не соответствует ожидаемому", expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testGetReceiptEmptyIngredientShouldReturnReceipt() {
        burger.setBuns(bun);
        String expectedReceipt = "(==== mock bun ====)\r\n" + "(==== mock bun ====)\r\n\r" + "\nPrice: 100,000000\r\n";

        assertEquals("Чек бургера без ингредиента не соответствует ожидаемому", expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testMoveIngredientValidIndicesShouldMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);

        assertEquals("Ингредиенты не были перемещены корректно", ingredient2, burger.ingredients.get(0));
        assertEquals("Ингредиенты не были перемещены корректно", ingredient, burger.ingredients.get(1));
    }
}
