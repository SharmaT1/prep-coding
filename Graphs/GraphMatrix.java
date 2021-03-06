import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/*
 * Implement graph using adjacency matrix
 */
@SuppressWarnings("unchecked")
public class GraphMatrix {

    private boolean[][] adjMatrix;
    private int numOfVertices;
    private boolean[] dfsexplored;


    public void addEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = true;
    }

    public void removeEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = false;
    }

    public boolean hasEdge(int vertex1, int vertex2) {
        return adjMatrix[vertex1][vertex2];
    }

    public ArrayList<Integer> outEdges(int vertex) {

        ArrayList<Integer> outEdges = new ArrayList();

        for (int i = 0; i < numOfVertices; i++) {
            if (adjMatrix[vertex][i]) {
                outEdges.add(i);
            }
        }

        return outEdges;
    }

    public ArrayList<Integer> inEdges(int vertex) {

        ArrayList<Integer> inEdges = new ArrayList();

        for (int i = 0; i < numOfVertices; i++) {
            if (adjMatrix[i][vertex]) {
                inEdges.add(i);
            }
        }

        return inEdges;
    }

    /*
     * Bread first search - get the shortest path
     * @param :  startVertex starting index to start search
     */
    public void bfs(int startVertex) {
        boolean[] explored = new boolean[numOfVertices];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        explored[startVertex] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            ArrayList<Integer> edges = outEdges(curr);
            for(Integer edge : edges) {
                if (explored[edge] == false) {
                    explored[edge] = true;
                    queue.add(edge);
                }
            }
        }
    }

    /*
     * Depth first search
     * @param startVertex starting vertex to start serch
     */

    public void dfs(int startVertex) {
        System.out.print(startVertex + " ");
        dfsexplored[startVertex] = true;
        ArrayList<Integer> edges = outEdges(startVertex);
        for (Integer edge : edges) {
            if (dfsexplored[edge] == false) {
                dfs(edge);
            }
        }
    }

    /*
     * copy text file to populate adjMatrix
     * @param : text file
     */
    public void readInput(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        numOfVertices = Integer.parseInt(sc.nextLine());
        adjMatrix = new boolean[numOfVertices][numOfVertices];


        while(sc.hasNextLine()) {
            String[] input = sc.nextLine().split(":");
            int vertex1 =  Integer.parseInt(input[0]);
            int vertex2 = Integer.parseInt(input[1]);
            adjMatrix[vertex1][vertex2] = true;
        }
        //dfs
        dfsexplored = new boolean[numOfVertices];
    }

    /*
     * @param : arguments from command line
     * v (number of vertices)
     * vertex1:vertex2 (here path is from vertex1 to vertex2)
     */
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("No arguments passed");
            System.exit(0);
        }

        GraphMatrix  graphMatrix = new GraphMatrix();

        graphMatrix.readInput(args[0]);

        //System.out.println(graphMatrix.outEdges(2));
        //System.out.println(graphMatrix.inEdges(2));
        graphMatrix.bfs(0); //starting from 0 index
        System.out.println();
        graphMatrix.dfs(0); //starting from 0 index
        System.out.println();

    }

}
