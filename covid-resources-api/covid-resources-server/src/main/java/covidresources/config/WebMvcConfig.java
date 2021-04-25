package covidresources.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import covidresources.interceptor.AuthorizeHandlerInterceptor;

@Configuration ("webMvcConfig")
public class WebMvcConfig implements WebMvcConfigurer {


    private final AuthorizeHandlerInterceptor authorizeHandlerInterceptor;

    @Autowired
    public WebMvcConfig(AuthorizeHandlerInterceptor authorizeHandlerInterceptor) {
        this.authorizeHandlerInterceptor = authorizeHandlerInterceptor;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizeHandlerInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/v2/api-docs", "/configuration/ui", 
                "/swagger-resources/**", "/configuration/**", "/swagger-ui.html"
                , "/webjars/**", "/csrf", "/", "/swagger.yaml");
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("redirect:/");
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    }

   
}
