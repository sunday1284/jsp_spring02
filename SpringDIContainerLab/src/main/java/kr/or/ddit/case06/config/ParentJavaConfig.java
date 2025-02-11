package kr.or.ddit.case06.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value="kr.or.ddit.case04.objs"
	, excludeFilters = {@ComponentScan.Filter(classes = Controller.class) }
)

public class ParentJavaConfig {
	
}
