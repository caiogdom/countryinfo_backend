package br.com.cgo.countryinfo.repository;

import br.com.cgo.countryinfo.model.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History, String> {

    Page<History> findAll(Pageable pageable);
}
