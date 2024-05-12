package Final_exam;

import java.util.Date;

public class Package {
    private String targetLocation;
    private int targetDistanceInKm;
    private int packageValue;
    private String deliveryDate;

    public Package() {
    }

    public Package(String targetLocation, int targetDistanceInKm, int packageValue, String deliveryDate) {
        this.targetLocation = targetLocation;
        this.targetDistanceInKm = targetDistanceInKm;
        this.packageValue = packageValue;
        this.deliveryDate = deliveryDate;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public int getTargetDistanceInKm() {
        return targetDistanceInKm;
    }

    public void setTargetDistanceInKm(int targetDistanceInKm) {
        this.targetDistanceInKm = targetDistanceInKm;
    }

    public int getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(int packageValue) {
        this.packageValue = packageValue;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Package{" +
                "targetLocation='" + targetLocation + '\'' +
                ", targetDistanceInKm=" + targetDistanceInKm +
                ", packageValue=" + packageValue +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
