package RandomRestartMain;

/**
 *
 * @author kulkarni
 */
public class RandomRestart {                //initalizing variables
    private SteepestAscent steepestObject; 
    private Node start;
    private int steps;
    private int randomRestartUsed=0;


    public RandomRestart(Queen[] startBoard) {       //intializing random restart class
        steepestObject = new SteepestAscent(startBoard);
        randomRestartUsed++;
    }

       public Node climbingAlgo() {
        Node currentNode = steepestObject.getStartNode();
        setStartNode(currentNode);
        int heuristic = currentNode.getH();

        steps=0;

        while(heuristic!=0){
            Node nextNode = steepestObject.climbingAlgo();
            steps=steps+steepestObject.getSteps();
            heuristic = nextNode.getH();

            if(heuristic!=0){
                steepestObject = new SteepestAscent();
                randomRestartUsed++;

            }else {
                currentNode = nextNode;
                steps=steps-steepestObject.getSteps();
                randomRestartUsed++;
            }
        }
        return currentNode;
    }

    public void setStartNode(Node n){
        start = n;
    }

    public int getStepCount(){ return  steps; }

    public int getRandomRestartUsed() {
        return randomRestartUsed;
    }

}