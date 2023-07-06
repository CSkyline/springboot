package com.skyline.Service.impl;

import com.skyline.Entity.Address;
import com.skyline.Mapper.AddressMapper;
import com.skyline.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private  AddressMapper addressMapper;

    @Override
    public int addAddress(Address addres){
        try {

            addressMapper.insertAddress(addres);

            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;

        }

    }

    @Override
    public  int deleteAddress(Integer rid ) {
        try {
            addressMapper.deleteAddress(rid);
            return 1;

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public  List<Address>  getAddress(Integer uid){
            try{

                List<Address> ad = addressMapper.getAddress(uid);
                return  ad;
            }catch (Exception e){
                System.out.println(e);
                return null;

            }

        }

//    public int  setDefault(Integer uid, String address){
//      try{
//          addressMapper.initDefaultddress();
//          addressMapper.setDefaultAddress(uid,address);
//          return 1;
//      }catch (Exception e){
//
//          System.out.println(e);
//          return 0;
//      }
//    }



}
