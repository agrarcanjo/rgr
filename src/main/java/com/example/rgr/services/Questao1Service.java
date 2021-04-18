package com.example.rgr.services;

import com.example.rgr.model.entity.ComplexNumber;
import com.example.rgr.model.entity.ListComplexNumber;
import org.springframework.stereotype.Service;

@Service
public class Questao1Service {

    public String calcule(ListComplexNumber complexNumbers) throws Exception {

        ComplexNumber result = new ComplexNumber();

        try {
            for(ComplexNumber complexNumber: complexNumbers.getComplexNumbers()){
                result = ComplexNumber.sum(complexNumber, result);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result.toString();
    }


}
