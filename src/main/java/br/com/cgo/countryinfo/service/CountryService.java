package br.com.cgo.countryinfo.service;

import br.com.cgo.countryinfo.model.CountryDTO;
import br.com.cgo.countryinfo.model.History;
import br.com.cgo.countryinfo.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HistoryRepository historyRepository;

    public CountryDTO findByName(String name) {
        CountryDTO[] countryDTO = restTemplate.getForObject(
                "https://restcountries.eu/rest/v2/name/"+name+"?fullText=true",
                CountryDTO[].class);

        saveHistory(name.toUpperCase());

        return countryDTO.length > 0 ? countryDTO[0] : null;
    };

    private void saveHistory(String name) {
        History history = new History(name);
        historyRepository.save(history);
    }
}
