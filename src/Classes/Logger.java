package Classes;


public class Logger {
    public static void log(String place, String event){
        System.out.println(place + ": " + event);
    }

    public static void err(String place, String event) {
        System.err.println(place + ": " + event);
    }
}
