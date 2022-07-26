package timeZones;

import java.io.FileNotFoundException;
import java.util.Vector;

public interface IGetTimeZones {
     public void readZonesFromFile();
     public String convertDate(String myDate, String whichTimeZone) throws Exception;
     public Vector<Pair<String,String>> getTimeZones();
}
