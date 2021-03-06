package br.com.viniciusesser.infrastructure.jpa;

import br.com.viniciusesser.domain.vo.Phone;
import org.springframework.core.convert.ConversionService;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static br.com.viniciusesser.AulaApplication.getBean;

/**
 * Created by marcondesmacaneiro on 12/07/16.
 */
@Converter(autoApply = true)
public class PhoneConverter implements AttributeConverter<Phone, String> {

    @Override
    public String convertToDatabaseColumn(Phone attribute) {
        return getBean("mvcConversionService", ConversionService.class).convert(attribute, String.class);
    }

    @Override
    public Phone convertToEntityAttribute(String dbData) {
        return getBean("mvcConversionService", ConversionService.class).convert(dbData, Phone.class);
    }
}
