package be.wmaes.testOne;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! Nice to have you here.%s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
    	return new Greeting(counter.incrementAndGet(), String.format(template, name, 
    			getGreeter()
    			.map(g -> " Greetingss from ".concat(g))
    			.orElse("")
    			)
    			
    			);
    }
    private Optional<String> getGreeter(){
    	return Optional.ofNullable(System.getenv("HOSTNAME"));
    }
}