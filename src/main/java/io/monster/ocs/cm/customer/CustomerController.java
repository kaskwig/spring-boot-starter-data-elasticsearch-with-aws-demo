package io.monster.ocs.cm.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    private final SearchService service;

    public CustomerController(SearchService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/email/{emailAddress}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> findByEmailAddress(@PathVariable String emailAddress) {
        return new ResponseEntity<>(service.findByEmailAddress(emailAddress), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDto>> search(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        return new ResponseEntity<>(service.search(key, value), HttpStatus.OK);
    }
}
