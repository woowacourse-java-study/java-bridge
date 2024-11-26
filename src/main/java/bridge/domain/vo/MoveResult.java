package bridge.domain.vo;

import java.util.List;
import java.util.StringJoiner;

public class MoveResult {
	
	private final List<StepResult> stepResults;
	
	public MoveResult(List<StepResult> stepResults) {
		this.stepResults = stepResults;
	}
	
	public boolean isFail() {
		for (StepResult stepResult : stepResults) {
			if (!stepResult.isSuccess()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		StringJoiner upStringJoiner = new StringJoiner("|", "[", "]");
		StringJoiner downStringJoiner = new StringJoiner("|", "[", "]");
		
		stepResults.forEach(stepResult -> {
			upStringJoiner.add(stepResult.getUpString());
			downStringJoiner.add(stepResult.getDownString());
		});
		
		return stringBuilder.append(upStringJoiner)
				.append("\n")
				.append(downStringJoiner)
				.append("\n")
				.toString();
	}
}
