/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("/controler")
public class SpringConfig {
    @Bean
    public InternalResourceViewResolver resolver(){
    
        InternalResourceViewResolver view= new InternalResourceViewResolver();
        
    view.setPrefix("/WEB-INF/jsp/");
    view.setSuffix(".jsp");
    
    return view;
    }





}
