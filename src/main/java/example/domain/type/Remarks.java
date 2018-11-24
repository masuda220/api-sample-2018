package example.domain.type;

public class Remarks {
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
