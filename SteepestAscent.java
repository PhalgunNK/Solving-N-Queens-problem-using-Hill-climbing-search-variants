package RandomRestartMain;

/**
 *
 * @author kulkarni
 */
import java.util.ArrayList;
import java.util.Random;

public class SteepestAscent {   //initializing variables
    private Queen[] startState;
    private Node startNode;
    private int steps=0;
    private ArrayList<Node> printNodes=new ArrayList<>();
    public SteepestAscent() {
        startNode = new Node();
        startState = new Queen[Node.getSize()];
        startState();
    }
    public SteepestAscent(Queen[] s) {
        startNode = new Node();
        startState = new Queen[Node.getSize()];
        for (int i = 0; i < s.length; i++){
            startState[i] = new Queen(s[i].getRows(), s[i].getColumns());
        }
        startNode.setStateBoard(startState);
        startNode.calculateH();
    }
    public void startState() {
        Random random = new Random();
        for (int i = 0; i < Node.getSize(); i++){
            startState[i] = new Queen(random.nextInt(Node.getSize()), i);
        }
        startNode.setStateBoard(startState);
        startNode.calculateH();
    }
    public Node climbingAlgo() {

        Node currentNode = startNode;

        while (true) {
            ArrayList<Node> successors = currentNode.createNode(currentNode);

            boolean existBetter = false;

            printNodes.add(currentNode);

            steps++;
            for (int i = 0; i < successors.size(); i++) {
                if (successors.get(i).compareTo(currentNode) < 0) {
                    currentNode = successors.get(i);
                    existBetter = true;
                }
            }

            if(!existBetter) {
                return currentNode;
            }
        }
    }
    public ArrayList<Node> listToPrint()
    {
        return printNodes;
    }
    public void printPath(ArrayList<Node> printNodes){
        for(int i=0; i<printNodes.size();i++)
        {
            System.out.println(printNodes.get(i).toString());
        }
    }
    public Node getStartNode(){
        return startNode;
    }
    public int getSteps(){
        return steps;
    }
}
