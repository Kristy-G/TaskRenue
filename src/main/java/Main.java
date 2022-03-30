import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку:");
        String str = sc.nextLine();
        int arg;

        if(args.length > 0)
            arg = Integer.parseInt(args[0]) - 1;
        else arg = 1;

        long start = System.nanoTime();

        Search.SearchAirports(str, new Airports("airports.dat", arg));

        long finish = System.nanoTime();
        long time = (finish - start)/1000000;

        System.out.println("Прошло времени, мс: " + time);
    }
}
