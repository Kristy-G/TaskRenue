public class Airport implements Comparable<Airport>{
    String info;
    int stringNumber;

    public Airport(String info, int stringNumber) {
        this.info = info;
        this.stringNumber = stringNumber;
    }

    @Override
    public int compareTo(Airport o) {
        return this.info.compareTo(o.info);
    }
}
