import java.util.ArrayList;
/**
 * Abstract class representing a recipe.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Recipe
{
    private String title;
    private String author;
    private int servings;
    private RecipeType type;
    private ArrayList<Tag> tags;    
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Step> steps;
    private ArrayList<Integer> ratings;
    private static int recipeCount = 0;

    /**
     * Constructor for Recipe.
     */
    public Recipe(String title, String author, int servings, RecipeType type)
    {
        this.title = title;
        this.author = author;
        this.servings = servings;
        this.type = type;
        this.tags = new ArrayList<Tag>();
        this.ingredients = new ArrayList<Ingredient>();
        this.steps = new ArrayList<Step>();
        this.ratings = new ArrayList<Integer>();
        recipeCount++;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getServings() { return servings; }
    public RecipeType getType() { return type; }
    public ArrayList<Ingredient> getIngredients() { return ingredients; }
    public ArrayList<Step> getSteps() { return steps; }
    public static int getRecipeCount() { return recipeCount; }

    public void addIngredient(Ingredient i) { ingredients.add(i); }
    public void addStep(Step s) { steps.add(s); }
    public void addTag(Tag t) { tags.add(t); }

    /**
     * Rates the recipe with a score from 1 to 5.
     */
    public void rate(int score)
    {
        if (score >= 1 && score <= 5)
            ratings.add(score);
    }

    /**
     * Returns the average rating of the recipe.
     */
    public double getAverageRating()
    {
        if (ratings.size() == 0) return 0;
        int sum = 0;
        for (int r : ratings) sum += r;
        return (double) sum / ratings.size();
    }

    /**
     * Scales the recipe to a new number of servings.
     */
    public void scale(int newServings)
    {
        double factor = (double) newServings / servings;
        for (Ingredient i : ingredients)
            i.scale(factor);
        servings = newServings;
    }

    public boolean hasIngredient(String name)
    {
        for (Ingredient i : ingredients)
            if (i.getName().equalsIgnoreCase(name)) return true;
        return false;
    }

    public boolean hasTag(Tag tag)
    {
        return tags.contains(tag);
    }

    public abstract String getDetails();

    @Override
    public String toString()
    {
        return title + " by " + author + " (" + type + ") - Rating: " + getAverageRating();
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Recipe)) return false;
        Recipe r = (Recipe) o;
        return title.equals(r.title) && author.equals(r.author);
    }
}