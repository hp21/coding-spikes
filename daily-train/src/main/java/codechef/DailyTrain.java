package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * *
 */
public class DailyTrain {

    List<List<Integer>> carriages = new ArrayList<List<Integer>>();
    private CompartmentSupport support;

    public static void main(String[] args) throws IOException {
        final DailyTrain dailyTrain = new DailyTrain();
        dailyTrain.run();
    }

    public void run() throws IOException {
        final BufferedReader reader = geReader("one.txt");

        String line = null;
        int lines = -1;
        int pax = -1;

        line = reader.readLine();
        int[] result = parseHeaderLine(line);
        pax = result[0];
        lines = result[1];

        support = new CompartmentSupport(9, 4, 2);

        carriages = initCarriages(lines, carriages);

        for (int i = 0; i < lines; i++) {
            line = reader.readLine();
            System.out.println("line: " + line);
            computeFreeSeats(line, carriages.get(i));
        }

        int variations = computeVariations(pax);

        System.out.println("Variations: " + variations);

    }

    private List<List<Integer>> initCarriages(int lines, List<List<Integer>> carriages) {

        for (int i = 0; i < lines; i++) {

            List<Integer> compartments = new ArrayList<Integer>(9);
            compartments = initCompartments(compartments);
            carriages.add(i, compartments);
        }

        return carriages;
    }

    private List<Integer> initCompartments(List<Integer> compartments) {
        for (int z = 0; z < 9; z++) {
            compartments.add(z, 0);
        }

        return compartments;
    }

    private BufferedReader geReader(String filename) {
        // InputStream inputStraem =
        // this.getClass().getResourceAsStream("empty-train.txt");

        InputStream inputStraem = this.getClass().getResourceAsStream(filename);

        return new BufferedReader(new InputStreamReader(inputStraem));
    }

    private int computeVariations(int pax) {
        int variations = 0;

        for (int i = 0; i < carriages.size(); i++) {
            List<Integer> myCompartments = carriages.get(i);

            for (int z = 0; z < myCompartments.size(); z++) {
                int free = 6 - myCompartments.get(z);
                final int myvariation = support.variations(free, pax);
                variations = variations + myvariation;
                System.out.println("Carriage/comparment/occupied/var\t" + (i + 1) + "/" + (z + 1) + "/" + (free) + "/\t" + myvariation);
            }
        }
        return variations;
    }

    private List<Integer> computeFreeSeats(String line, List<Integer> compartments) {
        System.out.println("line: " + line + "/" + compartments);

        for (int i = 0; i < line.length(); i++) {
            boolean occupied = '1' == line.charAt(i);

            if (!occupied) {
                continue;
            }

            int index = support.computeCompartment(i + 1);
            compartments.set(index - 1, compartments.get(index - 1) + 1);
        }

        System.out.println(compartments);
        return compartments;
    }

    private int[] parseHeaderLine(String line) {
        int[] result = new int[] { 0, 0 };

        String[] tokens = line.split("\\s+");

        result[0] = Integer.valueOf(tokens[0].trim());
        result[1] = Integer.valueOf(tokens[1].trim());

        return result;
    }

}
