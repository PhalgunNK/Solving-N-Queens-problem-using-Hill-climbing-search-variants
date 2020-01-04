
package RandomRestartMain;

/**
 *
 * @author kulkarni
 */
public class RandomRestartSideways {                //initalizing variables
    private SidewaysMove sidewaysObject;
    private Node start;
    private int steps;
    private int randomRestartUsed;


    public RandomRestartSideways(Queen[] startBoard) {    //intializing random restart with sideways move class
        sidewaysObject = new SidewaysMove(startBoard);
        randomRestartUsed++;
    }

    public Node climbingAlgo() {
        Node currentNode = sidewaysObject.getStartNode();
        setStartNode(currentNode);
        int heuristic = currentNode.getH();

        steps=0;

        while(heuristic!=0){
            Node nextNode = sidewaysObject.climbingAlgo();
            steps=steps+sidewaysObject.getSSteps();
            heuristic = nextNode.getH();
            if(heuristic!=0){
                sidewaysObject = new SidewaysMove();
                randomRestartUsed++;
            }else
                {
                currentNode = nextNode;  //steps=steps-sidewaysObject.getSSteps();
                 }
        }
        return currentNode;
    }

    public void setStartNode(Node n){
        start = n;
    }
   public int getStepCount(){ return  steps; }

   public int getRandomRestartSidewaysUsed(){
        return randomRestartUsed;
    }

}