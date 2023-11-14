package br.sp.shelcicky.viacep.domain.dataprovider.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ZipCode(@JsonProperty("cep") String zipCode,
                        @JsonProperty("logradouro") String address,
                        @JsonProperty("complemento") String complement,
                        @JsonProperty("bairro") String neighborhood,
                        @JsonProperty("localidade") String city,
                        @JsonProperty("ddd") String ddd) {

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

}
