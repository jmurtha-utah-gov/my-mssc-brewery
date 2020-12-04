package guru.springframework.mymsscbrewery.web.service;

import guru.springframework.mymsscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
            .beerName("Galaxy Cat")
            .beerStyle("Pale Ale")
            .build();
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer with id " + beerId);
    }

    @Override
    public void updateBeet(UUID beerId, BeerDto beerDto) {
        log.debug("Updating beer with id " + beerId);
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDta) {
        return BeerDto.builder()
            .id(UUID.randomUUID())
            .build();
    }
}
