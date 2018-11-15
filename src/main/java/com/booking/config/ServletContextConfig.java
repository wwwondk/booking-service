package com.booking.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.booking.interceptor.LoginCheckInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { 
	"com.booking.api",	
	"com.booking.controller" })
@EnableTransactionManagement
@EnableCaching
public class ServletContextConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
    public TilesViewResolver tilesViewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(1);
        return resolver;
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer() {
       TilesConfigurer tilesConfigurer = new TilesConfigurer();
       tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});    
       return tilesConfigurer;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// /webapp/static 경로를 의미
		registry.addResourceHandler("/static/**").addResourceLocations("//static/");
	}

	@Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760);
        return multipartResolver;
    }
	
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns("/my-reservation/**")
                .addPathPatterns("/reservations/**");
        super.addInterceptors(registry);
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new AuthUserArgumentResolver());
    }
        
    @Bean
    public CacheManager cacheManager(){
    	return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }
    
    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
    	EhCacheManagerFactoryBean chCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
    	chCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
    	chCacheManagerFactoryBean.setShared(true);
    	return chCacheManagerFactoryBean;
    }
}
