//package org.edem.productmanagement.utils;
//
//
//import org.edem.productmanagement.interceptors.AuthHandlerInterceptor;
//import org.edem.productmanagement.interceptors.LoggingInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private LoggingInterceptor loggingInterceptor;
//
//    @Autowired
//    private AuthHandlerInterceptor authenticationInterceptor;
//
//    @Autowired
//    private Environment environment;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
//        interceptorRegistry.addInterceptor(loggingInterceptor)
//                .addPathPatterns("/**");
//        if(isDevProfileActive()) {
//            System.out.println("DEV PROFILE ACTIVATED");
//            interceptorRegistry.addInterceptor(authenticationInterceptor)
//                    .addPathPatterns("/**")
//                    .excludePathPatterns("/login","/register","/");
//        }
//    }
//
//    private boolean isDevProfileActive() {
//        String activeProfile = environment.getProperty("spring.profiles.active");
//        return "dev".equals(activeProfile);
//    }
//}
