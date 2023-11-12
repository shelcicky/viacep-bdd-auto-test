package br.sp.shelcicky.viacep.domain.usecase;

import br.sp.shelcicky.viacep.domain.dataprovider.GetStatusCodeDataProvider;
import org.springframework.stereotype.Service;

@Service
public class GetStatusCodeUseCase {
    private final GetStatusCodeDataProvider dataProvider;

    public GetStatusCodeUseCase(GetStatusCodeDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public int execute() {
        return dataProvider.execute();
    }
}
