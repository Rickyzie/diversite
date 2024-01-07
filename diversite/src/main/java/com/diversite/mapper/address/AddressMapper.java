package com.diversite.mapper.address;
import com.diversite.entity.address.AddressEntity;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface AddressMapper {

     /**
      * Inserts a new address into the database.
      *
      * @param addressEntity The Address object to be inserted.
      */
     void insertAddress(AddressEntity addressEntity);

     /**
      * Retrieves an address by its ID.
      *
      * @param id The ID of the address to retrieve.
      * @return The Address object.
      */
     AddressEntity getAddressById(Integer id);

     /**
      * Retrieves all addresses from the database.
      *
      * @return A list of Address objects.
      */
     List<AddressEntity> getAllAddresses();

     /**
      * Updates an existing address in the database.
      *
      * @param addressEntity The Address object to be updated.
      */
     void updateAddress(AddressEntity addressEntity);

     /**
      * Deletes an address from the database by its ID.
      *
      * @param id The ID of the address to be deleted.
      */
     void deleteAddress(Integer id);
}


