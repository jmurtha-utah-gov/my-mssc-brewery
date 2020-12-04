package guru.springframework.mymsscbrewery.web.service.v2;

import guru.springframework.mymsscbrewery.web.model.BeerDto;
import guru.springframework.mymsscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDta);

    void updateBeet(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeer(UUID beerId);
}
