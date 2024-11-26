package bridge.service.retryHandler;

import bridge.exception.CustomExceptions;
import bridge.exception.ExceptionHandler;

public class RetryHandler {

    private static final int MAX_ATTEMPTS = 10;

    private final ExceptionHandler exceptionHandler;

    public RetryHandler(final ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public <T> T tryUntilSuccess(final IllegalArgumentExceptionThrower<T> thrower) {
        int attempt = 0;
        while (attempt++ < MAX_ATTEMPTS) {
            try {
                return thrower.run();
            } catch (IllegalArgumentException illegalArgumentException) {
                exceptionHandler.handleException(illegalArgumentException);
            }
        }
        throw CustomExceptions.OVER_MAX_RETRY_ATTEPMT.get();
    }

    @FunctionalInterface
    public interface IllegalArgumentExceptionThrower<T> {
        T run() throws IllegalArgumentException;
    }
}
