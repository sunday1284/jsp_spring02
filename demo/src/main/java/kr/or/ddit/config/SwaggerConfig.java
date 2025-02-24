package kr.or.ddit.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
   info = @Info(title = "REST API 문서", version = "1.0", description = "샘플 REST API 문서"),
   servers = @Server(url = "http://localhost:8080", description = "Local Server")
)
public class SwaggerConfig {
	
}
