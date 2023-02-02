package com.mafoya.oja.mapper;

import com.mafoya.oja.dto.NavigationDto;
import com.mafoya.oja.model.Navigation;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;

import static org.slf4j.LoggerFactory.getLogger;

public class OjaMapper {

    private static final Logger LOGGER = getLogger(OjaMapper.class);

    public static NavigationDto mapNavigationToDto(Navigation NavigationDo) {
        NavigationDto NavigationDto = new NavigationDto();
        BeanUtils.copyProperties(NavigationDo, NavigationDto);
        return NavigationDto;
    }

    public static Navigation mapNavigationToDo(NavigationDto NavigationDto) {
        Navigation NavigationDo = new Navigation();
        BeanUtils.copyProperties(NavigationDto, NavigationDo);
        return NavigationDo;
    }
}
