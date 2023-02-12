package com.mafoya.oja.helper;

import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.model.CategoryNavigation;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;

import static org.slf4j.LoggerFactory.getLogger;

public class OjaMapper {

    private static final Logger LOGGER = getLogger(OjaMapper.class);

    public static CategoryNavigationDto mapCategoryNavigationDto(CategoryNavigation categoryNavigation) {
        CategoryNavigationDto categoryNavigationDto = new CategoryNavigationDto();
        BeanUtils.copyProperties(categoryNavigation, categoryNavigationDto);
        return categoryNavigationDto;
    }

    public static CategoryNavigation mapCategoryNavigationDo(CategoryNavigationDto categoryNavigationDto) {
        CategoryNavigation categoryNavigationDo = new CategoryNavigation();
        BeanUtils.copyProperties(categoryNavigationDto, categoryNavigationDo);
        return categoryNavigationDo;
    }
}
