import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);


        window.add(new Panel());
        window.setTitle("A * Pathfinding");
        window.pack();
        window.setLocationRelativeTo(null);

        window.setVisible(true);

    }
}