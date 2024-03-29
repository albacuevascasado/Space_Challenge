import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Simulation {


    public static ArrayList<Item> loadItems(String file) throws IOException {
        ArrayList<Item> cargo = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Line " + line);
                Item item = new Item();
                String [] words = line.split("=");
                //System.out.println(words);
                item.name = words[0];
                //System.out.println("Item name: " + item.name);
                item.weight = Integer.parseInt(words[1]);
                //System.out.println("Item weight: " + item.weight);

                cargo.add(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cargo;
    }

    public static ArrayList<U1> loadU1 (ArrayList<Item> cargo){
        U1 u1 = new U1();
        ArrayList<U1> total_U1 = new ArrayList<>();
        total_U1.add(u1);
        ArrayList<String> total_cargo = new ArrayList<>(); //name
        int U1_size = 0;
        int capacity = 0;

        for (int i = 0; i < cargo.size(); i++)
        {
            //System.out.println("i: " + i);
            capacity += total_U1.get(U1_size).carry(cargo.get(i)); //u1.carry(cargo.get(i))
            if (total_U1.get(U1_size).canCarry(capacity)) {
                total_cargo.add(cargo.get(i).name);
                //System.out.println("Item name: " + cargo.get(i).name);
            } else {
                U1 u10  = new U1();
                total_U1.add(u10);
                U1_size += 1;
                capacity = 0;
                capacity += total_U1.get(U1_size).carry(cargo.get(i));
                total_cargo.add(cargo.get(i).name);
                //System.out.println("Item name: " + cargo.get(i).name);

            }
            System.out.println("Total cargo: " + total_cargo);

        }

        return  total_U1;
    }

    public static ArrayList<U2> loadU2 (ArrayList<Item> cargo){
        U2 u2 = new U2();
        ArrayList<U2> total_U2 = new ArrayList<>();
        total_U2.add(u2);
        ArrayList<String> total_cargo = new ArrayList<>();
        int capacity = 0;
        int U2_size = 0;

        for (int i = 0; i < cargo.size(); i++)
        {
            System.out.println("i: " + i);
            capacity += total_U2.get(U2_size).carry(cargo.get(i));
            if (total_U2.get(U2_size).canCarry(capacity)) {
                total_cargo.add(cargo.get(i).name);
            } else {
                U2 u20  = new U2();
                total_U2.add(u20);
                U2_size += 1;
                capacity = 0;
                capacity += total_U2.get(U2_size).carry(cargo.get(i));
                total_cargo.add(cargo.get(i).name);
            }

        }
        return  total_U2;
    }

    public static int  runSimulationU1 (ArrayList<U1> u1) {
        int budget = 0;
        System.out.println("size of U1 " + u1.size()); //how many u1 rockets
        for (int i = 0; i < u1.size(); i++) {
            if (u1.get(i).launch_Explosion(u1.get(i).actual_Capacity) || (u1.get(i).land_Explosion(u1.get(i).actual_Capacity))){
                budget += u1.get(i).ROCKET_COST_U1;
                System.out.println("Rocket lost");
            }
        }
        int i = u1.size()-1;
        return budget + u1.get(i).ROCKET_COST_U1;
    }

    public static int  runSimulationU2 (ArrayList<U2> u2) {
        int budget = 0;
        System.out.println("size of U2 " + u2.size());
        for (int i = 0; i < u2.size(); i++) {
            if (u2.get(i).launch_Explosion(u2.get(i).actual_Capacity) || (u2.get(i).land_Explosion(u2.get(i).actual_Capacity))){
                budget += u2.get(i).ROCKET_COST_U2;
                System.out.println("Rocket lost");
            }
        }
        int i = u2.size()-1;
        return budget + u2.get(i).ROCKET_COST_U2;
    }
}
