package bicycle_app.bicycle;

import bicycle_app.manufacturer.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {
    private final BicycleRepository bicycleRepository;
    private final ManufacturerService manufacturerService;


    public BicycleService(BicycleRepository bicycleRepository, ManufacturerService manufacturerService) {
        this.bicycleRepository = bicycleRepository;
        this.manufacturerService = manufacturerService;
    }

    public Bicycle addBicycle(Bicycle bicycle) {
        return bicycleRepository.save(bicycle);
    }

    public Bicycle findBicycle(long id) {
        return bicycleRepository.findById(id).orElse(null);
    }

    public List<Bicycle> addBicycles(List<Bicycle> bicycles) {
        return bicycleRepository.saveAll(bicycles);
    }

    public List<Bicycle> findAllBicycles() {
        return bicycleRepository.findAll();
    }

    public Bicycle updateBicycle(Bicycle bicycle) {
        return bicycleRepository.save(bicycle);
    }

    public void deleteBicycle(Long id) {
        bicycleRepository.deleteById(id);
    }

    public Bicycle changeManufacturerRelation(BicycleManufacturerRelationRequest bicycleManufacturerRelationRequest){
        var bicycle = bicycleRepository.findById(bicycleManufacturerRelationRequest.bicycleId()).orElse(null);
        var manufacturer = manufacturerService.getManufacturer(bicycleManufacturerRelationRequest.manufacturerId());
        if (bicycle == null || manufacturer == null) {
            return null;
        }

        bicycle.setManufacturer(manufacturer);
        return bicycleRepository.save(bicycle);
    }

}
