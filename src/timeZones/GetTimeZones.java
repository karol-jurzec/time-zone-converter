package timeZones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class GetTimeZones implements  IGetTimeZones{
    static Vector<Pair<String,String>> timeZones = new Vector<Pair<String, String>>();

    public Vector<Pair<String,String>> getTimeZones(){ return timeZones; }

    @Override
    public void readZonesFromFile() {
        Scanner sc = null;
        try{
            sc = new Scanner(new File("TimeZones.csv"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                parseData(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(sc != null){
                sc.close();
            }
        }

    }

    @Override
    public String convertDate(String myDate, String whichTimeZone){
        try {
            String timeToAd = "";
            for (Pair tZ : timeZones) {
                if (whichTimeZone.equals(tZ.getName())) {
                    timeToAd = (String) tZ.getTimeToAdd();
                    break;
                }
            }

            int hours = parseInt(myDate.substring(0, 2));
            int minutes = parseInt(myDate.substring(3, 5));
            int sec = parseInt(myDate.substring(6, 8));

            if (hours > 24 || hours < 0)
                throw new Exception();
            else if (minutes > 60 || minutes < 0)
                throw new Exception();
            else if (sec > 60 || sec < 0)
                throw new Exception();

            int hoursToAdd, minuteToAdd;

            if (timeToAd.charAt(0) == '-') hoursToAdd = -1 * parseInt(timeToAd.substring(1, 3));
            else hoursToAdd = parseInt(timeToAd.substring(0, 2));

            hours = ((24 + hours + hoursToAdd) % 24);

            if (timeToAd.charAt(0) == '-') minuteToAdd = -1 * parseInt(timeToAd.substring(4, 6));
            else minuteToAdd = parseInt(timeToAd.substring(3, 5));

            if ((minutes + minuteToAdd) < 0)
                hours = (24 + hours - 1) % 24;
            else if ((minutes + minuteToAdd) >= 60)
                hours = (24 + hours + 1) % 24;

            minutes = ((60 + minutes + minuteToAdd) % 60);

            String hoursAns, minutesAns, ans;
            if (hours < 10)
                hoursAns = "0" + Integer.toString(hours);
            else
                hoursAns = Integer.toString(hours);

            if (minutes < 10)
                minutesAns = "0" + Integer.toString(minutes);
            else
                minutesAns = Integer.toString(minutes);

            ans = hoursAns + ":" + minutesAns + ":" + myDate.substring(6, 8);
            return ans;
        }catch (Exception e){
            System.out.println("Zly format liczby!");
        }
        return null;
    }

    private static void parseData(String str){
        String name, timeToAdd;
        Scanner lineScanner = new Scanner(str);
        lineScanner.useDelimiter(";");
        while(lineScanner.hasNext()){
            name = lineScanner.next();
            timeToAdd = lineScanner.next();
            timeZones.add(new Pair(name, timeToAdd));
        }
        lineScanner.close();
    }
}
