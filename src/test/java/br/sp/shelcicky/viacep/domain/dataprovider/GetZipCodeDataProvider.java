package br.sp.shelcicky.viacep.domain.dataprovider;

import br.sp.shelcicky.viacep.domain.dataprovider.model.ZipCode;

import java.util.Optional;

public interface GetZipCodeDataProvider {
    Optional<ZipCode> execute(String zipCode);
}
