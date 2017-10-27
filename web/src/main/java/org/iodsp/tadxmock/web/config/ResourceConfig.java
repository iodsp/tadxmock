package org.iodsp.tadxmock.web.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Getter
public class ResourceConfig {
    @Value("${reset.resource.url}")
    private String resetResourceUrl;
}
