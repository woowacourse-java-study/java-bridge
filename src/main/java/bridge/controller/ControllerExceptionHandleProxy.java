package bridge.controller;

import bridge.exception.ExceptionHandler;

public class ControllerExceptionHandleProxy implements Controller {
	
	private final Controller targetController;
	private final ExceptionHandler exceptionHandler;
	
	public ControllerExceptionHandleProxy(Controller targetController, ExceptionHandler exceptionHandler) {
		this.targetController = targetController;
		this.exceptionHandler = exceptionHandler;
	}
	
	@Override
	public void run() {
		try {
			targetController.run();
		} catch (RuntimeException e) {
			exceptionHandler.handleException(e);
			throw e;
		}
	}
}
