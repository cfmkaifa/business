package org.forbes.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.spring.annotation.GlobalTransactionScanner;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
@ConditionalOnProperty(value="seata.auto.enabled",matchIfMissing=true)
public class SeataAutoConfig {


	/**
	 * init global transaction scanner
	 *
	 * @Return: GlobalTransactionScanner
	 */
	@Bean
	public GlobalTransactionScanner globalTransactionScanner() {
		log.info("配置seata........");
		return new GlobalTransactionScanner("usercenter-service", "usercenter-group");
	}
}
