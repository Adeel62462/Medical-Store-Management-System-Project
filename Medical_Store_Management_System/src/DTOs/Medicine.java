package DTOs;

public class Medicine {
    int id, amount;
    String name, companyName, phone, email;
    double costPrice, salePrice;

    public Medicine(int id, String name, double costPrice, double salePrice, 
            int amount, String companyName, String phone, String email ) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    
    
}
