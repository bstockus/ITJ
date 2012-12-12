/**

 File name: PineTree.java

 This applet draws a simple picture of a pine tree.

 Written by: Brian Durney
 Date: November, 2004
*/

import javax.swing.*;
import java.awt.*;

public class PineTree extends JApplet
{
    private int[] xBranches = {150, 250, 50};
    private int[] yBranches = {10, 150, 150};
    private int[] xTrunk = {125, 175, 175, 125};
    private int[] yTrunk = {150, 150, 200, 200};

    public void paint(Graphics canvas)
    {
        this.setBackground(Color.WHITE);
        canvas.setColor(Color.GREEN);
        canvas.fillPolygon(xBranches, yBranches, xBranches.length);
        canvas.setColor(Color.GRAY);
        canvas.fillPolygon(xTrunk, yTrunk, xTrunk.length);
    }
}
