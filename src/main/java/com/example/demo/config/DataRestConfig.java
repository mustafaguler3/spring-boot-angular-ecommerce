package com.example.demo.config;

import com.example.demo.entities.Product;
import com.example.demo.entities.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] unsupportedActions = {
          HttpMethod.PUT,
          HttpMethod.DELETE,
          HttpMethod.POST
        };
        // disabled HTTP methods for product : PUT , POST , DELETE

     config.getExposureConfiguration()
             .forDomainType(Product.class)
             .withItemExposure((metdata,httpmethods) -> httpmethods.disable(unsupportedActions))
             .withCollectionExposure((metdata,httpmethods) -> httpmethods.disable(unsupportedActions));
// disabled HTTP methods for productCategory : PUT , POST , DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata,httpmethods) -> httpmethods.disable(unsupportedActions))
                .withCollectionExposure((metdata,httpmethods) -> httpmethods.disable(unsupportedActions));
    }
}














