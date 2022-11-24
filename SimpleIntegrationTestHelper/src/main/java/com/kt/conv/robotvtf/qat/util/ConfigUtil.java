package com.kt.conv.robotvtf.qat.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class ConfigUtil {
	
}
/*
@Configuration						// 빈 등록
@RequiredArgsConstructor
@PropertySource("classpath:config/application-${runtime.mode}.properties") 	// classpath는 src/main/resource/ 
public class ConfigUtil {

	@Autowired
    private final Environment environment;

	//@Bean
    public String getProperty(String key){
        return environment.getProperty(key);
    }
}
*/