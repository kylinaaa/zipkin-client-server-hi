package com.spring.cloud.demo.zipkinclientserverhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ZipkinClientServerHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinClientServerHiApplication.class, args);
	}


	private static final Logger LOG = Logger.getLogger(ZipkinClientServerHiApplication.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hei")
	public String callHome(){
		LOG.log(Level.INFO, "calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}
	@RequestMapping("/info2")
	public String info(){
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";
	}
	@RequestMapping("/in2")
	public String indsa(){
		LOG.log(Level.INFO, "calling trace service-hi ");
		return restTemplate.getForObject("http://localhost:8989/hello", String.class);
	}

//	@Bean
//	public AlwaysSampler defaultSampler(){
//		return new AlwaysSampler();
//	}



}

