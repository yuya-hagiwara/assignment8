package com.tutorial.nameservice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameService {

    private NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    public List<Name> findNameStartsWith(String prefix) {
        return nameMapper.findByNameStartsWith(prefix);
    }


    public Name findName(int id) {
        Optional<Name> name = nameMapper.findById(id);
        if (name.isPresent()) {
            return name.get();
        } else {
            throw new NameNotFoundException("Name not found");
        }
    }
}
