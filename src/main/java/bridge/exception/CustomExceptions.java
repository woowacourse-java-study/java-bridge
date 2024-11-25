package bridge.exception;

public enum CustomExceptions {
	
	INVALID_MOVE(
			"유효하지 않은 움직임입니다.",
			IllegalArgumentException.class
	),
	INVALID_STEP(
			"유효하지 않은 다리단계입니다.",
			IllegalArgumentException.class
	),
	INVALID_RESTART(
			"유효하지 않은 재시작입니다.",
			IllegalArgumentException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	CustomExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get() {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message);
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}
