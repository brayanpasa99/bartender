package com.bartender.bartender.services;

import com.bartender.bartender.exceptions.GlassArrayNotFoundException;
import com.bartender.bartender.models.GlassArray;
import com.bartender.bartender.repositories.GlassArrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlassArrayService {

    @Autowired
    GlassArrayRepository glassArrayRepository;

    public List<GlassArray> getAllGlassArray(){
        return glassArrayRepository.findAll();
    }

    public GlassArray getGlassArrayById(Long id){
        return glassArrayRepository.findById(id)
                .orElseThrow(() -> new GlassArrayNotFoundException(HttpStatus.NOT_FOUND, "GlassArray by id " + id + " was not found"));
    }

}
