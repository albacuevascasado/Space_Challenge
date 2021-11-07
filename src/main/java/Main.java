import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Simulation simulation = new Simulation();
        ArrayList<Item> cargo = simulation.loadItems("./data/phase-1.txt");
        ArrayList<U1> totalU1 = simulation.loadU1(cargo);
        int budget = simulation.runSimulationU1(totalU1);
        System.out.println("Budget: " + budget);


    }

}
