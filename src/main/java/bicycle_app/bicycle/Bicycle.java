package bicycle_app.bicycle;

import bicycle_app.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Bicycle {
    @Id
    @GeneratedValue(generator = "bicyclegen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bicyclegen", initialValue = 1, allocationSize = 1, sequenceName = "bicycle_seq")

    private Long bicycleId;
    private String bicycleName;
    private String bicycleColor;
    private String bicycleModel;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonIgnoreProperties("bicycles")
    private Manufacturer manufacturer;

    public Bicycle() {

    }

    public Bicycle(String bicycleName, String bicycleColor, String bicycleModel) {
        this.bicycleName = bicycleName;
        this.bicycleColor = bicycleColor;
        this.bicycleModel = bicycleModel;
    }

    public Bicycle(Long bicycleId, String bicycleName, String bicycleColor, String bicycleModel) {
        this.bicycleId = bicycleId;
        this.bicycleName = bicycleName;
        this.bicycleColor = bicycleColor;
        this.bicycleModel = bicycleModel;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBicycleModel() {
        return bicycleModel;
    }

    public void setBicycleModel(String bicycleModel) {
        this.bicycleModel = bicycleModel;
    }

    public String getBicycleColor() {
        return bicycleColor;
    }

    public void setBicycleColor(String bicycleColor) {
        this.bicycleColor = bicycleColor;
    }

    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public Long getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Long bicycleId) {
        this.bicycleId = bicycleId;
    }
}
