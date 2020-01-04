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
import java.util.Scanner;

public class SidewaysHillClimbing {
    private static final int RUNTEST = 500;
    public SidewaysHillClimbing() {
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

            System.out.println("Enter the value for N in this n-Queen problem: ");
            int NODE_SIZE= scan.nextInt();
            //Take the input size for the n queen problem
            Node.setSize(NODE_SIZE);
            SidewaysHillClimbing board = new SidewaysHillClimbing();
            System.out.println("Test for " + NODE_SIZE + " Queens problem : ");
            //Initializing all the variables
           double SM_SUM_Successes = 0, SM_AVE_Successes = 0, SM_Success_Steps=0,
                    SM_Avg_Success_Steps=0, SM_Fail_Steps = 0, SM_Avg_Fail_Steps = 0 ;
            double SA_Sum_Successes = 0, SA_AVE_Success = 0, SA_Success_Steps = 0,
                    SA_Avg_Success_Steps = 0, SA_Fail_Steps = 0, SA_Avg_Fail_Steps = 0;
            double RR_Sum_Successes = 0, RR_AVE_Successes = 0, RR_Success_Steps = 0,
                     RR_Avg_Success_Steps=0, RandomRestart_Count=0;
            double RRS_Sum_Successes = 0, RRS_Ave_Successes = 0,
                    RRS_Success_Steps = 0, RRS_Avg_Success_Steps=0,
                    RandomRestartSideways_Count=0;
            for (int currentTest = 1; currentTest <= RUNTEST; currentTest++) {

                Queen[] initialBoard = board.generateBoard();
                               SidewaysMove sidewaysMove
                        = new SidewaysMove(initialBoard);
                                 Node sidewaysMoveNode = sidewaysMove.climbingAlgo();
                            
              if (sidewaysMoveNode.getH() == 0) {
                    SM_SUM_Successes++;
                    SM_Success_Steps=sidewaysMove.getSSteps();
                    SM_Avg_Success_Steps=SM_Avg_Success_Steps+SM_Success_Steps;
                }
                else{
                    SM_Fail_Steps=sidewaysMove.getSSteps();
                    SM_Avg_Fail_Steps=SM_Avg_Fail_Steps+SM_Fail_Steps;
                }
                if(currentTest==376) {
                    System.out.println("Third Path for Sideways Move");
                    ArrayList<Node> x = sidewaysMove.getNodesToPrint();
                    sidewaysMove.printPath(x);
                    System.out.println("Path cost: " + x.size());
                }
                if(currentTest==181)  {
                    System.out.println("First Path for Sideways Move");
                    ArrayList<Node> x = sidewaysMove.getNodesToPrint();
                    sidewaysMove.printPath(x);
                    System.out.println("Path cost: " + x.size());
                }
                if(currentTest==214) {
                    System.out.println("Second Path for Sideways Move");
                    ArrayList<Node> x = sidewaysMove.getNodesToPrint();
                    sidewaysMove.printPath(x);
                    System.out.println("Path cost: " + x.size());
                }

            }

            //Calculating Average
            SA_AVE_Success =
                    SA_Sum_Successes / RUNTEST;

            SM_AVE_Successes =
                    SM_SUM_Successes / RUNTEST;

            RR_AVE_Successes =
                    RR_Sum_Successes / RUNTEST;

            RRS_Ave_Successes =
                RRS_Sum_Successes / RUNTEST;
    
            System.out.println(
                    "Out of " + RUNTEST + " trails\n"

                    + " \nSuccess Count = " + SM_SUM_Successes
                    + " \nSuccess rate = " + SM_AVE_Successes
                    + " \nFail count  = " + (500.0 - SM_SUM_Successes)
                    + " \nFailure rate = " + (1 - SM_AVE_Successes)
                    + " \nAvg Success Steps = " + (SM_Avg_Success_Steps/SM_SUM_Successes)
                    + " \nAvg Fail Steps = " + ((SM_Avg_Fail_Steps)/(500-SM_SUM_Successes)));
                  }
        //Generate a Chess Board with randomly placing the Queens on the Board
    public Queen[] generateBoard(){
        Queen[] start = new Queen[Node.getSize()];
        Random gen = new Random();

        for (int i = 0; i < Node.getSize(); i++) {
            start[i] = new Queen(gen.nextInt(Node.getSize()), i);
        }
        return start;
    }

}