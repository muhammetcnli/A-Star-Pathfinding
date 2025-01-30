import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel extends JPanel{

    // Settings
    private final int maxCol = 15;
    private final int maxRow = 13;
    private final int nodeSize = 70;
    private final int screenWidth = nodeSize * maxCol;
    private final int screenHeight = nodeSize * maxRow;

    // Node
    Node[][] node = new Node[maxCol][maxRow];
    Node startNode, goalNode, currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkedList = new ArrayList<>();

    // Others
    boolean goalReached = false;
    int step = 0;

    public Panel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(maxRow, maxCol));
        this.addKeyListener(new KeyHandler(this));
        this.setFocusable(true);

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

        // set cost
        setCostOnNodes();


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

    private void  setCostOnNodes(){
        int col = 0;
        int row = 0;

        while (col < maxCol && row < maxRow){

            getCost(node[col][row]);
            col ++;
            if(col == maxCol){
                col = 0;
                row ++;
            }
        }
    }

    private void getCost(Node node){

        // Get G cost (The distance from the start node)
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        // Get h cost (The distance from the goal node)
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        // F cost (The total cost)
        node.fCost = node.gCost + node.hCost;

        if(node != startNode && node != goalNode){
            node.setText("<html>F:" + node.fCost + "<br>G: " + node.gCost + "<html/>");
        }
    }
    public void autoSearch() {
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (!goalReached) {
                    int col = currentNode.col;
                    int row = currentNode.row;

                    currentNode.setAsChecked();
                    checkedList.add(currentNode);
                    openList.remove(currentNode);

                    // Komşu düğümleri aç
                    if (row - 1 >= 0) openNode(node[col][row - 1]);
                    if (col - 1 >= 0) openNode(node[col - 1][row]);
                    if (row + 1 < maxRow) openNode(node[col][row + 1]);
                    if (col + 1 < maxCol) openNode(node[col + 1][row]);

                    int bestNodeIndex = 0;
                    int bestNodefCost = Integer.MAX_VALUE;

                    for (int i = 0; i < openList.size(); i++) {
                        if (openList.get(i).fCost < bestNodefCost) {
                            bestNodeIndex = i;
                            bestNodefCost = openList.get(i).fCost;
                        } else if (openList.get(i).fCost == bestNodefCost) {
                            if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                                bestNodeIndex = i;
                            }
                        }
                    }

                    // Sonraki en iyi düğümü seç
                    currentNode = openList.get(bestNodeIndex);

                    if (currentNode == goalNode) {
                        goalReached = true;
                        trackThePath();
                        ((Timer) e.getSource()).stop(); // Timer'ı durdur
                    }
                }} catch (IndexOutOfBoundsException exc){
                    System.out.println("Cannot find goal");
                    System.exit(0);
                }
            }
        });

        timer.setRepeats(true); // Tekrar etmesini sağla
        timer.start(); // Timer'ı başlat
    }

    public void search(){

        if(!goalReached && step < 300){

            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            // open the up node
            if(row -1 >= 0){
            openNode(node[col][row - 1]);}

            // open the left node
            if(col -1 >= 0){
            openNode(node[col-1][row]);}

            // open the down node
            if(row +1 < maxRow){
            openNode(node[col][row+1]);}

            // open the right node
            if(col +1 < maxCol){
            openNode(node[col+1][row]);}

            int bestNodeIndex = 0;
            int bestNodefCost = 999;

            for(int i = 0; i < openList.size(); i++){

                // check if this node's f cost is better
                if(openList.get(i).fCost < bestNodefCost){
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                }
                // if f cost is equal, check g cost
                else if (openList.get(i).fCost == bestNodefCost) {
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex = i;
                    }
                }
            }
            // after loop, we get the best node which is our next step
            currentNode = openList.get(bestNodeIndex);

            if(currentNode == goalNode){

                goalReached = true;

            }
            step++;
        }
    }

    private void openNode(Node node){

        if(!node.open && !node.checked && !node.solid){

            // if the not is not open, add it to the open list
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }

    private void trackThePath(){

        Node current = goalNode;

        while (current != startNode) {

            current = current.parent;

            if(current != startNode){
                current.setAsPath();
            }
        }

    }

}
