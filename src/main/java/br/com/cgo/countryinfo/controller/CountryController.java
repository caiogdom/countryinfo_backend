package br.com.cgo.countryinfo.controller;

import br.com.cgo.countryinfo.model.CountryDTO;
import br.com.cgo.countryinfo.service.CountryService;
import br.com.cgo.countryinfo.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/{name}")
    public ResponseEntity getByName(@PathVariable(value = "name") String name) {
        try {
            CountryDTO countryDTO = countryService.findByName(name.toLowerCase());
            if(countryDTO == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.OK);
        } catch (Exception e) {
            ApiError apiError = new ApiError("An error has occurred.", 500);
            return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
