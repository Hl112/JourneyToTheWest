/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamhdt.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import main.UI;

/**
 *
 * @author HL
 */
public class DigitalWatch implements Runnable {

    private String toString = "";
    Thread t = null;

    public DigitalWatch() {
       t = new Thread(this);
       t.start();
    }

    @Override
    public void run() {
        try {
          while(true){
              Calendar cal = Calendar.getInstance();
              SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
              Date date = cal.getTime();
              toString = sdf.format(date);
              UI.showTime(toString);
              t.sleep(1000);
          }
        } catch (Exception e) {
        }
    }
}
