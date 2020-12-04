package guru.springframework.mymsscbrewery.web.service;

import guru.springframework.mymsscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
            .id(UUID.randomUUID())
            .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("updating customer with id " + customerId);
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("deleting customer with id " + customerId);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
            .name("Best Customer Ever")
            .build();
    }
}
