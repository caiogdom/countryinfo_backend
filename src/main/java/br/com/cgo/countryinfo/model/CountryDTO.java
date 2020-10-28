package br.com.cgo.countryinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO implements Serializable {
    public String name;
    public String[] callingCodes;
    public String capital;
    public String region;
    public String subregion;
    public Long population;
    public Double[] latlng;
    public String flag;
}
