
/**
 * Represents a baking recipe.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BakingRecipe extends Recipe
{
    private int ovenTemp;
    private int bakingMins;

    /**
     * Constructor for BakingRecipe.
     */
    public BakingRecipe(String title, String author, int servings, RecipeType type, int ovenTemp, int bakingMins)
    {
        super(title, author, servings, type);
        this.ovenTemp = ovenTemp;
        this.bakingMins = bakingMins;
    }

    public int getOvenTemp() { return ovenTemp; }
    public int getBakingMins() { return bakingMins; }

    public int getTempFahrenheit()
    {
        return (ovenTemp * 9 / 5) + 32;
    }

    @Override
    public String getDetails()
    {
        return "Oven: " + ovenTemp + "C for " + bakingMins + " minutes";
    }
}