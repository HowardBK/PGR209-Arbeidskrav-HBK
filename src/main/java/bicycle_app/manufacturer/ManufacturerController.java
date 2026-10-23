package bicycle_app.manufacturer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/manufacturer")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;


    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getManufacturers() {
        return ResponseEntity.ok(manufacturerService.getManufacturers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable Long id) {
        return ResponseEntity.ok(manufacturerService.getManufacturer(id));
    }

    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
        return ResponseEntity.ok(manufacturerService.createManufacturer(manufacturer));
    }

    @PutMapping
    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody Manufacturer manufacturer) {
        return ResponseEntity.ok(manufacturerService.updateManufacturer(manufacturer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteManufacturer(@PathVariable long id){
        manufacturerService.deleteManufacturer(id);
        return ResponseEntity.ok("Deleted manufacturer with id: " + id);
    }
}
