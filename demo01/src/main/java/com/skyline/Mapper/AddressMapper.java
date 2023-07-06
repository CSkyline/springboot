package com.skyline.Mapper;


import com.skyline.Entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Insert("INSERT INTO sc_receivinginfo(uid,recname,address,tel) VALUES (#{uid},#{recname},#{address},#{tel})")
    void insertAddress(Address address);

    @Select("SELECT * FROM sc_receinfo WHERE uid=#{uid}")
    List<Address> getAddress(@Param("uid") Integer uid);

    @Delete("DELETE FROM sc_receinfo WHERE rid=#{rid}")
    void deleteAddress(@Param("rid") Integer rid);


}
