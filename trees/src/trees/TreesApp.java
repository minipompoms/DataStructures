
package trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author pkohn
 */
public class TreesApp {

    /**
     * 
     *@param args the command line arguments
     */
    private static Scanner input;
    private static BinarySearchTree<String> tree = new BinarySearchTree<>();

    public static void main(String[] args) 
    {
       
        input = new Scanner(System.in);
        loadTreeFromFile(getInputFile(args));

        System.out.println("Tree with all values inserted from file:");
        tree.printTree();

        int choice = menu();
        while (choice != 0)
        {
            System.out.println();
            switch (choice)
            {
                case 1:
                    System.out.print("Please enter string to remove:");
                    removeAndDisplay(input.nextLine());
                    break;
                case 2:
                    System.out.print("Please enter string to check for:");
                    contains(input.nextLine());
                    break;
                case 3:
                    findMin();
                    break;
                case 4:
                    findMax();
                    break;
                default:
                    System.out.println("Unrecognized value.");
            }

            choice = menu();
        }

        System.out.println("Goodbye.");

    }

    /**
     * gets the file which has the strings to insert
     *
     * @param args the command line arguments that were passed to the
     * application (arg[0] should be the file location)
     * @return the full filepath with the strings
     */
    private static File getInputFile(String[] args)
    {
        String fileName;
        if (args.length == 0)
        {
            System.out.println("Please enter file containing tree entries");
            fileName = input.nextLine();
        }
        else
        {
            fileName = args[0];
        }
        File file = new File(fileName);

        return file;
    }

    /**
     * inserts strings into the AVL tree from a file
     *
     * @param file the file to insert from
     * @throws FileNotFoundException if the file doesn't exist
     */
    private static boolean loadTreeFromFile(File file)
    {
        boolean aOK = false;
        try (Scanner fileInput = new Scanner(file))
        {
            while (fileInput.hasNext())
            {
                tree.insert(fileInput.next());
            }
            aOK = true;
        }
        catch (FileNotFoundException exc)
        {
            System.out.println(exc.getMessage());
        }
        return aOK;
    }

    private static int menu()
    {
        System.out.print("\nPlease choose one of the following options:"
                + "\n1. Remove a value from the tree"
                + "\n2. Check if a value is contained in the tree"
                + "\n3. Find the minimal value of the tree"
                + "\n4. Find the maximal value of the tree"
                + "\n0. Exit:\n");

        int choice = UserInput.getInt(UserInput.Source.SCANNER, "Enter value ", 0, 4);
        return choice;
    }

    /**
     * removes given element from the AVL tree and then displays the tree
     *
     * @param str string to remove
     */
    private static void removeAndDisplay(String str)
    {
        tree.remove(str);
        System.out.println("Tree after remove was called:");
        tree.printTree();
    }

    /**
     * checks if the given value is contained in the AVL tree
     */
    private static void contains(String str)
    {
        System.out.println("Testing if tree contains \"" + str + "\": "
                + tree.contains(str));
    }

    /**
     * finds the smallest element in the AVL tree
     */
    private static void findMin()
    {
        System.out.println("The smallest element in the tree is \""
                + tree.findMin() + "\".");
    }

    /**
     * finds the largest element in the AVL tree
     */
    private static void findMax()
    {
        System.out.println("The largest element in the tree is \""
                + tree.findMax() + "\".");
    }
    
}
