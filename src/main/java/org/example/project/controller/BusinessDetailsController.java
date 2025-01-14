package org.example.project.controller;


import lombok.RequiredArgsConstructor;
import org.example.project.model.InformationRequest;
import org.example.project.service.general.AddressService;
import org.example.project.service.general.BusinessDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/general")
@RequiredArgsConstructor
public class BusinessDetailsController {
    @Autowired
    private final BusinessDetailsService businessDetailsService;
    private final AddressService addressService;
    //alindi
    @PutMapping("/save")
    public ResponseEntity<InformationRequest> save(@RequestBody InformationRequest informationRequest) {
        try{
            businessDetailsService.saveBusinessDetails(informationRequest.getBusinessDetails());
             addressService.saveAddress(informationRequest.getAddress());
            return new ResponseEntity<>(informationRequest, HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println("Xeta");
            return new ResponseEntity<>(informationRequest,HttpStatus.BAD_REQUEST);

        }
    }
//alindi
    @PutMapping("/cancel")
    public ResponseEntity<String> cancel(@RequestBody InformationRequest informationRequest) {
        try {
            businessDetailsService.cancelBusinessDetails(informationRequest.getBusinessDetails());
            addressService.cancelAddress(informationRequest.getAddress());
            return new ResponseEntity<>("Cancel oldu", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println("Northins");
            return new ResponseEntity<>("Cancel olmadi",HttpStatus.BAD_REQUEST);
        }
    }
}
