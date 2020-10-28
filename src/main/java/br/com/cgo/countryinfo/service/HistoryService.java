package br.com.cgo.countryinfo.service;

import br.com.cgo.countryinfo.model.History;
import br.com.cgo.countryinfo.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;

    public Page<History> findAll(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }
}
