import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class Airports {
    final ArrayList<Airport> airports;
    final String link;

    public Airports(String link, int arg) {
        this.link = link;
        airports = new ArrayList<>();
        try(RandomAccessFile file = new RandomAccessFile(link, "r")) {
            int i = 1;
            String fileStr;
            while ((fileStr = file.readLine()) != null) {
                String column = fileStr.split(",")[arg].replaceAll("\"", "");
                airports.add(new Airport(column, i));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(airports);
    }
}
