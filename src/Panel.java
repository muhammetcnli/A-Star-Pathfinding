import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    // Sttings
    private final int maxCol = 15;
    private final int maxRow = 13;
    private final int nodeSize = 70;
    private final int screenWidth = nodeSize * maxCol;
    private final int screenHeight = nodeSize * maxRow;

    // Node
    Node[][] node = new Node[maxCol][maxRow];
    Node startNode, goalNode, currentNode;

    public Panel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(maxRow, maxCol));

        // Place Nodes to panel
        int col = 0;
        int row = 0;

        while (col < maxCol && row < maxRow){

            node[col][row] = new Node(col,row);
            this.add(node[col][row]);

            col ++;
            if(col == maxCol){
                col = 0;
                row ++;
            }
        }

        // implement keyboard keys for setting start and goal
        setStartNode(3,6);
        setGoalNode(11,3);

        // implement mouse clicks for adding solid node
        setSolidNode(10,2);
        setSolidNode(10,3);
        setSolidNode(10,4);
        setSolidNode(10,5);
        setSolidNode(10,6);
        setSolidNode(19,3);


    }

    private void setStartNode(int col, int row){
        node[col][row].setAsStart();
        startNode = node[col][row];
        currentNode = startNode;
    }

    private void setGoalNode(int col, int row){
        node[col][row].setAsGoal();
        goalNode = node[col][row];
    }

    private void setSolidNode(int col, int row){

        node[col][row].setAsSolid();


    }

}
