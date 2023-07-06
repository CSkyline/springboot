package com.skyline.Service;

import com.skyline.Entity.Address;

import java.util.List;

public interface AddressService {

    int  addAddress(Address address);

    int deleteAddress(Integer rid);

    List<Address> getAddress(Integer uid);

//    int  setDefault(Integer uid,String address);


}
