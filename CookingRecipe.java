
/**
 * Represents a cooking recipe.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CookingRecipe extends Recipe
{
    private String cookingMethod;
    private int prepMins;
    private int cookMins;

    /**
     * Constructor for CookingRecipe.
     */
    public CookingRecipe(String title, String author, int servings, RecipeType type, String cookingMethod, int prepMins, int cookMins)
    {
        super(title, author, servings, type);
        this.cookingMethod = cookingMethod;
        this.prepMins = prepMins;
        this.cookMins = cookMins;
    }

    public String getCookingMethod() { return cookingMethod; }
    public int getPrepMins() { return prepMins; }
    public int getCookMins() { return cookMins; }

    public int getTotalMins()
    {
        return prepMins + cookMins;
    }

    @Override
    public String getDetails()
    {
        return "Method: " + cookingMethod + " | Prep: " + prepMins + " mins | Cook: " + cookMins + " mins";
    }
}