package labEx3;

// Abstract class representing a general appliance service request
abstract class ApplianceServiceRequest {
    private String applianceType;
    private String customerName;
    private double serviceFee;

    // Constructor
    public ApplianceServiceRequest(String applianceType, String customerName, double serviceFee) {
        this.applianceType = applianceType;
        this.customerName = customerName;
        this.serviceFee = serviceFee;
    }

    // Abstract method to calculate the total service cost
    public abstract double calculateTotalCost();

    // Getters and setters
    public String getApplianceType() {
        return applianceType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getServiceFee() {
        return serviceFee;
    }
}

// Concrete class representing a standard appliance service request
class StandardApplianceServiceRequest extends ApplianceServiceRequest {
    // Constructor
    public StandardApplianceServiceRequest(String applianceType, String customerName, double serviceFee) {
        super(applianceType, customerName, serviceFee);
    }

    // Implementing the abstract method to calculate the total service cost
    @Override
    public double calculateTotalCost() {
        // Standard service cost calculation logic
        return getServiceFee();
    }
}

// Concrete class representing a premium appliance service request
final class PremiumApplianceServiceRequest extends ApplianceServiceRequest {
    private String specialService;

    // Constructor
    public PremiumApplianceServiceRequest(String applianceType, String customerName, double serviceFee, String specialService) {
        super(applianceType, customerName, serviceFee);
        this.specialService = specialService;
    }

    // Implementing the abstract method to calculate the total service cost
    @Override
    public double calculateTotalCost() {
        // Premium service cost calculation logic, considering special services
        return getServiceFee() * 1.2;
    }

    // Getter for special service
    public String getSpecialService() {
        return specialService;
    }
}

// Example of using the ApplianceService application
public class ApplianceServiceApp {
    public static void main(String[] args) {
        // Creating a standard appliance service request
        StandardApplianceServiceRequest standardRequest = new StandardApplianceServiceRequest("Refrigerator", "John Doe", 50.0);
        System.out.println("Standard Appliance Service - Total Cost: $" + standardRequest.calculateTotalCost());

        // Creating a premium appliance service request
        PremiumApplianceServiceRequest premiumRequest = new PremiumApplianceServiceRequest("Washing Machine", "Jane Smith", 80.0, "Express Repair");
        System.out.println("Premium Appliance Service - Total Cost: $" + premiumRequest.calculateTotalCost() + " - Special Service: " + premiumRequest.getSpecialService());
    }
}

