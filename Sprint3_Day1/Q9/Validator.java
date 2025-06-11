package Q9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Validator<T> {
    private final T object;
    private final List<String> errors = new ArrayList<>();

    public Validator(T object) {
        this.object = object;
    }

    public Validator<T> rule(Predicate<T> condition, String errorMessage) {
        if (!condition.test(object)) {
            errors.add(errorMessage);
        }
        return this;
    }

    public void validate() {
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}

