package com.travix.flight.Util;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DozerMapper {

    private DozerBeanMapper mapper;

    public DozerMapper() {
        this.mapper = new DozerBeanMapper();
        this.mapper.setMappingFiles(Arrays.asList("dozer_mapping.xml"));
    }

    public List<?> mapList(@NotNull final List<?> source,@NotNull final Class destination){
        List<Object> result = new ArrayList();
        for(Object object: source){
            result.add(mapper.map(object, destination));
        }
       return result;
    }

}
