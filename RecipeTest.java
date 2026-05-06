import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class RecipeTest.
 *
 * @author  Timur Turdaliev
 * @version 1.0
 */
public class RecipeTest
{
     @Test
    public void testRate()
    {
        BakingRecipe r = new BakingRecipe("Cake", "Tim", 4, RecipeType.DESSERT, 180, 30);
        r.rate(5);
        assertEquals(5.0, r.getAverageRating(), 0.01);
    }

    @Test
    public void testRateInvalid()
    {
        BakingRecipe r = new BakingRecipe("Cake", "Tim", 4, RecipeType.DESSERT, 180, 30);
        r.rate(10);
        assertEquals(0.0, r.getAverageRating(), 0.01);
    }

    @Test
    public void testGetAverageRating()
    {
        BakingRecipe r = new BakingRecipe("Cake", "Tim", 4, RecipeType.DESSERT, 180, 30);
        r.rate(4);
        r.rate(2);
        assertEquals(3.0, r.getAverageRating(), 0.01);
    }

    @Test
    public void testScale()
    {
        BakingRecipe r = new BakingRecipe("Cake", "Tim", 4, RecipeType.DESSERT, 180, 30);
        Ingredient i = new Ingredient("Flour", 200, "g");
        r.addIngredient(i);
        r.scale(8);
        assertEquals(400.0, r.getIngredients().get(0).getQuantity(), 0.01);
    }

    @Test
    public void testToString()
    {
        BakingRecipe r = new BakingRecipe("Cake", "Tim", 4, RecipeType.DESSERT, 180, 30);
        assertTrue(r.toString().contains("Cake"));
    }

    @Test
    public void testEquals()
    {
        BakingRecipe r1 = new BakingRecipe("Cake", "Tim", 4, RecipeType.DESSERT, 180, 30);
        BakingRecipe r2 = new BakingRecipe("Cake", "Tim", 4, RecipeType.DESSERT, 180, 30);
        assertTrue(r1.equals(r2));
    }
}