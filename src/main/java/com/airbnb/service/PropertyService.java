package com.airbnb.service;

import com.airbnb.model.Property;
import com.airbnb.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {


    @Autowired
    PropertyRepository propertyRepository;

    public Property addProperty(Property property) {
    return propertyRepository.save(property);
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }


    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).get();
    }

    public Property updatePropertyById(Long id,Property property) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);

        if(optionalProperty.isPresent()){
                Property existingProperty=optionalProperty.get();
                existingProperty.setName(property.getName());
                existingProperty.setDescription(property.getDescription());
                existingProperty.setAddress(property.getAddress());
                existingProperty.setPricePerNight(property.getPricePerNight());
                existingProperty.setNumberOfBedrooms(property.getNumberOfBedrooms());
                existingProperty.setNumberOfBathrooms(property.getNumberOfBathrooms());
                existingProperty.setAvailable(property.isAvailable());
                existingProperty.setDrinkAllowed(property.isDrinkAllowed());
                existingProperty.setPetAllowed(property.isPetAllowed());
                existingProperty.setMaxCheckoutTimeInNights(property.getMaxCheckoutTimeInNights());
                existingProperty.setExtraCharges(property.getExtraCharges());
                existingProperty.setOwner(property.getOwner());
                propertyRepository.save(existingProperty);
                return existingProperty;
        }
        else
            return null;

    }

    public boolean deletePropertyById(Long id) {
        Property property=propertyRepository.findById(id).orElse(null);
        if(property!=null) {
            propertyRepository.deleteById(id);
            return true;
        }
        else return false;

    }
}
