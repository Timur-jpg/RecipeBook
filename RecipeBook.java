import java.util.ArrayList;
/**
 * Represents a recipe book containing multiple recipes.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeBook
{
    private String title;
    private String author;
    private ArrayList<Recipe> recipes;
    
    /**
     * Constructor for RecipeBook.
     */
    public RecipeBook(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.recipes = new ArrayList<Recipe>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public ArrayList<Recipe> getRecipes() { return recipes; }

    public void addRecipe(Recipe r)
    {
        recipes.add(r);
    }

    /**
     * Lists all recipes in the book.
     */
    public void listAll()
    {
        for (Recipe r : recipes)
            System.out.println(r);
    }

    /**
     * Lists recipes by type.
     */
    public void listByType(RecipeType type)
    {
        for (Recipe r : recipes)
            if (r.getType() == type)
                System.out.println(r);
    }

    /**
     * Searches recipes by title keyword.
     */
    public void searchByTitle(String keyword)
    {
        for (Recipe r : recipes)
            if (r.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                System.out.println(r);
    }

    /**
     * Searches recipes by ingredient name.
     */
    public void searchByIngredient(String name)
    {
        for (Recipe r : recipes)
            if (r.hasIngredient(name))
                System.out.println(r);
    }

    /**
     * Searches recipes by tag.
     */
    public void searchByTag(Tag tag)
    {
        for (Recipe r : recipes)
            if (r.hasTag(tag))
                System.out.println(r);
    }

    /**
     * Prints details of the recipe book.
     */
    public void printDetails()
    {
        System.out.println("Book: " + title + " by " + author);
        System.out.println("Total recipes: " + recipes.size());
    }

    /**
     * Lists top n rated recipes.
     */
    public void getTopRated(int n)
    {
        ArrayList<Recipe> sorted = new ArrayList<Recipe>(recipes);
        for (int i = 0; i < sorted.size() - 1; i++)
            for (int j = i + 1; j < sorted.size(); j++)
                if (sorted.get(j).getAverageRating() > sorted.get(i).getAverageRating())
                {
                    Recipe temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
        for (int i = 0; i < n && i < sorted.size(); i++)
            System.out.println(sorted.get(i));
    }
}