package br.com.planesdata.mtg.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    static {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("COSMOS_ENDPOINT", dotenv.get("COSMOS_ENDPOINT"));
        System.setProperty("COSMOS_KEY", dotenv.get("COSMOS_KEY"));
        System.setProperty("COSMOS_DATABASE", dotenv.get("COSMOS_DATABASE"));
        System.setProperty("APP_NAME", dotenv.get("APP_NAME"));
    }
}
