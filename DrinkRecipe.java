
/**
 * Represents a drink recipe.
 *
 * @author Timur Turdaliev
 * @version 1.0
 */
public class DrinkRecipe extends Recipe
{
    private boolean isAlcoholic;
    private boolean servedCold;
    private int volumeMl;

    /**
     * Constructor for DrinkRecipe.
     */
    public DrinkRecipe(String title, String author, int servings, RecipeType type, boolean isAlcoholic, boolean servedCold, int volumeMl)
    {
        super(title, author, servings, type);
        this.isAlcoholic = isAlcoholic;
        this.servedCold = servedCold;
        this.volumeMl = volumeMl;
    }

    public boolean isAlcoholic() { return isAlcoholic; }
    public boolean isServedCold() { return servedCold; }
    public int getVolumeMl() { return volumeMl; }

    @Override
    public String getDetails()
    {
        return "Volume: " + volumeMl + "ml | Alcoholic: " + isAlcoholic + " | Served cold: " + servedCold;
    }
}