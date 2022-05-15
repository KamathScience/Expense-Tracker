package com.css533.curbthecoins.PurchaseService;

import com.css533.curbthecoins.PurchaseService.filter.AuthFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;


@SpringBootApplication
public class PurchaseServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PurchaseServiceApplication.class, args);
	}

		@Bean
		public FilterRegistrationBean<CorsFilter> corsFilter(){
			FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration configuration = new CorsConfiguration();
//			configuration.addAllowedOrigin("http://localhost:5500");
			configuration.addAllowedOrigin("*");
			configuration.addAllowedHeader("*");
			configuration.addAllowedMethod("*");
			source.registerCorsConfiguration("/**",configuration);
			registrationBean.setFilter(new CorsFilter(source));
			registrationBean.setOrder(0);
			return registrationBean;
		}


	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean(){
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/api/categories/*" );
		return registrationBean;
	}
}
