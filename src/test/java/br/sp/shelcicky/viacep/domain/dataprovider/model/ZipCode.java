package br.sp.shelcicky.viacep.domain.dataprovider.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ZipCode {
    
    private final String zipCode;
    private final String address;
    private final String complement;
    private final String neighborhood;
    private final String city;
    private final String ddd;

    private ZipCode(@JsonProperty("cep") String zipCode,
                    @JsonProperty("logradouro") String address,
                    @JsonProperty("complemento") String complement,
                    @JsonProperty("bairro") String neighborhood,
                    @JsonProperty("localidade") String city,
                    @JsonProperty("ddd") String ddd) {
        this.zipCode = zipCode;
        this.address = address;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.ddd = ddd;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String zipCode;
        private String address;
        private String complement;
        private String neighborhood;
        private String city;
        private String ddd;

        public Builder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withComplement(String complement) {
            this.complement = complement;
            return this;
        }

        public Builder withNeighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withDdd(String ddd) {
            this.ddd = ddd;
            return this;
        }

        public ZipCode build() {
            return new ZipCode(this.zipCode, this.address, this.complement,
                    this.neighborhood, this.city, this.ddd);
        }
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getDdd() {
        return ddd;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("zipCode", zipCode)
                .add("address", address)
                .add("complement", complement)
                .add("neighborhood", neighborhood)
                .add("city", city)
                .add("ddd", ddd)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode1 = (ZipCode) o;
        return Objects.equal(zipCode, zipCode1.zipCode) &&
                Objects.equal(address, zipCode1.address) &&
                Objects.equal(complement, zipCode1.complement) &&
                Objects.equal(neighborhood, zipCode1.neighborhood) &&
                Objects.equal(city, zipCode1.city) &&
                Objects.equal(ddd, zipCode1.ddd);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(zipCode, address, complement, neighborhood, city, ddd);
    }
}
