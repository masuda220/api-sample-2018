package example.presentation.xperiment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UUIDController {

    @PostMapping("/uuids/requests")
    public UUID create() {
        return UUID.randomUUID();
    }
}
