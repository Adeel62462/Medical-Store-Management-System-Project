package DTOs;

/**
 *
 * @author Adeel
 */
public class Sales {
    int id;
    String customer, mobile, date;
    double total;

    public Sales(int id, String customer, String mobile, String date, double total) {
        this.id = id;
        this.customer = customer;
        this.mobile = mobile;
        this.date = date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
