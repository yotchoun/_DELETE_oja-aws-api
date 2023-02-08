package com.mafoya.oja.mapper;

import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.model.CategoryNavigation;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;

import static org.slf4j.LoggerFactory.getLogger;

public class OjaMapper {

    private static final Logger LOGGER = getLogger(OjaMapper.class);

    public static CategoryNavigationDto mapNavigationToDto(CategoryNavigation NavigationDo) {
        CategoryNavigationDto NavigationDto = new CategoryNavigationDto();
        BeanUtils.copyProperties(NavigationDo, NavigationDto);
        return NavigationDto;
    }

    public static CategoryNavigation mapCategoryNavigationToDo(CategoryNavigationDto NavigationDto) {
        CategoryNavigation NavigationDo = new CategoryNavigation();
        BeanUtils.copyProperties(NavigationDto, NavigationDo);
        return NavigationDo;
    }
}
