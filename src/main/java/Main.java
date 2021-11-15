import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        ArrayList<U1> totalU1 = Simulation.loadU1 (Simulation.loadItems("./data/phase-1.txt"));
        int budget = Simulation.runSimulationU1(totalU1);
        System.out.println("Budget: " + budget);

         */

        ArrayList<U2> totalU2 = Simulation.loadU2(Simulation.loadItems("./data/phase-1.txt"));
        System.out.println("Budget: " + Simulation.runSimulationU2(totalU2));
    }

}
