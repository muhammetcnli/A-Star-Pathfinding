# A* Pathfinding Visualizer

## Overview

This project is a Windows application built in Java using Swing. It visualizes the A* pathfinding algorithm in a grid-based environment, allowing users to interactively add obstacles and watch the algorithm in action as it finds the shortest path.

## Features

- **Interactive Grid**: Watch the A* algorithm operate in real time.
- **Obstacle Placement**:
  - **Left-Click** on any grid cell to add a solid node (obstacle) to the grid.
- **Algorithm Execution**:
  - **Press Enter** to start the A* search algorithm.
- **Visual Feedback**: Observe explored nodes, path discovery, and (optionally) cost values on nodes during the search.

## Screenshots and Demonstrations

Below are two GIF demonstrations of the application’s functionality:

1. **Standard Visualization**  
   This GIF shows the normal operation of the algorithm, where the grid updates dynamically as nodes are explored and the optimal path is found.  
   ![Standard Visualization](https://github.com/muhammetcnli/A-Star-Pathfinding/blob/master/gifs/aStarNormal.gif)

2. **Cost Visualization on Normal Nodes**  
   This GIF displays the grid with cost values annotated on the nodes, offering deeper insights into the algorithm's decision-making process.  
   ![Cost Visualization](https://github.com/muhammetcnli/A-Star-Pathfinding/blob/master/gifs/aStarWithCosts.gif)

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed.
- **An IDE or Text Editor**: Tools such as IntelliJ IDEA, Eclipse, or NetBeans are recommended for running and editing the code.

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/muhammetcnli/A-Star-Pathfinding.git 
   cd A-Star-Pathfinding
2. Compile the Project

You can compile the project using your preferred IDE or from the command line. To compile from the command line, navigate to the project's source directory and run:

 ```bash
javac -d bin src/**/*.java
Run the Application
```
3. Run the Application

After compiling, run the application using:


  ```bash
   java -cp bin Main
  ```

## Usage

### Adding Obstacles

- **Right-Click** on any cell in the grid to add a solid node (obstacle).

### Starting the Search

- **Press the Enter key** to initiate the A* pathfinding algorithm.  
- The grid will update dynamically as the algorithm explores nodes and determines the optimal path (if one exists).

### Understanding the Visualization

The grid displays:

- **Explored Nodes**: Cells that have been visited by the algorithm.
- **Final Path**: The optimal route from the start to the target node.
- **Cost Values (Optional)**: In the cost visualization mode, nodes display their respective cost values to illustrate the algorithm's calculations.

## Customization

The application is built with Java Swing, making it easy to customize:

- **UI Adjustments**: Modify the appearance of the grid and nodes by changing the Swing components.
- **Algorithm Parameters**: Tweak the A* algorithm parameters or grid dimensions as needed.
- **Code Documentation**: The source code is commented to help you understand and modify the behavior.

## Contributing

Contributions are welcome! Please follow these steps:

1. **Fork the repository**.
2. **Create a new branch** for your feature or bug fix.
3. **Submit a pull request** with a detailed description of your changes.
