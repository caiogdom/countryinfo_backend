package br.com.cgo.countryinfo.controller;

import br.com.cgo.countryinfo.model.History;
import br.com.cgo.countryinfo.service.HistoryService;
import br.com.cgo.countryinfo.util.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
@CrossOrigin("*")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @GetMapping
    public ResponseEntity getHistory(@PageableDefault(page = 0, size = 10, sort = "searchDate", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<History> historyPage = historyService.findAll(pageable);
            if (historyPage.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Page<History>>(historyPage, HttpStatus.OK);
        } catch (Exception e) {
            ApiError apiError = new ApiError("An error has occurred.", 500);
            return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
