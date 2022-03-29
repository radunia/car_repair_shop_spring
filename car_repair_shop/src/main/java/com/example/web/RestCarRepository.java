package com.example.web;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RestCarRepository {

    private static Long idSequence = 1L;
    private final List<RestCar> restCarList = new ArrayList<>();

    public RestCar add(RestCar restCar) {
        restCar.setId(idSequence++);
        return restCar;
    }

    public List<RestCar> findAll() {
        return new ArrayList<>(restCarList);
    }

    public List<RestCar> findByMark(String mark) {
        return restCarList.stream()
                .filter(t -> t.getMark().equals(mark))
                .collect(Collectors.toList());
    }

    public RestCar findById(Long id) {
        return restCarList.stream()
                .filter(t -> t.getId() == id)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    public boolean deleteById(Long id) {
        restCarList.remove(findById(id));
        return true;
    }


}
