package side.project.publicapi.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

@Configuration
 public class ConverterConfig {
    //CustomConverter class와 ConverterConfig class는 나중에 DB properties에 설정을 @Value값으로 가져와
    //java에서 구현하기 위해 Url 타입으로 형변환을 해주려 설정 구현을 했다.
    @Bean
    public ConversionServiceFactoryBean conversionService () {
        final ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(converters());
        return conversionServiceFactoryBean;
    }

    @Bean
    public Set<Converter> converters() {
        final Set<Converter> set = new HashSet<>();
        set.add(new CustomConverter());
        return set;
    }
}
