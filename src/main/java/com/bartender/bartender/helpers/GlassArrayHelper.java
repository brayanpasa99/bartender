package com.bartender.bartender.helpers;

import com.bartender.bartender.exceptions.MoreIterationsThanItems;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;

public class GlassArrayHelper {
    private ArrayList<Long> glassArray;
    private ArrayList<Long> primeNumbers;
    private Long iterations;
    String messageResponse = "{";

    public GlassArrayHelper() { }

    public String initializeValues(String glassArrayById, Long q){
        String[] splitedGlassArray = glassArrayById.split(",");
        glassArray = new ArrayList<>();
        primeNumbers = new ArrayList<>();
        iterations = q;

        for (String s : splitedGlassArray) {
            glassArray.add(Long.parseLong(s));
        }

        if(q > glassArray.size()){
            throw new MoreIterationsThanItems(HttpStatus.CONFLICT, "Iteration's number " + q + " can not be bigger than the number of elements in the array");
        } else {
            Long i = 0L;
            while(primeNumbers.size() < glassArray.size()){
                if(esPrimo(i)){
                    primeNumbers.add(i);
                }
                i++;
            }
        }

        return sortGlasses();
    }

    private Boolean esPrimo(Long number){
        double root = Math.sqrt(number);
        for(int i = 2; i <= root; i++){
            if(number % i == 0){
                return false;
            }
        }
        return number > 1;
    }

    private String sortGlasses() {
        ArrayList<Long> bArray = new ArrayList<>();
        ArrayList<Long> aiArray = new ArrayList<>();
        ArrayList<Long> tempGlassArray;
        ArrayList<Long> response = new ArrayList<>();

        tempGlassArray = glassArray;

        for (int i = 0; i < iterations; i++) {
            messageResponse = messageResponse + "\"Q" + (i+1) + "\":{";

            for (Long aLong : tempGlassArray) {
                if (aLong % primeNumbers.get(i) == 0) {
                    bArray.add(aLong);
                } else {
                    aiArray.add(aLong);
                }
            }

            messageResponse = messageResponse + "\"A" + (i) + "\":\"" + tempGlassArray + "\",";

            Collections.reverse(bArray);
            messageResponse = messageResponse + "\"B\":\"" + bArray + "\",";
            response.addAll(bArray);

            tempGlassArray.clear();
            Collections.reverse(aiArray);
            messageResponse = messageResponse + "\"A" + (i+1) + "\":\"" + aiArray + "\",";
            tempGlassArray.addAll(aiArray);

            bArray.clear();
            if(i != (iterations-1)) {
                aiArray.clear();
            }

            messageResponse = messageResponse + "\"Respuesta\":\"" + response + "\"},";
        }

        messageResponse = messageResponse + "\"Final\": \"Se completó el número de iteraciones";
        if(aiArray.size() > 0){
            Collections.reverse(aiArray);
            response.addAll(aiArray);
        }
        messageResponse = messageResponse + "Respuesta=" + response + "\"}";

        return messageResponse;
    }

}
