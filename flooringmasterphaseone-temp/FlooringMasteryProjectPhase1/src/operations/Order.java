/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author Dessa && Anthony
 */
public class Order {
    final int ORDER_NUMBER;
    private String customerName, state, productType, date;
    private double taxRate, area, costPerSqFt, laborCostPerSqFt, tax, total, subtotal, materialCost, laborCost;

    public Order(int orderNumber, String date, String customerName, String state, String productType,  double area, double taxRate,  double costPerSqFt, double laborCostPerSqFt) {
        this.ORDER_NUMBER = orderNumber;
        this.customerName = customerName;
        this.state = state;
        this.productType = productType;
        this.date = date;
        this.taxRate = taxRate;
        this.area = area;
        this.costPerSqFt = costPerSqFt;
        this.laborCostPerSqFt = laborCostPerSqFt;
        
        this.materialCost = area * costPerSqFt;
        this.laborCost = area * laborCostPerSqFt;
        this.subtotal = materialCost + laborCost;
        this.tax = subtotal * (taxRate/100);
        this.total = subtotal + tax;
    }

    public Order() {
        ORDER_NUMBER = 0;
        materialCost = 0;
        laborCost = 0;
        tax = 0;
        total = 0;
        subtotal = 0;
    }
    
    
    
    
    public int getOrderNumber() {
        return ORDER_NUMBER;
    }
/*
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
*/
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        tax = (taxRate/100)*subtotal;
        total = subtotal + tax;
        
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
        materialCost = area*costPerSqFt;
        laborCost = area*laborCostPerSqFt;
        subtotal = materialCost + laborCost;
        tax = (taxRate/100)*subtotal;
        total = tax + subtotal;
        
    }

    public double getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(double costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public double getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(double laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    
    public double getMaterialCost() {
        return materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public double getSubtotal() {
        return subtotal;
    }
    

    @Override
    public String toString() {
        String s = ORDER_NUMBER + "::" + customerName + "::" + state + "::" + 
                taxRate + "::" + productType + "::" + area + "::" + costPerSqFt +
                "::" + laborCostPerSqFt + "::" + materialCost + "::" + laborCost +
                "::" + tax + "::" + total;
        return s;
    }
}


/*private double taxRate, area, costPerSqFt, laborCostPerSqFt;
    final private double MATERIAL_COST, LABOR_COST, TAX, TOTAL, SUBTOTAL;*/