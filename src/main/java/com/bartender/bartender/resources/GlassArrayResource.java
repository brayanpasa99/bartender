package com.bartender.bartender.resources;

import com.bartender.bartender.helpers.GlassArrayHelper;
import com.bartender.bartender.models.GlassArray;
import com.bartender.bartender.services.GlassArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glass")
public class GlassArrayResource {

    @Autowired
    GlassArrayService glassArrayService;

    @RequestMapping("/getAllGlassArray")
    @ResponseBody
    public List<GlassArray> getAllGlassArray(){
        return glassArrayService.getAllGlassArray();
    }

    @RequestMapping("/getGlassArrayById/{id}/{Q}")
    @ResponseBody
    public String getGlassArrayById(@PathVariable("id") Long id, @PathVariable("Q") Long q){
        GlassArray glassArrayById = glassArrayService.getGlassArrayById(id);
        GlassArrayHelper glassArrayHelper = new GlassArrayHelper();
        return glassArrayHelper.initializeValues(glassArrayById.getInput_array(), q);
    }
}
