package br.sp.shelcicky.viacep.dataprovider;

import br.sp.shelcicky.viacep.dataprovider.service.RestService;
import br.sp.shelcicky.viacep.domain.dataprovider.GetStatusCodeDataProvider;
import org.springframework.stereotype.Service;

@Service
public class GetStatusCodeDataProviderImpl implements GetStatusCodeDataProvider {
    private final RestService rest;

    public GetStatusCodeDataProviderImpl(RestService rest) {
        this.rest = rest;
    }

    @Override
    public int execute() {
        return rest.getResponse().getStatusCode();
    }
}
