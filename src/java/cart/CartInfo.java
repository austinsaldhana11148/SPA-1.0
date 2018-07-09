/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import beans.Customer;
import beans.Service;
import beans.Package;
import dao.DbDao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import sms.SendSMS;

/**
 *
 * @author Administrator
 */
public class CartInfo {

    public static Customer cust = null;
    public static ArrayList<Service> services = new ArrayList<>();
    public static ArrayList<Package> packages = new ArrayList<>();
    
    public static void updateCustomerPackage(int cp_id) {
        DbDao db = new DbDao();
        db.updateCustomerPackage(cp_id);
        String sms = SendSMS.get_package_sms();
        try {
            SendSMS.sendSms(cust.getMobile(), sms);
        } catch (Exception ex) {
            Logger.getLogger(CartInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertData(String pay_method, String client_detail, float total_amt, int e_id) {
        DbDao db = new DbDao();
        int b_id = db.getEmployee(e_id).getB_id();
        
        Timestamp currentTimestamp = getCurrentTimestamp();
        db.insertCustomerHistory(cust.getC_id(), b_id, e_id, currentTimestamp, total_amt, pay_method, client_detail);
        
        int chid = db.getLatestCustomerHistoryId(cust.getC_id(), b_id, e_id, currentTimestamp);
        
        String packages_services = "";
        int i = 1;
        
        for(Service s : services) {
            db.insertBillDetails(chid, "service", s.getS_id(), s.getPrice());
            
            packages_services += i+"> "+s.getService_name()+"\n";
            i++;
        }
        
        for(Package p : packages) {
            db.insertBillDetails(chid, "package", p.getPackage_id(), p.getRate());
            db.insertCustomerPackage(cust.getC_id(), p.getPackage_id(), currentTimestamp, p.getNo_of_services());
            
            packages_services += i+"> "+p.getPackage_name()+"\n";
            i++;
        }
        
        String sms = SendSMS.get_check_out_sms(packages_services, total_amt);
        try {
            SendSMS.sendSms(cust.getMobile(), sms);
        } catch (Exception ex) {
            Logger.getLogger(CartInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Timestamp getCurrentTimestamp() {
        // 1) create a java calendar instance
        Calendar calendar = Calendar.getInstance();

        // 2) get a java.util.Date from the calendar instance.
        //    this date will represent the current instant, or "now".
        java.util.Date now = calendar.getTime();

        // 3) a java current time (now) instance
        Timestamp currentTimestamp = new Timestamp(now.getTime());
        
        return currentTimestamp;
    }
}
