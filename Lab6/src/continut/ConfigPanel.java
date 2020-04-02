package continut;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JComboBox Shapes; // number of sides
    JComboBox colorCombo; // the color of the shape
    Color[] colors;
    Integer[] sides;
    int countercolors, countershapes;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        Random rand = new Random();

        label = new JLabel("Number of sides:");

        String[] forme = {"Romb", "Trapez", "Triunghi", "Hexagon", "Cicle"};
        Shapes = new JComboBox(forme);
        sides = new Integer[5];
        sides[0] = 4;
        sides[1] = 5;
        sides[2] = 3;
        sides[3] = 6;
        sides[4] = 100;

        String[] culori = {"Random", "Black", "Yellow", "Green", "Blue"};
        colorCombo = new JComboBox(culori);
        colors = new Color[5];
        colors[0] = new Color(rand.nextInt(0xFFFFFF));
        colors[1] = new Color(0x000000);
        colors[2] = new Color(0xffff00);
        colors[3] = new Color(0x00cc00);
        colors[4] = new Color(0x0000ff);
        Shapes.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                if (Shapes.getItemAt(Shapes.getSelectedIndex()).equals("Romb"))
                    countershapes = 0;
                if (Shapes.getItemAt(Shapes.getSelectedIndex()).equals("Trapez"))
                    countershapes = 1;
                if (Shapes.getItemAt(Shapes.getSelectedIndex()).equals("Triunghi"))
                    countershapes = 2;
                if (Shapes.getItemAt(Shapes.getSelectedIndex()).equals("Hexagon"))
                    countershapes = 3;
                if (Shapes.getItemAt(Shapes.getSelectedIndex()).equals("Cicle"))
                    countershapes = 4;
            }
        });
        colorCombo.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                if (colorCombo.getItemAt(colorCombo.getSelectedIndex()).equals("Random")) {
                    countercolors = 0;
                    colors[0] = new Color(rand.nextInt(0xFFFFFF));
                }
                if (colorCombo.getItemAt(colorCombo.getSelectedIndex()).equals("Black"))
                    countercolors = 1;
                if (colorCombo.getItemAt(colorCombo.getSelectedIndex()).equals("Yellow"))
                    countercolors = 2;
                if (colorCombo.getItemAt(colorCombo.getSelectedIndex()).equals("Green"))
                    countercolors = 3;
                if (colorCombo.getItemAt(colorCombo.getSelectedIndex()).equals("Blue"))
                    countercolors = 4;
            }
        });
        add(Shapes);
        add(colorCombo);
    }
}