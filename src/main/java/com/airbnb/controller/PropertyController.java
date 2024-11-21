package com.airbnb.controller;

import com.airbnb.model.Property;
import com.airbnb.model.User;
import com.airbnb.service.PropertyService;
import com.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyController {


    @Autowired
    PropertyService propertyService;

    @Autowired
    UserService userService;

    //  Create Property: Endpoint: POST /api/properties
    //        Request Body : {
    //        "name": "H-35",
    //        "description": "Developed acordingly Vastu",
    //        "address": "Unity City Lucknow",
    //        "pricePerNight": 6000,
    //        "numberOfBedrooms": 5,
    //        "numberOfBathrooms": 4,
    //        "available": true,
    //        "drinkAllowed": true,
    //        "petAllowed": true,
    //        "maxCheckoutTimeInNights": 10,
    //        "extraCharges": 600
    //}
    @PostMapping("/properties")
    public Property addProperty(@RequestBody Property property){
        return propertyService.addProperty(property);
    }
//------------------------------------------------------------------------------------------
//  Retrieve All Properties: Endpoint: GET /api/properties
@GetMapping("/properties")
public List<Property> getAllProperties(){
    return propertyService.getAllProperties();

}
//------------------------------------------------------------------------------------------

    //  Get Property by ID: Endpoint: GET /api/properties/{id}
    @GetMapping("/properties/{id}")
    public Property getPropertyById(@PathVariable Long id){
        return propertyService.getPropertyById(id);
    }

//--------------------------------------------------------------------------------------------
//  Update Property: Endpoint: PUT /api/properties/{id}
//        Request Body :{
//        "name": "H-35",
//        "description": "Developed acordingly Vastu",
//        "address": "Unity City Lucknow",
//        "pricePerNight": 6000,
//        "numberOfBedrooms": 5,
//        "numberOfBathrooms": 4,
//        "available": true,
//        "drinkAllowed": true,
//        "petAllowed": true,
//        "maxCheckoutTimeInNights": 10,
//        "extraCharges": 600
//}
@PutMapping("/properties/{id}")
public Property updatePropertyById(@PathVariable Long id, @RequestBody Property property){
    return propertyService.updatePropertyById(id,property);
}
//---------------------------------------------------------------------------------------------
//  Delete Property: Endpoint: DELETE /api/properties/{id}
    @DeleteMapping("/properties/{id}")
    public String deletePropertyById(@PathVariable Long id){
        if(propertyService.deletePropertyById(id))
            return "Deleted";
        return "Not Deleted";
    }

//------------------------------------------------------------------------------------------
//  Get User’s Properties: Endpoint: GET /api/users/{userId}/properties

    @GetMapping("/users/{id}/properties")
    public List<Property> propertyOfUser(@PathVariable Long id){
        User user=new User();
        user.setId(id);
        return propertyService.getPropertyByUserId(user);

    }


//    ------------------------------------------------------------------------------------
//    Endpoints for user checking:
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }





}
