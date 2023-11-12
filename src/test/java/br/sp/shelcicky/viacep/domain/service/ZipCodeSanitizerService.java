package br.sp.shelcicky.viacep.domain.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ZipCodeSanitizerService {

    private static final String BLANK = "";
    private final String[] removable = new String[]{".", "-", "/"};
    private final String[] replacement = new String[]{BLANK, BLANK, BLANK};

    public String execute(final String zipCode) {
        return Stream.of(StringUtils.replaceEach(zipCode, removable, replacement))
                .filter(StringUtils::isNotBlank)
                .filter(NumberUtils::isDigits)
                .findFirst().orElse(zipCode);
    }
}
