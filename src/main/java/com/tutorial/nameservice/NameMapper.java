package com.tutorial.nameservice;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NameMapper {


    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{prefix}, '%')")
    List<Name> findByNameStartsWith(String prefix);
}