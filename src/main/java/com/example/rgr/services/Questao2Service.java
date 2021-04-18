package com.example.rgr.services;

import com.example.rgr.model.entity.ComplexNumber;
import com.example.rgr.model.entity.ListComplexNumber;
import com.example.rgr.model.entity.ListName;
import com.example.rgr.model.entity.Name;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Questao2Service {

    public ListName order(ListName listName) throws Exception {

        List<Name> result = new ArrayList<>();

        try {
            for(int i=0; i <listName.getNames().size(); i++){
                for(int j = listName.getNames().size() - 1; j>i; j--){
                    if(listName.getNames().get(i).getName().compareTo(listName.getNames().get(j).getName()) > 0){
                        Name aux = listName.getNames().get(i);
                        listName.getNames().set(i, listName.getNames().get(j));
                        listName.getNames().set(j, aux);
                    } else {
                        if(listName.getNames().get(i).getName().compareTo(listName.getNames().get(j).getName()) == 0){
                            listName.getNames().remove(j);
                            listName.getNames().get(i).setCount(listName.getNames().get(i).getCount() + 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return ListName.builder().names(listName.getNames()).build();
    }


}
