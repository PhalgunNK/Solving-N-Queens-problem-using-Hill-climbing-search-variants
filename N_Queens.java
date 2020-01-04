package RandomRestartMain;
/**
 *
 * @author Phalgun kulkarni
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class N_Queens {
private static final int Runtimes = 500;

public N_Queens() {}
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the value for N in this n-Queen problem: "); //Takeing input from the user for board configuaration(Number of queens)
        int NODE_SIZE= scan.nextInt();
             Node.setSize(NODE_SIZE);
            N_Queens board = new N_Queens();
            System.out.println("Generating for " + NODE_SIZE + " board configuration : "); // displaying the size of the board configuration

            double SM_SUM_Successes = 0, SM_AVE_Successes = 0, SM_Success_Steps=0,    //Initializing the variables
                    SM_Avg_Success_Steps=0, SM_Fail_Steps = 0, SM_Avg_Fail_Steps = 0 ;
            double SA_Sum_Successes = 0, SA_AVE_Success = 0, SA_Success_Steps = 0,
                    SA_Avg_Success_Steps = 0, SA_Fail_Steps = 0, SA_Avg_Fail_Steps = 0;
            double RR_Sum_Successes = 0, RR_AVE_Successes = 0, RR_Success_Steps = 0,
                     RR_Avg_Success_Steps=0, RandomRestart_Count=0;
            double RRS_Sum_Successes = 0, RRS_Ave_Successes = 0,
                    RRS_Success_Steps = 0, RRS_Avg_Success_Steps=0,
                    RandomRestartSideways_Count=0;

            for (int currentTest = 1; currentTest <= Runtimes; currentTest++) {
               Queen[] initialBoard = board.generateChessBoard();
                RandomRestart randomRestart                            
                        = new RandomRestart(initialBoard);           //Calling RandomRestart class

                

                SidewaysMove sidewaysMove                            //Calling Sidewas move class   
                        = new SidewaysMove(initialBoard);

                RandomRestartSideways randomRestartSideways          //Calling RandomRestart with sidewaysmove class
                        = new RandomRestartSideways(initialBoard);

                Node randomRestartNode = randomRestart.climbingAlgo();
                Node sidewaysMoveNode = sidewaysMove.climbingAlgo();
                Node randomRestartSidewaysNode = randomRestartSideways.climbingAlgo();

               
                if (randomRestartNode.getH() == 0) {                 //Random Restart without sideways move
                    RR_Sum_Successes++;
                    RR_Success_Steps=randomRestart.getStepCount();
                    RR_Avg_Success_Steps=RR_Avg_Success_Steps+RR_Success_Steps;
                    RandomRestart_Count=RandomRestart_Count+(randomRestart.getRandomRestartUsed());
                }


                if (randomRestartSidewaysNode.getH() == 0) {          //Random Restart with sideways move
                    RRS_Sum_Successes++;
                    RRS_Success_Steps=randomRestartSideways.getStepCount();
                    RRS_Avg_Success_Steps=RRS_Avg_Success_Steps+RRS_Success_Steps;
                    RandomRestartSideways_Count=RandomRestartSideways_Count+randomRestartSideways.getRandomRestartSidewaysUsed();
                }
 
                if (sidewaysMoveNode.getH() == 0) {
                    SM_SUM_Successes++;
                    SM_Success_Steps=sidewaysMove.getSSteps();
                    SM_Avg_Success_Steps=SM_Avg_Success_Steps+SM_Success_Steps;

                }
                else{
                    SM_Fail_Steps=sidewaysMove.getSSteps();
                    SM_Avg_Fail_Steps=SM_Avg_Fail_Steps+SM_Fail_Steps;
                }
                if(currentTest==376) {                                          // Genrating Queen board and Path and Path cost
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

            SA_AVE_Success =                                       //Calculating Average
            SA_Sum_Successes / Runtimes;

            SM_AVE_Successes =
            SM_SUM_Successes / Runtimes;

            RR_AVE_Successes =
            RR_Sum_Successes / Runtimes;

            RRS_Ave_Successes =
            RRS_Sum_Successes / Runtimes;

   

            System.out.println("Random Restart without Sideways moves:"
            + " \nAvrage number of Steps without sideways move  = " + ((RR_Avg_Success_Steps)/500)
            + " \nAvrage number of Random Restarts without sideways move  =" + (RandomRestart_Count/500));

        System.out.println("Random Restart Sideways :"
            + " \nAvrage number of Steps with sideways move = " + ((RRS_Avg_Success_Steps)/500)
            + " \nAvrage number of Random Restarts with sideways move = " + (RandomRestartSideways_Count)/500);
        }

       
    public Queen[] generateChessBoard(){          //Generating a Board with randomly placing the Queens on the Board
        Queen[] start = new Queen[Node.getSize()];
        Random gen = new Random();

        for (int i = 0; i < Node.getSize(); i++) {
            start[i] = new Queen(gen.nextInt(Node.getSize()), i);
        }
        return start;
    }

}