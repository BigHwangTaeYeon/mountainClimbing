package side.project.publicapi.com.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomConverter implements Converter<String, Integer> {
    public Integer convert(String username) {
       try{
          return Integer.parseInt(username);
       } catch (NumberFormatException e) {
           return 0;
       }
    }
}