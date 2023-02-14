package com.mafoya.oja.config;

import com.mafoya.oja.repository.*;
import com.mafoya.oja.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    ArticleService articleService(ArticleRepository articleRepository) {
        return new ArticleServiceImpl(articleRepository);
    }

    @Bean
    BannerService bannerService(BannerRepository bannerRepository) {
        return new BannerServiceImpl(bannerRepository);
    }

    @Bean
    BlogService blogService(BlogRepository blogRepository) {
        return new BlogServiceImpl(blogRepository);
    }


    @Bean
    BrandService brandService(BrandRepository brandRepository) {
        return new BrandServiceImpl(brandRepository);
    }

    @Bean
    CategoryNavigationService categoryNavigationService(CategoryNavigationRepository navigationRepository,CategoryItemRepository categoryItemRepository) {
        return new CategoryNavigationServiceImpl(navigationRepository, categoryItemRepository);
    }

    @Bean
    CardService cardService(CardRepository customerRepository) {
        return new CardServiceImpl(customerRepository);
    }
    @Bean
    CarouselService carouselService(CarouselRepository carouselRepository) {
        return new CarouselServiceImpl(carouselRepository);
    }
    @Bean
    CategoryService categoryService(CategoryRepository categoryRepository,CategoryParentRepository categoryParentRepository) {
        return new CategoryServiceImpl(categoryRepository, categoryParentRepository);
    }
    @Bean
    CategoryItemService categoryItemService(CategoryItemRepository categoryItemRepository) {
        return new CategoryItemServiceImpl(categoryItemRepository);
    }
    @Bean
    CategoryParentService categoryParentService(CategoryParentRepository categoryParentRepository) {
        return new CategoryParentServiceImpl(categoryParentRepository);
    }
    @Bean
    ColorService colorService(ColorRepository colorRepository) {
        return new ColorServiceImpl(colorRepository);
    }
    @Bean
    CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }
    @Bean
    DealHotService dealHotService(DealHotRepository dealHotRepository) {
        return new DealHotServiceImpl(dealHotRepository);
    }
    @Bean
    DealOfTheWeekService dealOfTheWeekService(DealOfTheWeekRepository dealOfTheWeekRepository) {
        return new DealOfTheWeekServiceImpl(dealOfTheWeekRepository);
    }
    @Bean
    DiscountCardService discountCardService(DiscountCardRepository discountCardRepository) {
        return new DiscountCardServiceImpl(discountCardRepository);
    }
    @Bean
    DiscountOfferService discountOfferService(DiscountOfferRepository discountOfferRepository) {
        return new DiscountOfferServiceImpl(discountOfferRepository);
    }
    @Bean
    EarningService earningService(EarningRepository earningRepository) {
        return new EarningServiceImpl(earningRepository);
    }
    @Bean
    ForService forService(ForRepository forRepository) {
        return new ForServiceImpl(forRepository);
    }
    @Bean
    ImageService imageService(ImageRepository imageRepository) {
        return new ImageServiceImpl(imageRepository);
    }
    @Bean
    MessageService messageService(MessageRepository messageRepository) {
        return new MessageServiceImpl(messageRepository);
    }
    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }
    @Bean
    OrderItemService orderItemService(OrderItemRepository orderItemRepository) {
        return new OrderItemServiceImpl(orderItemRepository);
    }
    @Bean
    PaymentPackageService paymentPackageService(PaymentPackageRepository paymentPackageRepository) {
        return new PaymentPackageServiceImpl(paymentPackageRepository);
    }
    @Bean
    PayoutService payoutService(PayoutRepository payoutRepository) {
        return new PayoutServiceImpl(payoutRepository);
    }
    @Bean
    PayoutRequestService payoutRequestService(PayoutRequestRepository payoutRequestRepository) {
        return new PayoutRequestServiceImpl(payoutRequestRepository);
    }
    @Bean
    ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
    @Bean
    ProductStockOutService productStockOutService(ProductStockOutRepository productStockOutRepository) {
        return new ProductStockOutServiceImpl(productStockOutRepository);
    }
    @Bean
    RecentPurchaseService recentPurchaseService(RecentPurchaseRepository recentPurchaseRepository) {
        return new RecentPurchaseServiceImpl(recentPurchaseRepository);
    }
    @Bean
    RefundRequestService refundRequestService(RefundRequestRepository refundRequestRepository) {
        return new RefundRequestServiceImpl(refundRequestRepository);
    }
    @Bean
    ReviewService reviewService(ReviewRepository reviewRepository) {
        return new ReviewServiceImpl(reviewRepository);
    }
    @Bean
    SellerService sellerService(SellerRepository sellerRepository) {
        return new SellerServiceImpl(sellerRepository);
    }
    @Bean
    ShopService shopService(ShopRepository shopRepository) {
        return new ShopServiceImpl(shopRepository);
    }
    @Bean
    ShopServiceService shopServiceService(ShopServiceRepository shopServiceRepository) {
        return new ShopServiceServiceImpl(shopServiceRepository);
    }
    @Bean
    SocialLinkService socialLinkService(SocialLinkRepository socialLinkRepository) {
        return new SocialLinkServiceImpl(socialLinkRepository);
    }
    @Bean
    TestimonialService testimonialService(TestimonialRepository testimonialRepository) {
        return new TestimonialServiceImpl(testimonialRepository);
    }
    @Bean
    TicketService ticketService(TicketRepository ticketRepository) {
        return new TicketServiceImpl(ticketRepository);
    }
    @Bean
    UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    UserAddressService userAddressService(UserAddressRepository userAddressRepository) {
        return new UserAddressServiceImpl(userAddressRepository);
    }
    @Bean
    UserContactService userContactService(UserContactRepository userContactRepository) {
        return new UserContactServiceImpl(userContactRepository);
    }
    @Bean
    VisitorService visitorService(VisitorRepository visitorRepository) {
        return new VisitorServiceImpl(visitorRepository);
    }

}
