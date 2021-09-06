package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotFoundException extends AbstractThrowableProblem {

    public NotFoundException(long id, String entity) {
        super(
                URI.create(entity + "/not-found"),
                entity + " not found",
                Status.NOT_FOUND,
                String.format(entity + " not found with ID '%d'", id));}
}