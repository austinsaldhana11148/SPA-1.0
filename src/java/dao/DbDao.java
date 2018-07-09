/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Customer;
import beans.Employee;
import beans.Attendance;
import beans.AttendanceReport;
import beans.BranchDetails;
import beans.BranchPackageDetails;
import beans.BranchPackages;
import beans.BranchServiceDetails;
import beans.BranchServices;
import beans.CustomerPackagesInfo;
import beans.DailyBilling;
import beans.Login;
import beans.Package;
import beans.Service;
import cart.CartInfo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

/**
 *
 * @author Austin
 */
public class DbDao {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/spa";
    private static String user = "root";
    private static String pass = "";
    private PreparedStatement ps = null;

    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public int insertCustomer(String name, String mobile, String address, String email_address, String gender) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into customer(`name`, `mobile`, `address`, `email_address`, `gender`) values(?, ?, ?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setString(3, address);
            ps.setString(4, email_address);
            ps.setString(5, gender);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }
    
    public int updateCustomer(String name, String mobile, String address, String email_address, String gender, int c_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update customer set name=?, mobile=?, address=?, email_address=?, gender=? where cid=?";
            ps = con.prepareStatement(qry);

            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setString(3, address);
            ps.setString(4, email_address);
            ps.setString(5, gender);
            ps.setInt(6, c_id);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }
    
