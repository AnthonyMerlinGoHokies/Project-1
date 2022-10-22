// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who do.
// -- Anthony Merlin (9064-59249)


package project1;

/**
 * Run the project to display the Bag
 * 
 * @author Anthony Merlin 
 * @version 2020-09-13
 *
 */
public class ProjectRunner {

    /**
     * Run the Project
     * 
     * @param args
     *            Command Line arguments
     */
    public static void main(String... args) {
        DisplayCollection disp = new DisplayCollection();
        ShapeWindow window = new ShapeWindow(disp.getItemBag());

    }
}