package com.ecomproject.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ecomproject.ecommerce.entity.Product;
import com.ecomproject.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		
		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };
		
		// disable the http methods for Product : PUT, POST, DELETE
		config.getExposureConfiguration().forDomainType(Product.class)
										 .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
										 .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		// disable the http methods for ProductCategory : PUT, POST, DELETE
				config.getExposureConfiguration().forDomainType(ProductCategory.class)
												 .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
												 .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
										 
		
	}

}
