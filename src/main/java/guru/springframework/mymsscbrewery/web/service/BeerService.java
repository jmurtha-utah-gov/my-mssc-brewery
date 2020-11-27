package guru.springframework.mymsscbrewery.web.service;

import guru.springframework.mymsscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
