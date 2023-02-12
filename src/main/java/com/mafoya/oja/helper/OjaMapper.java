package com.mafoya.oja.helper;

import com.mafoya.oja.dto.*;
import com.mafoya.oja.model.*;
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

    public static BlogDto mapBlogDto(Blog blog) {
    }

    public static Blog mapBlogDo(BlogDto blogDto) {
    }

    public static BrandDto mapBrandDto(Brand brand) {
    }

    public static Brand mapBrandDo(BrandDto brandDto) {
    }

    public static CardDto mapCardDto(Card card) {
    }

    public static Card mapCardDo(CardDto cardDto) {
    }

    public static Carousel mapCarouselDo(CarouselDto carouselDto) {
    }

    public static CarouselDto mapCarouselDto(Carousel carousel) {
    }

    public static CategoryParent mapCategoryParentDo(CategoryParentDto categoryParentDto) {
    }

    public static CategoryParentDto mapCategoryParentDto(CategoryParent categoryParent) {
    }

    public static Category mapCategoryDo(CategoryDto categoryDto) {
    }

    public static CategoryDto mapCategoryDto(Category category) {
    }

    public static Color mapColorDo(ColorDto colorDto) {
    }

    public static ColorDto mapColorDto(Color color) {
    }

    public static Customer mapCustomerDo(CustomerDto customerDto) {
    }

    public static CustomerDto mapCustomerDto(Customer customer) {
    }

    public static DealHot mapDealHotDo(DealHotDto dealHotDto) {
    }

    public static DealHotDto mapDealHotDto(DealHot dealHot) {
    }

    public static DealOfTheWeek mapDealOfTheWeekDo(DealOfTheWeekDto dealOfTheWeekDto) {
    }

    public static DealOfTheWeekDto mapDealOfTheWeekDto(DealOfTheWeek dealOfTheWeek) {
    }

    public static DiscountCard mapDiscountCardDo(DiscountCardDto discountCardDto) {
    }

    public static DiscountCardDto mapDiscountCardDto(DiscountCard discountCard) {
    }

    public static DiscountOffer mapDiscountOfferDo(DiscountOfferDto discountOfferDto) {
    }

    public static DiscountOfferDto mapDiscountOfferDto(DiscountOffer discountOffer) {
    }

    public static Earning mapEarningDo(EarningDto earningDto) {
    }

    public static EarningDto mapEarningDto(Earning earning) {
    }

    public static For mapForDo(ForDto forSerDto) {
    }

    public static ForDto mapForDto(For aFor) {
    }

    public static Image mapImageDo(ImageDto imageDto) {
    }

    public static ImageDto mapImageDto(Image image) {
    }

    public static Message mapMessageDo(MessageDto messageDto) {
    }

    public static MessageDto mapMessageDto(Message message) {
    }

    public static OrderItem mapOrderItemDo(OrderItemDto orderItemDto) {
    }

    public static OrderItemDto mapOrderItemDto(OrderItem orderItem) {
    }

    public static Order mapOrderDo(OrderDto orderDto) {
    }

    public static OrderDto mapOrderDto(Order order) {
    }

    public static PaymentPackage mapPaymentPackageDo(PaymentPackageDto paymentPackageDto) {
    }

    public static PaymentPackageDto mapPaymentPackageDto(PaymentPackage paymentPackage) {
    }

    public static PayoutRequest mapPayoutRequestDo(PayoutRequestDto payoutRequestDto) {
    }

    public static PayoutRequestDto mapPayoutRequestDto(PayoutRequest payoutRequest) {
    }

    public static Payout mapPayoutDo(PayoutDto payoutDto) {
    }

    public static PayoutDto mapPayoutDto(Payout payout) {
    }

    public static Product mapProductDo(ProductDto productDto) {
    }

    public static ProductDto mapProductDto(Product product) {
    }

    public static ProductStockOut mapProductStockOutDo(ProductStockOutDto productStockOutDto) {
    }

    public static ProductStockOutDto mapProductStockOutDto(ProductStockOut productStockOut) {
    }

    public static RecentPurchase mapRecentPurchaseDo(RecentPurchaseDto recentPurchaseDto) {
    }

    public static RecentPurchaseDto mapRecentPurchaseDto(RecentPurchase recentPurchase) {
    }

    public static RefundRequest mapRefundRequestDo(RefundRequestDto refundRequestDto) {
    }

    public static RefundRequestDto mapRefundRequestDto(RefundRequest refundRequest) {
    }

    public static Review mapReviewDo(ReviewDto reviewDto) {
    }

    public static ReviewDto mapReviewDto(Review review) {
    }

    public static Seller mapSellerDo(SellerDto sellerDto) {
    }

    public static SellerDto mapSellerDto(Seller seller) {
    }
}
