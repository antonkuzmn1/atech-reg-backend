package atech.reg.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Tools {

    public Date stringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = null;
        // System.out.println(dateString);
        try {
            date = dateFormat.parse(dateString);
            // System.out.println("SUCCESS: " + date);
        } catch (ParseException e) {
            // e.printStackTrace();
            try {
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat2.parse(dateString);
            // System.out.println();
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        return date;
    }

    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }
}
