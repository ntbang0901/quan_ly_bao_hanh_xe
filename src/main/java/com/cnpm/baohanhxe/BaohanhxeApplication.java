package com.cnpm.baohanhxe;

import com.cnpm.baohanhxe.config.StorageProperties;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import com.cnpm.baohanhxe.repository.AccountRepository;
import com.cnpm.baohanhxe.repository.StaffRepository;
import com.cnpm.baohanhxe.service.StorageService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EntityScan("com.cnpm.baohanhxe.entity")
public class BaohanhxeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BaohanhxeApplication.class, args);
		AccountRepository accountRepository = context.getBean(AccountRepository.class);
		StaffRepository staffRepository = context.getBean(StaffRepository.class);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args->{
			storageService.init();
		});
	}

}
