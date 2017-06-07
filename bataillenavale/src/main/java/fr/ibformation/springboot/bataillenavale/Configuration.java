package fr.ibformation.springboot.bataillenavale;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@EntityScan({"bataillenavalemodels"})
@ComponentScan({"fr.ibformation.springboot.bataillenavale"})
public class Configuration {

}
