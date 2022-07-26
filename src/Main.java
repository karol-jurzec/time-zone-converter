import timeZones.GetTimeZones;
import timeZones.IGetTimeZones;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class Main {
    static IGetTimeZones myTimeZones;

    public static void main(String Args[]){
        myTimeZones = new GetTimeZones();
        myTimeZones.readZonesFromFile();
        try {
            System.out.println(myTimeZones.convertDate("05:21:34", "India Standard Time"));
        }catch (Exception e){
            System.out.println("Zly format liczby!");
        }
    }
}
