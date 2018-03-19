package com.example.pauseresume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

@SpringBootApplication
@EnableBinding(Source.class)
public class PauseresumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PauseresumeApplication.class, args);
	}

	@InboundChannelAdapter(channel = Source.OUTPUT, poller = @Poller(fixedDelay = "5000"))
    public String adapter() {
        return "foo";
    }
}
