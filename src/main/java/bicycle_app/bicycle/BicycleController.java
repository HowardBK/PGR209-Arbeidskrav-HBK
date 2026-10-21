package bicycle_app.bicycle;

import bicycle_app.manufacturer.Manufacturer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bicycle")

public class BicycleController {
    private final BicycleService bicycleService;

    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Bicycle> getBicycle(@PathVariable long id) {
        Bicycle bicycle = bicycleService.findBicycle(id);
        if (bicycle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bicycle);
    }

    @GetMapping
    public ResponseEntity<List<Bicycle>> getAllBicycles() {
        return ResponseEntity.ok(bicycleService.findAllBicycles());
    }

    @PostMapping
    public ResponseEntity<Bicycle> postBicycle(@RequestBody Bicycle bicycle) {
        var result = bicycleService.addBicycle(bicycle);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Bicycle>> postBicycles(@RequestBody List<Bicycle> bicycles) {
        var result = bicycleService.addBicycles(bicycles);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/relation")
    public ResponseEntity<Bicycle> changeRelation(@RequestBody BicycleManufacturerRelationRequest bicycleManufacturerRelationRequest) {
        if (bicycleManufacturerRelationRequest.bicycleId() == null || bicycleManufacturerRelationRequest.manufacturerId() == null) {
            return ResponseEntity.notFound().build();
        }

        var result = bicycleService.changeManufacturerRelation(bicycleManufacturerRelationRequest);

        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);

    }


    @PutMapping()
    public ResponseEntity<Bicycle> updateBicycle(@RequestBody Bicycle bicycle) {
        var result = bicycleService.updateBicycle(bicycle);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBicycle(@PathVariable long id) {
        bicycleService.deleteBicycle(id);
        return ResponseEntity.ok("Bicycle with id: " + id + " deleted.");
    }
}
