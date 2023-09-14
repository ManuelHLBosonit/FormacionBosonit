package com.block6personcontrollers.service;

import com.block6personcontrollers.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private List<City> townsService = new ArrayList<>();

    public CityService(List<City> generateTowns){
        townsService = generateTowns;
    }

    public boolean addCity(City city) {
        try {
            townsService.add(city);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public List<City> getTowns() {
        return this.townsService;
    }
}