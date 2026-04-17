package pl.pjatk.artszc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getModel() {
        return ResponseEntity.ok(new Car("BMW", "X2"));
    }

    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> getHelloPathVariable(@PathVariable String someValue) {
        return ResponseEntity.ok(someValue);
    }

    @GetMapping(value = "/hello", params = "reqParam")
    public ResponseEntity<String> getHelloRequestParam(@RequestParam String reqParam) {
        return ResponseEntity.ok(reqParam);
    }

    @PostMapping("/model")
    public ResponseEntity<Car> createModel(@RequestBody Car car) {
        return ResponseEntity.ok(new Car(car.getBrand(), car.getModel()));
    }
}