    public int updateCustomerPackage(int cp_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update customer_package set start_date=?, services_left=services_left-1 where cpid=?";
            ps = con.prepareStatement(qry);

            ps.setTimestamp(1, CartInfo.getCurrentTimestamp());
            ps.setInt(2, cp_id);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public Customer getCustomer(int c_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;

        try {
            String qry = "select * from customer where cid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, c_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Customer();

                c.setC_id(rs.getInt("cid"));
                c.setName(rs.getString("name"));
                c.setMobile(rs.getString("mobile"));
                c.setAddress(rs.getString("address"));
                c.setEmail_address(rs.getString("email_address"));
                c.setGender(rs.getString("gender"));

                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public ArrayList<Customer> customerList() {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Customer> list = new ArrayList<>();
        try {
            String qry = "select * from customer";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();

            while (rs.next()) {
                Customer c = new Customer();
                
                c.setC_id(rs.getInt("cid"));
                c.setName(rs.getString("name"));
                c.setMobile(rs.getString("mobile"));
                c.setAddress(rs.getString("address"));
                c.setEmail_address(rs.getString("email_address"));
                c.setGender(rs.getString("gender"));
                
                list.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Customer List Error = " + ex);
        }
        return list;

    }

    //Employee
    public int insertEmployee(String name, String email, String gender, String address, String mobile, int b_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into employee(`name`, `email`, `gender`, `address`,`mobile`,`status`,`bid`) values(?, ?, ?, ?, ?, ?,?)";
            ps = con.prepareStatement(qry);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, gender);
            ps.setString(4, address);
            ps.setString(5, mobile);
            ps.setInt(6, 1);
            ps.setInt(7, b_id);

            i = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public int updateEmployee(String name, String email, String address, String gender, String mobile, int e_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update employee set name=?, email=?, address=?, gender=?, mobile=? where eid=?";
            ps = con.prepareStatement(qry);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, gender);
            ps.setString(5, mobile);
            ps.setInt(6, e_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public int deactivateEmployee(int e_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update employee set status=0 where eid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, e_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public Employee getEmployee(int e_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee e = null;

        try {
            String qry = "select * from employee where eid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, e_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                e = new Employee();

                e.setE_id(rs.getInt("eid"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setGender(rs.getString("gender"));
                e.setAddress(rs.getString("address"));
                e.setMobile(rs.getString("mobile"));
                e.setStatus(rs.getInt("status"));
                e.setB_id(rs.getInt("bid"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public ArrayList<Employee> employeeList() {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Employee> list = null;
        try {
            String qry = "select * from employee where status=1";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();

            list = new ArrayList<>();

            while (rs.next()) {
                Employee e = new Employee();
                e.setE_id(rs.getInt("eid"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setGender(rs.getString("gender"));
                e.setAddress(rs.getString("address"));
                e.setMobile(rs.getString("mobile"));
                e.setStatus(rs.getInt("status"));
                e.setB_id(rs.getInt("bid"));
                list.add(e);

            }
        } catch (SQLException ex) {
            System.err.println("Emp List Error = " + ex);
        }
        return list;

    }

    //Package
    public int insertPackage(String package_name, int s_id, int no_of_services, int duration, float rate) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into package(`package_name`,`sid`, `no_of_services`,`duration`,`rate`) values(?, ?, ?,?,?)";
            ps = con.prepareStatement(qry);

            ps.setString(1, package_name);
            ps.setInt(2, s_id);
            ps.setInt(3, no_of_services);
            ps.setInt(4, duration);
            ps.setFloat(5, rate);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public int updatePackage(String package_name, int s_id, int no_of_services, int duration, float rate, int p_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update package set package_name=?, sid=?, no_of_services=?, duration=?, rate=? where package_id=?";
            ps = con.prepareStatement(qry);

            ps.setString(1, package_name);
            ps.setInt(2, s_id);
            ps.setInt(3, no_of_services);
            ps.setInt(4, duration);
            ps.setFloat(5, rate);
            ps.setInt(6, p_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public Package getPackage(int p_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Package p = null;

        try {
            String qry = "select * from package where package_id=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, p_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Package();

                p.setPackage_id(rs.getInt("package_id"));
                p.setPackage_name(rs.getString("package_name"));
                p.setS_id(rs.getInt("sid"));
                p.setNo_of_services(rs.getInt("no_of_services"));
                p.setDuration(rs.getInt("duration"));
                p.setRate(rs.getInt("rate"));

                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }

    //branchServices
    public int insertBranchPackage(int b_id, int p_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into branch_packages(`bid`,`pid`) values(?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, b_id);
            ps.setInt(2, p_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public ArrayList<Package> packageList() {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Package> list = new ArrayList<>();
        try {
            String qry = "select * from package";

            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();
            
            while (rs.next()) {
                Package p = new Package();

                p.setPackage_id(rs.getInt("package_id"));
                p.setPackage_name(rs.getString("package_name"));
                p.setS_id(rs.getInt("sid"));
                p.setNo_of_services(rs.getInt("no_of_services"));
                p.setDuration(rs.getInt("duration"));
                p.setRate(rs.getInt("rate"));
                list.add(p);

            }
        } catch (SQLException ex) {
            System.err.println("Package List Error = " + ex);
        }
        return list;

    }

    public ArrayList<BranchPackageDetails> getBranchPackageDetailsList(int b_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<BranchPackageDetails> list = new ArrayList<>();
        try {
            String qry = "select bp.bp_id, bp.bid, bp.pid, p.package_name, p.rate, bp.discount from package p, branch_packages bp where p.package_id=bp.pid and bp.bid=?";
            ps = con.prepareStatement(qry);
            ps.setInt(1, b_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                BranchPackageDetails bs = new BranchPackageDetails();

                bs.setBp_id(rs.getInt("bp_id"));
                bs.setB_id(rs.getInt("bid"));
                bs.setP_id(rs.getInt("pid"));
                bs.setPackage_name(rs.getString("package_name"));
                bs.setPrice(rs.getFloat("rate"));
                bs.setDiscount(rs.getFloat("discount"));

                list.add(bs);

            }
        } catch (SQLException ex) {
            System.err.println("Service List Error = " + ex);
        }
        return list;

    }

    public ArrayList<Package> packageList(int b_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Package> list = new ArrayList<>();
        try {
            String qry = "select * from package where package_id in(select pid from branch_packages where bid=?)";
            ps = con.prepareStatement(qry);
            ps.setInt(1, b_id);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Package p = new Package();
                
                p.setPackage_id(rs.getInt("package_id"));
                p.setPackage_name(rs.getString("package_name"));
                p.setS_id(rs.getInt("sid"));
                p.setNo_of_services(rs.getInt("no_of_services"));
                p.setDuration(rs.getInt("duration"));
                p.setRate(rs.getFloat("rate"));

                list.add(p);
            }
        } catch (SQLException ex) {
            System.err.println("Package List Error = " + ex);
        }
        return list;

    }

    public int deletePackage(int p_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "delete from package where package_id=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, p_id);

            i = ps.executeUpdate();

            i = deleteCustomerPackage(p_id);
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public int deleteCustomerPackage(int p_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "delete from customer_package where package_id=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, p_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    //services
    public int insertService(String service_name, float service_time, float price) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into service(`service_name`,`service_time`, `price`) values(?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setString(1, service_name);
            ps.setFloat(2, service_time);
            ps.setFloat(3, price);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public int updateService(String service_name, float service_time, float price, int s_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update service set service_name=?, service_time=?, price=? where sid=?";
            ps = con.prepareStatement(qry);

            ps.setString(1, service_name);
            ps.setFloat(2, service_time);
            ps.setFloat(3, price);
            ps.setInt(4, s_id);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public int deleteService(int s_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "delete from service where sid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, s_id);

            i = ps.executeUpdate();

            i = deleteBranchService(s_id);
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }
    
    public int updateBranchService(float discount, int bs_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update branch_services set discount=? where bsid=?";
            ps = con.prepareStatement(qry);

            ps.setFloat(1, discount);
            ps.setInt(2, bs_id);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        System.out.println("dis = "+ discount + ", bsis="+bs_id);
        return i;
    }
    
    public BranchServices getBranchService(int bs_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        BranchServices s = null;

        try {
            String qry = "select * from branch_services where bsid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, bs_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                s = new BranchServices();

                s.setBs_id(rs.getInt("bsid"));
                s.setS_id(rs.getInt("sid"));
                s.setB_id(rs.getInt("bid"));
                s.setDiscount(rs.getFloat("discount"));

                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return s;
    }

    
    public BranchPackages getBranchPackages(int bp_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        BranchPackages bp = null;

        try {
            String qry = "select * from branch_packages where bp_id=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, bp_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                bp = new BranchPackages();

                bp.setBp_id(rs.getInt("bp_id"));
                bp.setP_id(rs.getInt("pid"));
                bp.setB_id(rs.getInt("bid"));
                bp.setDiscount(rs.getFloat("discount"));

                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return bp;
    }

    public int deleteBranchService(int s_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "delete from branch_services where sid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, s_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public Service getService(String service_name) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Service s = null;

        try {
            String qry = "select * from service where service_name=?";
            ps = con.prepareStatement(qry);

            ps.setString(1, service_name);

            rs = ps.executeQuery();

            while (rs.next()) {
                s = new Service();

                s.setS_id(rs.getInt("sid"));
                s.setService_name(rs.getString("service_name"));
                s.setService_time(rs.getFloat("service_time"));
                s.setPrice(rs.getFloat("price"));

                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return s;
    }

    public Service getService(int s_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Service s = null;

        try {
            String qry = "select * from service where sid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, s_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                s = new Service();

                s.setS_id(rs.getInt("sid"));
                s.setService_name(rs.getString("service_name"));
                s.setService_time(rs.getFloat("service_time"));
                s.setPrice(rs.getFloat("price"));

                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return s;
    }

    public ArrayList<Service> serviceList() {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Service> list = new ArrayList<>();
        try {
            String qry = "select * from service";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();
            
            while (rs.next()) {
                Service s = new Service();

                s.setS_id(rs.getInt("sid"));
                s.setService_name(rs.getString("service_name"));
                s.setService_time(rs.getFloat("service_time"));
                s.setPrice(rs.getFloat("price"));
                
                list.add(s);

            }
        } catch (SQLException ex) {
            System.err.println("Service List Error = " + ex);
        }
        return list;

    }
    
    public ArrayList<Service> serviceList(int b_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Service> list = new ArrayList<>();
        try {
            String qry = "select * from service where sid in(select sid from branch_services where bid=?)";
            ps = con.prepareStatement(qry);
            ps.setInt(1, b_id);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Service s = new Service();

                s.setS_id(rs.getInt("sid"));
                s.setService_name(rs.getString("service_name"));
                s.setService_time(rs.getFloat("service_time"));
                s.setPrice(rs.getFloat("price"));
                list.add(s);

            }
        } catch (SQLException ex) {
            System.err.println("Service List Error = " + ex);
        }
        return list;

    }

    public ArrayList<BranchServiceDetails> getBranchServiceDetailsList(int b_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<BranchServiceDetails> list = new ArrayList<>();
        try {
            String qry = "select bs.bsid, bs.bid, bs.sid, s.service_name, s.price, bs.discount from service s, branch_services bs where s.sid=bs.sid and bs.bid=?";
            ps = con.prepareStatement(qry);
            ps.setInt(1, b_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                BranchServiceDetails bs = new BranchServiceDetails();

                bs.setBs_id(rs.getInt("bsid"));
                bs.setB_id(rs.getInt("bid"));
                bs.setS_id(rs.getInt("sid"));
                bs.setService_name(rs.getString("service_name"));
                bs.setPrice(rs.getFloat("price"));
                bs.setDiscount(rs.getFloat("discount"));

                list.add(bs);

            }
        } catch (SQLException ex) {
            System.err.println("Service List Error = " + ex);
        }
        return list;

    }

    //login
    public int checkUser(String username, String password) throws SQLException {
        int i = -2, eid = 0, status = 0;
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String user_type = null;
        Login l = getUser(username);
        eid = l.getE_id();
        user_type = l.getUser_type();
        if (user_type.equalsIgnoreCase("owner")) {

            if (l == null) {
                i = -1;
            } else if (l.getPassword().equals(password)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
            String qry = "select status from employee where eid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, eid);

            rs = ps.executeQuery();

            while (rs.next()) {
                status = rs.getInt("status");
            }
            if (status == 1) {

                if (l == null) {
                    i = -1;
                } else if (l.getPassword().equals(password)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = -2;
            }

        }
        return i;
    }

    public Login getUser(String username) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Login l = null;

        try {
            String qry = "select * from login where username=?";
            ps = con.prepareStatement(qry);

            ps.setString(1, username);

            rs = ps.executeQuery();

            while (rs.next()) {
                l = new Login();

                l.setL_id(rs.getInt("lid"));
                l.setUsername(rs.getString("username"));
                l.setPassword(rs.getString("password"));
                l.setUser_type(rs.getString("user_type"));
                l.setE_id(rs.getInt("eid"));

                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }

    //branchDetails
    public int insertBranchDetails(String branch_name, String mobile, String address, int bm_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into branch_details(`branch_name`,`mobile`, `address`,`bm_id`) values(?, ?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setString(1, branch_name);
            ps.setString(2, mobile);
            ps.setString(3, address);
            ps.setInt(4, bm_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    //branchEmployees
    public int insertBranchEmployees(int b_id, int e_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into branch_employees(`b_id`,`e_id`) values( ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, b_id);
            ps.setInt(2, e_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

//branchServices
    public int insertBranchServices(int b_id, int s_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into branch_services(`bid`,`sid`) values(?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, b_id);
            ps.setInt(2, s_id);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    //CustomerPackage
    public int updateBranchPackage(float discount, int bp_id) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "update branch_packages set discount=? where bp_id=?";
            ps = con.prepareStatement(qry);

            ps.setFloat(1, discount);
            ps.setInt(2, bp_id);

            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        //System.out.println("dis = "+ discount + ", bpid="+bp_id);
        return i;
    }
    
    public int insertCustomerPackage(int c_id, int package_id, Timestamp start_date, int services_left) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into customer_package(`cid`, `package_id`, `start_date`,`services_left`) values(?, ?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, c_id);
            ps.setInt(2, package_id);
            ps.setTimestamp(3, start_date);
            ps.setInt(4, services_left);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    //CustomerHistory
    public int insertCustomerHistory(int c_id, int b_id, int e_id, Timestamp date, float total_price, String pay_method, String cust_type) {
        Connection con = getConnection();
        @SuppressWarnings("UnusedAssignment")
        int i = -1;
        try {
            String qry = "insert into customer_history(`cid`, `bid`, `eid`, `date`, `total_price`, `pay_method`, `cust_type`) values(?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, c_id);
            ps.setInt(2, b_id);
            ps.setInt(3, e_id);
            ps.setTimestamp(4, date);
            ps.setFloat(5, total_price);
            ps.setString(6, pay_method);
            ps.setString(7, cust_type);
            
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public int insertBillDetails(int ch_id, String item_type, int id, float price) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into bill_details(`chid`, `item_type`, `id`, `price`) values(?, ?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, ch_id);
            ps.setString(2, item_type);
            ps.setInt(3, id);
            ps.setFloat(4, price);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

//attendance
    public ArrayList<Attendance> attendanceList() {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Attendance> list = null;
        try {
            String qry = "select * from service";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Attendance a = new Attendance();

                a.setA_id(rs.getInt("aid"));
                a.setPresent(rs.getInt("present"));
                a.setDate(rs.getTimestamp("date"));
                list.add(a);

            }
        } catch (SQLException ex) {
            System.err.println("Attendance List Error = " + ex);
        }
        return list;

    }

    public int insertAttendance(int e_id, Timestamp date, int present) {
        Connection con = getConnection();
        int i = -1;
        try {
            String qry = "insert into attendance(`eid`,`date`, `present`) values(?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, e_id);
            ps.setTimestamp(2, date);
            ps.setInt(3, present);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }

    public BranchDetails getBranchDetails(int b_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        BranchDetails bd = null;

        try {
            String qry = "select * from branch_details where bid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, b_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                bd = new BranchDetails();

                bd.setB_id(rs.getInt("bid"));
                bd.setName(rs.getString("branch_name"));
                bd.setMobile(rs.getString("mobile"));
                bd.setAddress(rs.getString("address"));
                bd.setBm_id(rs.getInt("bm_eid"));

                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bd;
    }

    public ArrayList<BranchDetails> getBranchDetailsList() {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<BranchDetails> list = new ArrayList();
        try {
            String qry = "select * from branch_details";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();

            while (rs.next()) {
                BranchDetails bd = new BranchDetails();

                bd.setB_id(rs.getInt("bid"));
                bd.setName(rs.getString("branch_name"));
                bd.setMobile(rs.getString("mobile"));
                bd.setAddress(rs.getString("address"));
                bd.setBm_id(rs.getInt("bm_eid"));

                list.add(bd);

            }
        } catch (SQLException ex) {
            System.err.println("Service List Error = " + ex);
        }
        return list;

    }

    /*
    returm list of branches which provides s_id service
     */
    public ArrayList<BranchDetails> getBranchDetailsList(int s_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<BranchDetails> list = new ArrayList();
        try {
            String qry = "SELECT * FROM `branch_details` WHERE bid in (SELECT bid from branch_services where sid = ?)";
            ps = con.prepareStatement(qry);
            ps.setInt(1, s_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                BranchDetails bd = new BranchDetails();

                bd.setB_id(rs.getInt("bid"));
                bd.setName(rs.getString("branch_name"));
                bd.setMobile(rs.getString("mobile"));
                bd.setAddress(rs.getString("address"));
                bd.setBm_id(rs.getInt("bm_eid"));

                list.add(bd);

            }
        } catch (SQLException ex) {
            System.err.println("Service List Error = " + ex);
        }
        return list;

    }

    /*
    returm list of branches which provides p_id package
     */
    public ArrayList<BranchDetails> getBranchDetailsList_Packages(int p_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<BranchDetails> list = new ArrayList();
        try {
            String qry = "SELECT * FROM `branch_details` WHERE bid in (SELECT bid from branch_packages where pid = ?)";
            ps = con.prepareStatement(qry);
            ps.setInt(1, p_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                BranchDetails bd = new BranchDetails();

                bd.setB_id(rs.getInt("bid"));
                bd.setName(rs.getString("branch_name"));
                bd.setMobile(rs.getString("mobile"));
                bd.setAddress(rs.getString("address"));
                bd.setBm_id(rs.getInt("bm_eid"));

                list.add(bd);

            }
        } catch (SQLException ex) {
            System.err.println("Service List Error = " + ex);
        }
        return list;

    }

    //attendance
    public Attendance getAttendance(int e_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Attendance a = null;
        
        try {
            Timestamp date = new Timestamp(new java.util.Date().getTime());
            date.setHours(9);
            date.setMinutes(0);
            date.setSeconds(0);
            
            String qry = "select * from attendance where eid=? and date>=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, e_id);
            ps.setTimestamp(2, date);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                a = new Attendance();

                a.setA_id(rs.getInt("aid"));
                a.setE_id(rs.getInt("eid"));
                a.setPresent(rs.getInt("present"));
                a.setDate(rs.getTimestamp("date"));

                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return a;
    }

    public ArrayList<Attendance> getAttendanceList() {
        Connection con = getConnection();
        ResultSet rs = null;
        Timestamp date = new Timestamp(new java.util.Date().getTime());

        ArrayList<Attendance> list = new ArrayList<>();
        try {
            String qry = "select * from attendance where date=?";
            ps = con.prepareStatement(qry);
            ps.setTimestamp(1, date);

            rs = ps.executeQuery();

            while (rs.next()) {
                Attendance a = new Attendance();

                a.setA_id(rs.getInt("aid"));
                a.setE_id(rs.getInt("eid"));
                a.setPresent(rs.getInt("present"));
                a.setDate(rs.getTimestamp("date"));

                list.add(a);

            }
        } catch (SQLException ex) {
            System.err.println("Attendance List Error = " + ex);
        }
        return list;

    }

    public int insertAttendance(int e_id, int present) {
        Connection con = getConnection();
        Timestamp date = new Timestamp(new java.util.Date().getTime());
        
        int i = -1;
        try {

            String qry = "insert into attendance(`eid`, `date`, `present`) values(?, ?, ?)";
            ps = con.prepareStatement(qry);

            ps.setInt(1, e_id);
            ps.setTimestamp(2, date);
            ps.setInt(3, present);

            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            i = -1;
        }

        return i;
    }
    
    //attendanceReport
    public ArrayList<AttendanceReport> getAttendanceReport(Date start_date,Date end_date,int b_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        int eid=-1;
        ArrayList<AttendanceReport>  list = new ArrayList<>();
        ArrayList<Employee> emp_list = null;
        DbDao db=new DbDao();
        try {
            emp_list=db.getEmployeeList(b_id);
            for(Employee e: emp_list)
            {
           eid=e.getE_id();
            
            CallableStatement ct = con.prepareCall("{call attendance_report(?, ?,?)}");
            
            ct.setDate(1, (java.sql.Date) start_date);
            ct.setDate(2, (java.sql.Date) end_date);
            ct.setInt(3, eid);

            rs = ct.executeQuery();

            while (rs.next()) {
               AttendanceReport ar = new AttendanceReport();
               ar.setEid(rs.getInt("eid"));
               ar.setEname(rs.getString("ename"));
               ar.setTotal_present(rs.getInt("total_present"));
               ar.setTotal_absent(rs.getInt("total_absent"));
               ar.setTotal(rs.getInt("total"));
                list.add(ar);
                System.out.println("s "+start_date+" "+end_date);
            }
            }
        } catch (SQLException ex) {
            System.err.println("Attendance Report List Error = " + ex);
        }
        return list;

    }

    public ArrayList<Employee> getEmployeeList(int b_id) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String qry = "select * from employee where status=1 and bid=? order by name asc";
            ps = con.prepareStatement(qry);
            ps.setInt(1, b_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setE_id(rs.getInt("eid"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setGender(rs.getString("gender"));
                e.setAddress(rs.getString("address"));
                e.setMobile(rs.getString("mobile"));
                e.setStatus(rs.getInt("status"));
                e.setB_id(rs.getInt("bid"));
                
                list.add(e);

            }
        } catch (SQLException ex) {
            System.err.println("Emp List Error = " + ex);
        }
        return list;

    }
    
    public int getLatestCustomerHistoryId(int c_id, int b_id, int e_id, Timestamp date) {
        int chid = -1;
        Connection con = getConnection();
        ResultSet rs = null;
        
        try {
            String qry = "select chid from customer_history where cid=? and bid=? and eid=? and date=? order by chid desc";
            ps = con.prepareStatement(qry);
            ps.setInt(1, c_id);
            ps.setInt(2, b_id);
            ps.setInt(3, e_id);
            ps.setTimestamp(4, date);

            rs = ps.executeQuery();
            
            while(rs.next()) {
                chid = rs.getInt("chid");
            }
            
        } catch (Exception e) {
            chid = 0;
        }
        
        return chid;
    }    
    
    public ArrayList<CustomerPackagesInfo> getCustomerPackages(int c_id) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<CustomerPackagesInfo> list = new ArrayList<>();

        try {
            String qry = "SELECT * FROM `customer_package` cp,`package` p WHERE cp.package_id=p.package_id and cp.cid=?";
            ps = con.prepareStatement(qry);

            ps.setInt(1, c_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                CustomerPackagesInfo cp = new CustomerPackagesInfo();

                cp.setCp_id(rs.getInt("cpid"));
                cp.setC_id(rs.getInt("cid"));
                cp.setPackage_id(rs.getInt("package_id"));
                cp.setStart_date(rs.getTimestamp("start_date"));
                cp.setServices_left(rs.getInt("services_left"));
                cp.setPackage_name(rs.getString("package_name"));
                cp.setS_id(rs.getInt("sid"));
                cp.setNo_of_services(rs.getInt("no_of_services"));
                cp.setDuration(rs.getInt("duration"));
                cp.setRate(rs.getFloat("rate"));

                list.add(cp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    
    public ArrayList<DailyBilling> getDailyBillingList() {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<DailyBilling> list = new ArrayList<>();
        try {
            String qry = "select * from customer_history ch, bill_details bd where bd.chid = ch.chid order by date desc";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();

            while (rs.next()) {
                DailyBilling e = new DailyBilling();
                
                e.setCh_id(rs.getInt("chid"));
                e.setCust_id(rs.getInt("cid"));
                e.setB_id(rs.getInt("bid"));
                e.setE_id(rs.getInt("eid"));
                e.setTime(rs.getTimestamp("date"));
                e.setPay_method(rs.getString("pay_method"));
                e.setClient_detail(rs.getString("cust_type"));
                e.setItem_type(rs.getString("item_type"));
                e.setId(rs.getInt("id"));
                e.setAmount(rs.getFloat("price"));
                
                list.add(e);

            }
        } catch (SQLException ex) {
            System.err.println("Daily List Error = " + ex);
        }
        return list;

    }
    
    public ArrayList<DailyBilling> getBranchWiseDailyBillingList(int b_id, Timestamp _st, Timestamp _end) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<DailyBilling> list = new ArrayList<>();
        try {
            String qry = "select * from customer_history ch, bill_details bd where bd.chid = ch.chid order by date desc";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();

            while (rs.next()) {
                DailyBilling e = new DailyBilling();
                
                e.setCh_id(rs.getInt("chid"));
                e.setCust_id(rs.getInt("cid"));
                e.setB_id(rs.getInt("bid"));
                e.setE_id(rs.getInt("eid"));
                e.setTime(rs.getTimestamp("date"));
                e.setPay_method(rs.getString("pay_method"));
                e.setClient_detail(rs.getString("cust_type"));
                e.setItem_type(rs.getString("item_type"));
                e.setId(rs.getInt("id"));
                e.setAmount(rs.getFloat("price"));
                
                if(e.getB_id() == b_id && e.getTime().compareTo(_st)>=0 && e.getTime().compareTo(_end)<=0)
                    list.add(e);

            }
        } catch (SQLException ex) {
            System.err.println("Daily List Error = " + ex);
        }
        return list;

    }
    
    public ArrayList<DailyBilling> getEmployeeWiseDailyBillingList(int e_id, Timestamp _st, Timestamp _end) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<DailyBilling> list = new ArrayList<>();
        try {
            String qry = "select * from customer_history ch, bill_details bd where bd.chid = ch.chid order by date desc";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();

            while (rs.next()) {
                DailyBilling e = new DailyBilling();
                
                e.setCh_id(rs.getInt("chid"));
                e.setCust_id(rs.getInt("cid"));
                e.setB_id(rs.getInt("bid"));
                e.setE_id(rs.getInt("eid"));
                e.setTime(rs.getTimestamp("date"));
                e.setPay_method(rs.getString("pay_method"));
                e.setClient_detail(rs.getString("cust_type"));
                e.setItem_type(rs.getString("item_type"));
                e.setId(rs.getInt("id"));
                e.setAmount(rs.getFloat("price"));
                
                if(e.getE_id() == e_id && e.getTime().compareTo(_st)>=0 && e.getTime().compareTo(_end)<=0)
                    list.add(e);

            }
        } catch (SQLException ex) {
            System.err.println("Daily List Error = " + ex);
        }
        return list;

    }
    
    public ArrayList<DailyBilling> getOverAllDailyBillingList(Timestamp _st, Timestamp _end) {
        Connection con = getConnection();
        ResultSet rs = null;
        ArrayList<DailyBilling> list = new ArrayList<>();
        try {
            String qry = "select * from customer_history ch, bill_details bd where bd.chid = ch.chid order by date desc";
            ps = con.prepareStatement(qry);

            rs = ps.executeQuery();

            while (rs.next()) {
                DailyBilling e = new DailyBilling();
                
                e.setCh_id(rs.getInt("chid"));
                e.setCust_id(rs.getInt("cid"));
                e.setB_id(rs.getInt("bid"));
                e.setE_id(rs.getInt("eid"));
                e.setTime(rs.getTimestamp("date"));
                e.setPay_method(rs.getString("pay_method"));
                e.setClient_detail(rs.getString("cust_type"));
                e.setItem_type(rs.getString("item_type"));
                e.setId(rs.getInt("id"));
                e.setAmount(rs.getFloat("price"));
                
                if(e.getTime().compareTo(_st)>=0 && e.getTime().compareTo(_end)<=0)
                    list.add(e);

            }
        } catch (SQLException ex) {
            System.err.println("Daily List Error = " + ex);
        }
        return list;

    }
    
    public static void main(String args[]) {
        ArrayList<Package> p = new DbDao().packageList();
        System.out.println("list: "+p);
    }
}
