package com.travix.medusa.busyflights.util;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class DozerMapper {

    private DozerBeanMapper mapper;

    public DozerMapper() {
        this.mapper = new DozerBeanMapper();
        this.mapper.setMappingFiles(Arrays.asList("dozer_mapping.xml"));
    }

    /**
     * Dozer mapper to map the one object ot another
     * @param inputList object to be mapped
     * @param targetClass class the object is mapped to
     * @param <T> target class type
     * @param <I> collection list of class
     * @return List of mapped objects
     */
    public <T, I> List<T> mapList(Collection<I> inputList, Class<T> targetClass) {

        List<T> result = new ArrayList<>();
        if (inputList != null) {
            for (I inputItem : inputList) {
                T resultItem = mapper.map(inputItem, targetClass);
                result.add(resultItem);
            }
        }
        return result;
    }

}
