package guru.springframework.mymsscbrewery.web.controller;

import guru.springframework.mymsscbrewery.web.model.BeerDto;
import guru.springframework.mymsscbrewery.web.model.CustomerDto;
import guru.springframework.mymsscbrewery.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    private CustomerService customerService;
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    // get
    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    // post
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {

        CustomerDto savedCustomerDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + savedCustomerDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    // put
    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId, CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    // delete
    @DeleteMapping({"/{customerId}"})
    public void deleteById(@PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }
}
