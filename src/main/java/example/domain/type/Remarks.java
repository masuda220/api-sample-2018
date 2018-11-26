package example.domain.type;

import javax.validation.constraints.Size;

public class Remarks {
    @Size(min = 5, max = 1000, message = "at least {min} characters")
    String value;

    public Remarks(String value) {
        this.value = value;
    }

    public Remarks() {
    }

    @Override
    public String toString() {
        return "Remarks{" +
                "value='" + value + '\'' +
                '}';
    }
}
