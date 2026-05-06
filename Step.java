
/**
 * Represents a step in a recipe.
 *
 * @author Timur Turdaliev
 * @version 1.0
 */
public class Step
{
    private int stepNumber;
    private String description;

    /**
     * Constructor for Step.
     */
    public Step(int stepNumber, String description)
    {
        this.stepNumber = stepNumber;
        this.description = description;
    }

    public int getStepNumber() { return stepNumber; }
    public String getDescription() { return description; }

    @Override
    public String toString()
    {
        return "Step " + stepNumber + ": " + description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Step)) return false;
        Step s = (Step) o;
        return stepNumber == s.stepNumber;
    }
}