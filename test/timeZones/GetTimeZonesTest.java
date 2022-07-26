package timeZones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class GetTimeZonesTest {

    public static Collection<Object[]> getTimeZoneDataProvider(){
        return Arrays.asList(new Object[][]{
                {"Australian Central Standard Time", "23:54:34", "09:24:34"},
                {"Australian Eastern Standard Time", "12:00:56", "22:00:56"},
                {"Alaska Standard Time", "01:45:34", "16:45:34"},
                {"Brasilia Time (Sao Paulo, Rio De Janeiro)", "01:00:00", "22:00:00"},
                {"British Summer Time", "12:24:04", "13:24:04"},
                {"Central Africa Time\" >Central Africa Time", "23:45:00", "01:45:00"},
                {"Central European Time", "05:00:34", "06:00:34"},
                {"Central Standard Time (North America)", "05:00:34", "23:00:34"},
                {"East Africa Time", "23:53:34", "02:53:34"},
                {"Eastern European Time", "15:56:12", "17:56:12"},
                {"Eastern Standard Time (North America)", "02:54:34", "21:54:34"},
                {"Greenwich Mean Time", "14:34:00", "14:34:00"},
                {"Hawaii Standard Time", "09:34:34", "23:34:34"},
                {"India Standard Time", "23:35:00", "05:05:00"},
                {"Irish Summer Time", "12:00:00", "13:00:00"},
                {"Israel Standard Time", "13:34:45", "15:34:45"},
                {"Japan Standard Time", "14:56:34", "23:56:34"},
                {"Moscow Standard Time (Russia time zone 2)", "23:34:32", "02:34:32"},
                {"Mountain Standard Time (North America)", "23:23:43", "16:23:43"},
                {"Pacific Standard Time (North America)", "23:23:43", "15:23:43"},
                {"Singapore Time", "12:34:00", "20:34:00"},
                {"West Africa Time", "23:34:00", "00:34:00"}
        });
    }

    @ParameterizedTest
    @MethodSource("getTimeZoneDataProvider")
    public void parTest(String timeZone, String myDate, String ans){
        IGetTimeZones myTimeZones = new GetTimeZones();
        myTimeZones.readZonesFromFile();
        try{
            assertEquals(ans, myTimeZones.convertDate(myDate, timeZone));
        }catch (Exception e){
            System.out.println("Zly format liczby!");
        }

    }
}