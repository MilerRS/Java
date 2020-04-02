package continut;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("SAVE");
    JButton loadBtn = new JButton("LOAD");
    JButton resetBtn = new JButton("RESET");
    JButton exitBtn = new JButton("EXIT");
    final JFileChooser alegator = new JFileChooser();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
    }

    private void save(ActionEvent e) {
        alegator.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (alegator.showSaveDialog(loadBtn) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(alegator.getSelectedFile().getPath() + "/ImaginaCronstruita.png"));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }


    private void load(ActionEvent actionEvent) {
        alegator.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (alegator.showOpenDialog(saveBtn) == JFileChooser.APPROVE_OPTION) {
            File file = alegator.getSelectedFile();
            try {
                frame.canvas.image = ImageIO.read(file);
                frame.canvas.graphics = frame.canvas.image.createGraphics();
                frame.canvas.repaint();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

    private void reset(ActionEvent e) {
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fill(new RegularPolygon(0, 0, 1000, 100));
        frame.canvas.repaint();
    }
}
