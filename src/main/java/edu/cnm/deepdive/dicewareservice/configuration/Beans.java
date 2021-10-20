package edu.cnm.deepdive.dicewareservice.configuration;

import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

  //"$" is an indicator to reference an outside resource i.e. word-list which is defined in appl-prop.
  @Value("${bundle.name}")
  private String bundleName;

    @Bean
  //Creating methods, not as beans directly. After annotation, "@Bean" it recognizes it.
  public ResourceBundle getBundle() {
    return ResourceBundle.getBundle(bundleName);
  }

  @Bean
  //This is a method.
  public Random rng() {
      return new SecureRandom();
  }

}
