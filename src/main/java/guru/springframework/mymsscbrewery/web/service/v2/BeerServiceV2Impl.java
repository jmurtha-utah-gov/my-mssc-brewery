package guru.springframework.mymsscbrewery.web.service.v2;

import guru.springframework.mymsscbrewery.web.model.BeerDto;
import guru.springframework.mymsscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.mymsscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
            .beerName("Galaxy Cat")
            .beerStyle(BeerStyleEnum.ALE)
            .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDta) {
        return BeerDtoV2.builder()
            .id(UUID.randomUUID())
            .build();
    }

    @Override
    public void updateBeet(UUID beerId, BeerDtoV2 beerDto) {
        log.debug("Updating beer with id " + beerId);
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer with id " + beerId);
    }
}
