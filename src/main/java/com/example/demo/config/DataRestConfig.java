package com.example.demo.config;

import com.example.demo.entities.Country;
import com.example.demo.entities.Product;
import com.example.demo.entities.ProductCategory;
import com.example.demo.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] unsupportedActions = {
          HttpMethod.PUT,
          HttpMethod.DELETE,
          HttpMethod.POST
        };
        disableHttpMethods(Product.class,config,unsupportedActions);
        disableHttpMethods(Country.class,config,unsupportedActions);
        disableHttpMethods(State.class,config,unsupportedActions);
        disableHttpMethods(ProductCategory.class,config,unsupportedActions);

        cors.addMapping("/api/**").allowedOrigins("*");
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
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for (EntityType entityType : entities){
            entityClasses.add(entityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

    private void disableHttpMethods(Class theClass,RepositoryRestConfiguration config,HttpMethod[] unsupportedActions){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metaData,httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metaData,httpMethods) -> httpMethods.disable(unsupportedActions));
    }
}














