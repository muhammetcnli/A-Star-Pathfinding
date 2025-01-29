import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Node extends JButton implements ActionListener {

    Node parent;

    int col, row, gCost, hCost, fCost;

    boolean start, goal, solid, open, checked;

    public Node(int col, int row) {
        this.col = col;
        this.row = row;

        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setBackground(Color.orange);

    }

    public void setAsStart(){

        setBackground(Color.GREEN);
        setForeground(Color.white);
        setText("Start");
        start = true;

    }
    public void setAsGoal(){

        setBackground(Color.red);
        setForeground(Color.black);
        setText("Goal");
        goal = true;

    }

    public void setAsSolid(){

        setBackground(Color.BLACK);
        setForeground(Color.black);
        solid = true;

    }
}
