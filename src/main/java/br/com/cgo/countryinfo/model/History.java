package br.com.cgo.countryinfo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "history")
@Data
@NoArgsConstructor
public class History implements Serializable {

    @Id
    private String id;

    private Date searchDate;

    private String searchedCountry;

    public  History(String searchedCountry) {
        this.searchDate = new Date();
        this.searchedCountry = searchedCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return id.equals(history.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
