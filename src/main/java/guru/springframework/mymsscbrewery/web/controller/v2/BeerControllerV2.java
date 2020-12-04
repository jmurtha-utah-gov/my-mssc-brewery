package guru.springframework.mymsscbrewery.web.controller.v2;

import guru.springframework.mymsscbrewery.web.model.BeerDto;
import guru.springframework.mymsscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.mymsscbrewery.web.service.BeerService;
import guru.springframework.mymsscbrewery.web.service.v2.BeerServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    @Autowired
    private BeerServiceV2 beerService;

//    private final BeerService beerService;
//    public BeerController(BeerService beerService) {
//        this.beerService = beerService;
//    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDta) {

        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDta);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeet(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);

    }
}
