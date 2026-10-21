package bicycle_app.manufacturer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public Manufacturer getManufacturer(Long id) {
        return manufacturerRepository.findById(id).orElse(null);
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }

}
