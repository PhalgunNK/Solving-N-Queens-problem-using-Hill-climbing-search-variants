/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSHILLCLIMB;

/**
 *
 * @author kulkarni
 */
import java.util.ArrayList;
import java.util.Random;

public class SidewaysMove {

    private Queen[] firstState;

    private Node initial;
    private int steps=0;
    private ArrayList<Node> printNodes=new ArrayList<>();



    public SidewaysMove() {
        initial = new Node();
        firstState = new Queen[Node.getSize()];
        firstState();
    }

    public SidewaysMove(Queen[] s) {
        initial = new Node();
        firstState = new Queen[Node.getSize()];
        for (int i = 0; i < s.length; i++){
            firstState[i] = new Queen(s[i].getRows(), s[i].getColumns());
        }
        initial.setStateBoard(firstState);
        initial.calculateH();

    }

    public void firstState() {
        Random random = new Random();
        for (int i = 0; i < Node.getSize(); i++){
            firstState[i] = new Queen(random.nextInt(Node.getSize()), i);
        }
        initial.setStateBoard(firstState);
        initial.calculateH();
    }

    public Node climbingAlgo() {

        Node currentNode = initial;
        int count = 0;



        while (true) {
                ArrayList<Node> successors = currentNode.createNode(currentNode);
                ArrayList<Node> selectRandomSuccessors=new ArrayList<>();

                boolean existBetter = false;
                boolean existBest=false ;

                printNodes.add(currentNode);


                for (int i = 0; i < successors.size() && count!=100; i++)
                {

                    if (successors.get(i).compareTo(currentNode) <= 0)
                    {

                        if(successors.get(i).compareTo(currentNode)<0)
                        {
                            count=0;

                            selectRandomSuccessors.clear();
                            currentNode = successors.get(i);
                            existBetter = true;
                            steps++;

                        }

                        else if (successors.get(i).compareTo(currentNode) == 0)
                        {

                            selectRandomSuccessors.add(successors.get(i));

                        }


                    }


                }

                if(!existBetter && !selectRandomSuccessors.isEmpty()) {

                        Random random=new Random();

                        currentNode=selectRandomSuccessors.get(random.nextInt(selectRandomSuccessors.size()));
                        existBest=true;
                        count++;
                        steps++;


                }

                if(!existBest && !existBetter)
                {
                    return currentNode;
                }





        }


    }

    public Node getStartNode() {
        return initial;
    }


    public ArrayList<Node> getNodesToPrint()
    {
        return printNodes;
    }


    public void printPath(ArrayList<Node> printNodes){

        for(int i=0; i<printNodes.size();i++)
        {
            System.out.println(printNodes.get(i).toString());
        }
    }

    public int getSSteps(){
        return steps;
    }
}