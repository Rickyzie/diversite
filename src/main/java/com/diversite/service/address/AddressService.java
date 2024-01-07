package com.diversite.service.address;

import com.diversite.entity.address.AddressEntity;
import com.diversite.mapper.address.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AddressService {
    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Transactional(readOnly = true)
    public AddressEntity getAddressById(Integer id) {
        return addressMapper.getAddressById(id);
    }

    @Transactional(readOnly = true)
    public List<AddressEntity> getAllAddresses() {
        return addressMapper.getAllAddresses();
    }

    @Transactional
    public void addAddress(AddressEntity address) {
        addressMapper.insertAddress(address);
    }

    @Transactional
    public void updateAddress(AddressEntity address) {
        addressMapper.updateAddress(address);
    }

    @Transactional
    public void deleteAddress(Integer id) {
        addressMapper.deleteAddress(id);
    }
}