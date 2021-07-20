import javax.swing.*;
import java.awt.*;
import javax.sql.*;

public class NSurvival {
    public static void main(String[] args) {
        NSurvival game = new NSurvival();
        game.showStartScreen();
    }

    public void showStartScreen() {
        JFrame frame = new JFrame();
        //widgets
        JButton start = new JButton("Play");

        //pack all widgets
        frame.getContentPane().add(start);

        //show window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
