package com.mafoya.oja.helper;

import com.mafoya.oja.dto.ArticleDto;
import com.mafoya.oja.dto.BannerDto;
import com.mafoya.oja.dto.CategoryItemDto;
import com.mafoya.oja.dto.CategoryNavigationDto;
import com.mafoya.oja.model.Article;
import com.mafoya.oja.model.Banner;
import com.mafoya.oja.model.CategoryItem;
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

    public static CategoryItemDto mapCategoryItemDto(CategoryItem categoryItem) {
        CategoryItemDto categoryItemDto = new CategoryItemDto();
        BeanUtils.copyProperties(categoryItem, categoryItemDto);
        return categoryItemDto;
    }

    public static CategoryItem mapCategoryItemDo(CategoryItemDto categoryItemDto) {
        CategoryItem categoryItem = new CategoryItem();
        BeanUtils.copyProperties(categoryItemDto, categoryItem);
        return categoryItem;
    }

    public static ArticleDto mapArticleDto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        BeanUtils.copyProperties(article, articleDto);
        return articleDto;
    }

    public static Article mapArticleDo(ArticleDto articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        return article;
    }


    public static BannerDto mapBannerDto(Banner banner) {
        BannerDto bannerDto = new BannerDto();
        BeanUtils.copyProperties(banner, bannerDto);
        return bannerDto;
    }

    public static Banner mapBannerDo(BannerDto bannerDto) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(bannerDto, banner);
        return banner;
    }
}
