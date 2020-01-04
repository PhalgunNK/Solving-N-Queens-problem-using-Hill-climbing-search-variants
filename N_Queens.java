/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n_queens;

/**
 *
 * @author kulkarni
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class N_Queens {

    private static final int RUNTEST = 500;

    public N_Queens() {

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

            System.out.println("Enter the value for N in this n-Queen problem: ");
            int NODE_SIZE= scan.nextInt();
            //Take the input size for the n queen problem
            Node.setSize(NODE_SIZE);
            N_Queens board = new N_Queens();
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
                            HillClimb hclimb
                        = new HillClimb(initialBoard);
                                     
                Node HillClimbnode =hclimb.climbingAlgo();
                                
                if (HillClimbnode.getH() == 0) {
                    SA_Sum_Successes++;
                    SA_Success_Steps =hclimb.getSteps();
                    SA_Avg_Success_Steps=SA_Avg_Success_Steps+SA_Success_Steps;
                }
                else
                {
                    SA_Fail_Steps=hclimb.getSteps();
                    SA_Avg_Fail_Steps=SA_Avg_Fail_Steps+SA_Fail_Steps;
                }

                if(currentTest==33)
                {
                    System.out.println("First Path for Hill Climbing" );
                    ArrayList<Node> x =hclimb.listToPrint();
                   hclimb.printPath(x);
                    System.out.println("Path cost: " + x.size());
                }
                if(currentTest==97){
                    System.out.println("Second Path for Hill Climbing" );
                    ArrayList<Node> x =hclimb.listToPrint();
                   hclimb.printPath(x);
                    System.out.println("Path cost: " + x.size());
                }
               if(currentTest==139) {
                    System.out.println("Second Path for Hill Climbing");
                    ArrayList<Node> x =hclimb.listToPrint();
                   hclimb.printPath(x);
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
                    + " Success Count = " + SA_Sum_Successes
                    + " \n Success rate = " + SA_AVE_Success 
                    + " \n Fail count = " + (500.0 - SA_Sum_Successes)
                    + " \n Failure rate = " + (1 - SA_AVE_Success)
                    + " \n Avg Success Steps : " + ((SA_Avg_Success_Steps)/(SA_Sum_Successes))
                    + " \n Avg Fail Steps : " + ((SA_Avg_Fail_Steps)/(500-SA_Sum_Successes)));
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