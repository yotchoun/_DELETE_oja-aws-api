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
        BlogDto blogDto = new BlogDto();
        BeanUtils.copyProperties(blog, blogDto);
        return blogDto;
    }

    public static Blog mapBlogDo(BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        return blog;
    }

    public static BrandDto mapBrandDto(Brand brand) {
        BrandDto brandDto = new BrandDto();
        BeanUtils.copyProperties(brand, brandDto);
        return brandDto;
    }

    public static Brand mapBrandDo(BrandDto brandDto) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandDto, brand);
        return brand;
    }

    public static CardDto mapCardDto(Card card) {
        CardDto cardDto = new CardDto();
        BeanUtils.copyProperties(card, cardDto);
        return cardDto;
    }

    public static Card mapCardDo(CardDto cardDto) {
        Card card = new Card();
        BeanUtils.copyProperties(cardDto, card);
        return card;
    }

    public static Carousel mapCarouselDo(CarouselDto carouselDto) {
        Carousel carousel = new Carousel();
        BeanUtils.copyProperties(carouselDto, carousel);
        return carousel;
    }

    public static CarouselDto mapCarouselDto(Carousel carousel) {
        CarouselDto carouselDto = new CarouselDto();
        BeanUtils.copyProperties(carousel, carouselDto);
        return carouselDto;
    }

    public static CategoryParent mapCategoryParentDo(CategoryParentDto categoryParentDto) {
        CategoryParent categoryParent = new CategoryParent();
        BeanUtils.copyProperties(categoryParentDto, categoryParent);
        return categoryParent;
    }

    public static CategoryParentDto mapCategoryParentDto(CategoryParent categoryParent) {
        CategoryParentDto categoryParentDto = new CategoryParentDto();
        BeanUtils.copyProperties(categoryParent, categoryParentDto);
        return categoryParentDto;
    }

    public static Category mapCategoryDo(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return category;
    }

    public static CategoryDto mapCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return categoryDto;
    }

    public static Color mapColorDo(ColorDto colorDto) {
        Color color = new Color();
        BeanUtils.copyProperties(colorDto, color);
        return color;
    }

    public static ColorDto mapColorDto(Color color) {
        ColorDto colorDto = new ColorDto();
        BeanUtils.copyProperties(color, colorDto);
        return colorDto;
    }

    public static Customer mapCustomerDo(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }

    public static CustomerDto mapCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static DealHot mapDealHotDo(DealHotDto dealHotDto) {
        DealHot dealHot = new DealHot();
        BeanUtils.copyProperties(dealHotDto, dealHot);
        return dealHot;
    }

    public static DealHotDto mapDealHotDto(DealHot dealHot) {
        DealHotDto dealHotDto = new DealHotDto();
        BeanUtils.copyProperties(dealHot, dealHotDto);
        return dealHotDto;
    }

    public static DealOfTheWeek mapDealOfTheWeekDo(DealOfTheWeekDto dealOfTheWeekDto) {
        DealOfTheWeek dealOfTheWeek = new DealOfTheWeek();
        BeanUtils.copyProperties(dealOfTheWeekDto, dealOfTheWeek);
        return dealOfTheWeek;
    }

    public static DealOfTheWeekDto mapDealOfTheWeekDto(DealOfTheWeek dealOfTheWeek) {
        DealOfTheWeekDto dealOfTheWeekDto = new DealOfTheWeekDto();
        BeanUtils.copyProperties(dealOfTheWeek, dealOfTheWeekDto);
        return dealOfTheWeekDto;
    }

    public static DiscountCard mapDiscountCardDo(DiscountCardDto discountCardDto) {
        DiscountCard discountCard = new DiscountCard();
        BeanUtils.copyProperties(discountCardDto, discountCard);
        return discountCard;
    }

    public static DiscountCardDto mapDiscountCardDto(DiscountCard discountCard) {
        DiscountCardDto discountCardDto = new DiscountCardDto();
        BeanUtils.copyProperties(discountCard, discountCardDto);
        return discountCardDto;
    }

    public static DiscountOffer mapDiscountOfferDo(DiscountOfferDto discountOfferDto) {
        DiscountOffer discountOffer = new DiscountOffer();
        BeanUtils.copyProperties(discountOfferDto, discountOffer);
        return discountOffer;
    }

    public static DiscountOfferDto mapDiscountOfferDto(DiscountOffer discountOffer) {
        DiscountOfferDto discountOfferDto = new DiscountOfferDto();
        BeanUtils.copyProperties(discountOffer, discountOfferDto);
        return discountOfferDto;
    }

    public static Earning mapEarningDo(EarningDto earningDto) {
        Earning earning = new Earning();
        BeanUtils.copyProperties(earningDto, earning);
        return earning;
    }

    public static EarningDto mapEarningDto(Earning earning) {
        EarningDto earningDto = new EarningDto();
        BeanUtils.copyProperties(earning, earningDto);
        return earningDto;
    }

    public static For mapForDo(ForDto forSerDto) {
        For aFor = new For();
        BeanUtils.copyProperties(forSerDto, aFor);
        return aFor;
    }

    public static ForDto mapForDto(For aFor) {
        ForDto forDto = new ForDto();
        BeanUtils.copyProperties(aFor, forDto);
        return forDto;
    }

    public static Image mapImageDo(ImageDto imageDto) {
        Image image = new Image();
        BeanUtils.copyProperties(imageDto, image);
        return image;
    }

    public static ImageDto mapImageDto(Image image) {
        ImageDto imageDto = new ImageDto();
        BeanUtils.copyProperties(image, imageDto);
        return imageDto;
    }

    public static Message mapMessageDo(MessageDto messageDto) {
        Message message = new Message();
        BeanUtils.copyProperties(messageDto, message);
        return message;
    }

    public static MessageDto mapMessageDto(Message message) {
        MessageDto messageDto = new MessageDto();
        BeanUtils.copyProperties(message, messageDto);
        return messageDto;
    }

    public static OrderItem mapOrderItemDo(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderItemDto, orderItem);
        return orderItem;
    }

    public static OrderItemDto mapOrderItemDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        BeanUtils.copyProperties(orderItem, orderItemDto);
        return orderItemDto;
    }

    public static Order mapOrderDo(OrderDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        return order;
    }

    public static OrderDto mapOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }

    public static PaymentPackage mapPaymentPackageDo(PaymentPackageDto paymentPackageDto) {
        PaymentPackage paymentPackage = new PaymentPackage();
        BeanUtils.copyProperties(paymentPackageDto, paymentPackage);
        return paymentPackage;
    }

    public static PaymentPackageDto mapPaymentPackageDto(PaymentPackage paymentPackage) {
        PaymentPackageDto paymentPackageDto = new PaymentPackageDto();
        BeanUtils.copyProperties(paymentPackage, paymentPackageDto);
        return paymentPackageDto;
    }

    public static PayoutRequest mapPayoutRequestDo(PayoutRequestDto payoutRequestDto) {
        PayoutRequest payoutRequest = new PayoutRequest();
        BeanUtils.copyProperties(payoutRequestDto, payoutRequest);
        return payoutRequest;
    }

    public static PayoutRequestDto mapPayoutRequestDto(PayoutRequest payoutRequest) {
        PayoutRequestDto payoutRequestDto = new PayoutRequestDto();
        BeanUtils.copyProperties(payoutRequest, payoutRequestDto);
        return payoutRequestDto;
    }

    public static Payout mapPayoutDo(PayoutDto payoutDto) {
        Payout payout = new Payout();
        BeanUtils.copyProperties(payoutDto, payout);
        return payout;
    }

    public static PayoutDto mapPayoutDto(Payout payout) {
        PayoutDto payoutDto = new PayoutDto();
        BeanUtils.copyProperties(payout, payoutDto);
        return payoutDto;
    }

    public static Product mapProductDo(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    public static ProductDto mapProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static ProductStockOut mapProductStockOutDo(ProductStockOutDto productStockOutDto) {
        ProductStockOut productStockOut = new ProductStockOut();
        BeanUtils.copyProperties(productStockOutDto, productStockOut);
        return productStockOut;
    }

    public static ProductStockOutDto mapProductStockOutDto(ProductStockOut productStockOut) {
        ProductStockOutDto productStockOutDto = new ProductStockOutDto();
        BeanUtils.copyProperties(productStockOut, productStockOutDto);
        return productStockOutDto;
    }

    public static RecentPurchase mapRecentPurchaseDo(RecentPurchaseDto recentPurchaseDto) {
        RecentPurchase recentPurchase = new RecentPurchase();
        BeanUtils.copyProperties(recentPurchaseDto, recentPurchase);
        return recentPurchase;
    }

    public static RecentPurchaseDto mapRecentPurchaseDto(RecentPurchase recentPurchase) {
        RecentPurchaseDto recentPurchaseDto = new RecentPurchaseDto();
        BeanUtils.copyProperties(recentPurchase, recentPurchaseDto);
        return recentPurchaseDto;
    }

    public static RefundRequest mapRefundRequestDo(RefundRequestDto refundRequestDto) {
        RefundRequest refundRequest = new RefundRequest();
        BeanUtils.copyProperties(refundRequestDto, refundRequest);
        return refundRequest;
    }

    public static RefundRequestDto mapRefundRequestDto(RefundRequest refundRequest) {
        RefundRequestDto refundRequestDto = new RefundRequestDto();
        BeanUtils.copyProperties(refundRequest, refundRequestDto);
        return refundRequestDto;
    }

    public static Review mapReviewDo(ReviewDto reviewDto) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewDto, review);
        return review;
    }

    public static ReviewDto mapReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        BeanUtils.copyProperties(review, reviewDto);
        return reviewDto;
    }

    public static Seller mapSellerDo(SellerDto sellerDto) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(sellerDto, seller);
        return seller;
    }

    public static SellerDto mapSellerDto(Seller seller) {
        SellerDto sellerDto = new SellerDto();
        BeanUtils.copyProperties(seller, sellerDto);
        return sellerDto;
    }

    public static Shop mapShopDo(ShopDto shopDto) {
        Shop shop = new Shop();
        BeanUtils.copyProperties(shopDto, shop);
        return shop;
    }

    public static ShopDto mapShopDto(Shop shop) {
        ShopDto shopDto = new ShopDto();
        BeanUtils.copyProperties(shop, shopDto);
        return shopDto;
    }

    public static ShopServiceObject mapShopServiceObjectDo(ShopServiceObjectDto shopServiceObjectDto) {
        ShopServiceObject shopServiceObject = new ShopServiceObject();
        BeanUtils.copyProperties(shopServiceObjectDto, shopServiceObject);
        return shopServiceObject;
    }

    public static ShopServiceObjectDto mapShopServiceObjectDto(ShopServiceObject shopServiceObject) {
        ShopServiceObjectDto shopServiceObjectDto = new ShopServiceObjectDto();
        BeanUtils.copyProperties(shopServiceObject, shopServiceObjectDto);
        return shopServiceObjectDto;
    }

    public static SocialLink mapSocialLinkDo(SocialLinkDto socialLinkDto) {
        SocialLink socialLink = new SocialLink();
        BeanUtils.copyProperties(socialLinkDto, socialLink);
        return socialLink;
    }

    public static SocialLinkDto mapSocialLinkDto(SocialLink socialLink) {
        SocialLinkDto socialLinkDto = new SocialLinkDto();
        BeanUtils.copyProperties(socialLink, socialLinkDto);
        return socialLinkDto;
    }

    public static Testimonial mapTestimonialDo(TestimonialDto testimonialDto) {
        Testimonial testimonial = new Testimonial();
        BeanUtils.copyProperties(testimonialDto, testimonial);
        return testimonial;
    }

    public static TestimonialDto mapTestimonialDto(Testimonial testimonial) {
        TestimonialDto testimonialDto = new TestimonialDto();
        BeanUtils.copyProperties(testimonial, testimonialDto);
        return testimonialDto;
    }

    public static Ticket mapTicketDo(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDto, ticket);
        return ticket;
    }

    public static TicketDto mapTicketDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        BeanUtils.copyProperties(ticket, ticketDto);
        return ticketDto;
    }

    public static UserAddress mapUserAddressDo(UserAddressDto userAddressDto) {
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(userAddressDto, userAddress);
        return userAddress;
    }

    public static UserAddressDto mapUserAddressDto(UserAddress userAddress) {
        UserAddressDto userAddressDto = new UserAddressDto();
        BeanUtils.copyProperties(userAddress, userAddressDto);
        return userAddressDto;
    }

    public static UserContact mapUserContactDo(UserContactDto userContactDto) {
        UserContact userContact = new UserContact();
        BeanUtils.copyProperties(userContactDto, userContact);
        return userContact;
    }

    public static UserContactDto mapUserContactDto(UserContact userContact) {
        UserContactDto userContactDto = new UserContactDto();
        BeanUtils.copyProperties(userContact, userContactDto);
        return userContactDto;
    }

    public static User mapUserDo(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    public static UserDto mapUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public static Visitor mapVisitorDo(VisitorDto visitorDto) {
        Visitor visitor = new Visitor();
        BeanUtils.copyProperties(visitorDto, visitor);
        return visitor;
    }

    public static VisitorDto mapVisitorDto(Visitor visitor) {
        VisitorDto visitorDto = new VisitorDto();
        BeanUtils.copyProperties(visitor, visitorDto);
        return visitorDto;
    }
}
