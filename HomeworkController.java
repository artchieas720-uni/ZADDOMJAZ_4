package pl.pjatk.artszc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @GetMapping("/path/{value}")
    public ResponseEntity<HomeworkInfo> getByPathVariable(@PathVariable String value) {
        return ResponseEntity.ok(new HomeworkInfo("pathVariable", value));
    }

    @GetMapping("/param")
    public ResponseEntity<HomeworkInfo> getByRequestParam(@RequestParam String value) {
        return ResponseEntity.ok(new HomeworkInfo("requestParam", value));
    }

    @PostMapping
    public ResponseEntity<HomeworkRequest> createHomework(@RequestBody HomeworkRequest homeworkRequest) {
        return ResponseEntity.ok(homeworkRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HomeworkResponse> updateHomework(
            @PathVariable String id,
            @RequestBody HomeworkRequest homeworkRequest
    ) {
        return ResponseEntity.ok(
                new HomeworkResponse(id, homeworkRequest.getName(), homeworkRequest.getDescription())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomework(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }
}
