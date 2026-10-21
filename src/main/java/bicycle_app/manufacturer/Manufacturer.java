package bicycle_app.manufacturer;

import bicycle_app.bicycle.Bicycle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(generator = "manufacturergen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "manufacturergen", sequenceName = "manufacturer_seq", allocationSize = 1)

    private Long manufacturerId;
    private String manufacturerWebsite;
    private String manufacturerPhoneNumber;
    private String manufacturerName;

    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnoreProperties("manufacturer")
    private List<Bicycle> bicycles;

    public Manufacturer() {

    }

    public Manufacturer(String manufacturerWebsite, String manufacturerPhoneNumber, String manufacturerName) {
        this.manufacturerWebsite = manufacturerWebsite;
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
        this.manufacturerName = manufacturerName;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerWebsite() {
        return manufacturerWebsite;
    }

    public void setManufacturerWebsite(String manufacturerWebsite) {
        this.manufacturerWebsite = manufacturerWebsite;
    }

    public String getManufacturerPhoneNumber() {
        return manufacturerPhoneNumber;
    }

    public void setManufacturerPhoneNumber(String manufacturerPhoneNumber) {
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }
}
