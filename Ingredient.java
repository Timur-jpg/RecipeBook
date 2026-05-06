
/**
 * Represents an ingredient in a recipe.

 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ingredient
{
    private String name;
    private double quantity;
    private String unit;

    /**
     * Constructor for Ingredient.
     */
    public Ingredient(String name, double quantity, String unit)
    {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() { return name; }
    public double getQuantity() { return quantity; }
    public String getUnit() { return unit; }

    /**
     * Scales the ingredient by a factor.
     */
    public void scale(double factor)
    {
        quantity = quantity * factor;
    }

    @Override
    public String toString()
    {
        return quantity + " " + unit + " of " + name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Ingredient)) return false;
        Ingredient i = (Ingredient) o;
        return name.equals(i.name);
    }
}