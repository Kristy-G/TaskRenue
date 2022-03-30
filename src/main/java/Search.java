import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public class Search {
    public static void SearchAirports(String str, Airports airports) {
        ArrayList<Integer> nums = new ArrayList<>();
        BinarySearchAir(str, 0, airports.airports.size() - 1, nums, airports.airports);
        ArrayList<String> result = new ArrayList<>();
        if (nums.size() > 0) {
            Collections.sort(nums);
            try (RandomAccessFile file = new RandomAccessFile("airports.dat", "r")) {
                int i = 1;
                for (Integer n : nums) {
                    while (i < n) {
                        file.readLine();
                        i++;
                    }
                    String s = file.readLine().replace("\"", "");
                    int index = s.indexOf(",") + 1;
                    result.add(s.replace(s.substring(0, index), ""));
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Collections.sort(result);
        }
        result.forEach(System.out::println);
        System.out.println("Количество найденных строк: " + result.size());
    }

    public static void BinarySearchAir(String str, int from, int to, ArrayList<Integer> arr, ArrayList<Airport> airports) {
        int index = from + (to - from)/2;

        if (airports.get(index).info.startsWith(str)) {
            arr.add(airports.get(index).stringNumber);
            SearchAir(str, index, arr, airports);
        }
        else if (str.compareTo(airports.get(index).info.substring(0, str.length())) < 0 && (to - from) > 0)
            BinarySearchAir(str, from, index - 1, arr, airports);
        else if (str.compareTo(airports.get(index).info.substring(0, str.length())) > 0 && (to - from) > 0)
            BinarySearchAir(str, index + 1, to, arr, airports);
    }

    public static void SearchAir(String str, int index, ArrayList<Integer> arr, ArrayList<Airport> airports) {
        int left = index - 1;
        int right = index + 1;
        while (left >= 0) {
            if (airports.get(left).info.startsWith(str))
                arr.add(airports.get(left).stringNumber);
            else break;
            left--;
        }
        while (right < airports.size()) {
            if (airports.get(right).info.startsWith(str))
                arr.add(airports.get(right).stringNumber);
            else break;
            right++;
        }
    }
}
