package bridge.exception;

public enum CustomExceptions {
	
	INVALID_BRIDGE_SIZE(
			"유효하지 않은 다리길이 포맷입니다.",
			IllegalArgumentException.class
	),
	INVALID_MOVE(
			"유효하지 않은 움직임 포맷입니다.",
			IllegalArgumentException.class
	),
	INVALID_RESTART(
			"유효하지 않은 재시작 포맷입니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_BRIDGE_SIZE(
			"다리길이는 %d부터 %d 사이의 숫자여야 합니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_MOVE(
			"움직임은 %s또는 %s만 가능합니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_STEP(
			"다리 단계는 %s또는 %s만 가능합니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_RESTART(
			"재시작은 %s또는 %s만 가능합니다.",
			IllegalArgumentException.class
	),
	OVER_MAX_RETRY_ATTEPMT(
			"최대 재시도 횟수를 초과하였습니다.",
			IllegalStateException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	CustomExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get(Object... args) {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message.formatted(args));
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}
