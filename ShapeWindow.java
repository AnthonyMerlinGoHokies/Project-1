// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who do.
// -- Anthony Merlin (9064-59249)

package project1;

import bag.Bag;
import bag.BagInterface;
import cs2.TextShape;
import java.awt.Color;
import java.util.Random;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;



/**
 * Creates the GUI to display the Bag and its contents
 * 
 * @author Anthony Merlin
 * @version 2022-09-22
 *
 */
public class ShapeWindow {
    private final String TITLE = "Project 1";

    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;


    /**
     * Constructor to set up the GUI window
     * 
     * @param itemBag
     *            Bag Object
     */
    public ShapeWindow(BagInterface<String> itemBag) {
        this.window = new Window();
        this.window.setTitle(TITLE);
        this.itemBag = itemBag;

        this.quitButton = new Button("Quit");
        this.quitButton.onClick(this, "clickedQuit");
        this.window.addButton(this.quitButton, WindowSide.NORTH);

        this.chooseButton = new Button("Choose");
        this.chooseButton.onClick(this, "clickedChoose");
        this.window.addButton(this.chooseButton, WindowSide.SOUTH);

        this.textShape = new TextShape(0, 0, "");
        this.window.addShape(this.textShape);
    }


    /**
     * this method is performed when the quit button is pressed
     * 
     * @param button
     *            Quit button object
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * this method is performed when the choose button is pressed
     * 
     * @param button
     *            Choose button object
     */
    public void clickedChoose(Button button) {
        if (this.itemBag.getCurrentSize() > 0) {
            this.textShape.setText(this.itemBag.remove());
        }
        else {
            this.textShape.setText("No more items.");
        }
        colorText();
        centerText();
    }


    private void colorText() {
        String s = this.textShape.getText();
        Color color;
        if (s.toLowerCase().contains("red")) {
            color = Color.red;
        }
        else if (s.toLowerCase().contains("blue")) {
            color = Color.blue;
        }
        else {
            color = Color.black;
        }
        this.textShape.setForegroundColor(color);
    }


    private void centerText() {
        int pnlW = this.window.getGraphPanelWidth();
        int pnlH = this.window.getGraphPanelHeight();
        int textW = this.textShape.getWidth();
        int textH = this.textShape.getHeight();
        int x = (pnlW - textW) / 2;
        int y = (pnlH - textH) / 2;

        this.textShape.setX(x);
        this.textShape.setY(y);
    }

}