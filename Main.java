import java.util.Scanner;
/**
 * Driver class for the Recipe Book application.
 *
 * @author Timur Turdaliev
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        RecipeBook book = new RecipeBook("My Recipe Book", "Timur");

        // Add some sample recipes
        BakingRecipe r1 = new BakingRecipe("Chocolate Cake", "Timur", 8, RecipeType.DESSERT, 180, 45);
        r1.addIngredient(new Ingredient("Flour", 200, "g"));
        r1.addIngredient(new Ingredient("Sugar", 150, "g"));
        r1.addTag(Tag.VEGETARIAN);
        book.addRecipe(r1);

        CookingRecipe r2 = new CookingRecipe("Pasta", "Timur", 4, RecipeType.MAIN_COURSE, "Boiling", 10, 20);
        r2.addIngredient(new Ingredient("Pasta", 300, "g"));
        r2.addTag(Tag.VEGAN);
        book.addRecipe(r2);

        DrinkRecipe r3 = new DrinkRecipe("Lemonade", "Timur", 2, RecipeType.BEVERAGE, false, true, 500);
        r3.addIngredient(new Ingredient("Lemon", 3, "pieces"));
        r3.addTag(Tag.VEGAN);
        book.addRecipe(r3);

        int choice = -1;
        while (choice != 0)
        {
            System.out.println("\n--- Recipe Book Menu ---");
            System.out.println("1. Print book details");
            System.out.println("2. List all recipes");
            System.out.println("3. List by type");
            System.out.println("4. Search by title");
            System.out.println("5. Search by ingredient");
            System.out.println("6. Search by tag");
            System.out.println("7. Print recipe details");
            System.out.println("8. Rate a recipe");
            System.out.println("9. List top rated recipes");
            System.out.println("10. Scale a recipe");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1)
            {
                book.printDetails();
            }
            else if (choice == 2)
            {
                book.listAll();
            }
            else if (choice == 3)
            {
                System.out.println("Types: DESSERT, MAIN_COURSE, APPETIZER, BEVERAGE, BREAKFAST");
                System.out.print("Enter type: ");
                String t = scanner.nextLine();
                book.listByType(RecipeType.valueOf(t.toUpperCase()));
            }
            else if (choice == 4)
            {
                System.out.print("Enter title keyword: ");
                String keyword = scanner.nextLine();
                book.searchByTitle(keyword);
            }
            else if (choice == 5)
            {
                System.out.print("Enter ingredient name: ");
                String name = scanner.nextLine();
                book.searchByIngredient(name);
            }
            else if (choice == 6)
            {
                System.out.println("Tags: VEGETARIAN, VEGAN, GLUTEN_FREE, QUICK, SPICY, DAIRY_FREE");
                System.out.print("Enter tag: ");
                String tag = scanner.nextLine();
                book.searchByTag(Tag.valueOf(tag.toUpperCase()));
            }
            else if (choice == 7)
            {
                System.out.print("Enter recipe title: ");
                String title = scanner.nextLine();
                for (Recipe r : book.getRecipes())
                    if (r.getTitle().equalsIgnoreCase(title))
                    {
                        System.out.println(r);
                        System.out.println(r.getDetails());
                    }
            }
            else if (choice == 8)
            {
                System.out.print("Enter recipe title: ");
                String title = scanner.nextLine();
                System.out.print("Enter rating (1-5): ");
                int rating = scanner.nextInt();
                scanner.nextLine();
                for (Recipe r : book.getRecipes())
                    if (r.getTitle().equalsIgnoreCase(title))
                        r.rate(rating);
                System.out.println("Rated!");
            }
            else if (choice == 9)
            {
                System.out.print("How many top recipes? ");
                int n = scanner.nextInt();
                scanner.nextLine();
                book.getTopRated(n);
            }
            else if (choice == 10)
            {
                System.out.print("Enter recipe title: ");
                String title = scanner.nextLine();
                System.out.print("Enter new servings: ");
                int servings = scanner.nextInt();
                scanner.nextLine();
                for (Recipe r : book.getRecipes())
                    if (r.getTitle().equalsIgnoreCase(title))
                        r.scale(servings);
                System.out.println("Scaled!");
            }
            else if (choice == 0)
            {
                System.out.println("Goodbye!");
            }
        }
        scanner.close();
    }
}