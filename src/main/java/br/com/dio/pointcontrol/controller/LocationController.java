package br.com.dio.pointcontrol.controller;

import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.Location;
import br.com.dio.pointcontrol.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.save(location);
    }

    @GetMapping
    public List<Location> getLocationList(){
        return locationService.findAll();
    }

    @GetMapping("/{idLocation}")
    public Location getLocationById(@PathVariable("idLocation") Long idLocation) throws Exception {
        return locationService.findById(idLocation).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/{idLocation}")
    public ResponseEntity deleteByID(@PathVariable("idLocation") Long idLocation) throws Exception {
        try {
            locationService.deleteLocation(idLocation);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
