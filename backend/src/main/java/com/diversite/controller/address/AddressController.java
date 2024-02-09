package com.diversite.controller.address;

import com.diversite.entity.address.AddressEntity;
import com.diversite.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }



    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Void> addAddress(AddressEntity addressEntity) {
        addressService.addAddress(addressEntity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressEntity> getAddressById(@PathVariable Integer id) {
        AddressEntity address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public ResponseEntity<List<AddressEntity>> getAllAddresses() {
        List<AddressEntity> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @PutMapping
    public ResponseEntity<Void> updateAddress(@RequestBody AddressEntity addressEntity) {
        addressService.updateAddress(addressEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok().build();
    }
}
