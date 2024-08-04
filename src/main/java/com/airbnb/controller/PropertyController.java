package com.airbnb.controller;

import com.airbnb.model.Property;
import com.airbnb.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyController {


    @Autowired
    PropertyService propertyService;

    @PostMapping("/properties")
    public Property addProperty(@RequestBody Property property){
        return propertyService.addProperty(property);
    }

    @GetMapping("/properties")
    public List<Property> getAllProperties(){
        return propertyService.getAllProperties();

    }

    @GetMapping("/properties/{id}")
    public Property getPropertyById(@PathVariable Long id){
        return propertyService.getPropertyById(id);
    }

    @PutMapping("/properties/{id}")
    public Property updatePropertyById(@PathVariable Long id, @RequestBody Property property){
        return propertyService.updatePropertyById(id,property);
    }

    @DeleteMapping("/properties/{id}")
    public String deletePropertyById(@PathVariable Long id){
        if(propertyService.deletePropertyById(id))
            return "Deleted";
        return "Not Deleted";
    }
}
