package bridge.common.dto;

import java.util.List;
import java.util.StringJoiner;

public record MoveResult(
		List<StepResult> stepResults
) {
	
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
		return stringBuilder
				.append(getUpString(stepResults))
				.append("\n")
				.append(getDownString(stepResults))
				.append("\n")
				.toString();
	}
	
	private static String getUpString(List<StepResult> stepResults) {
		StringJoiner upStringJoiner = new StringJoiner("|", "[", "]");
		stepResults.stream()
				.sorted()
				.forEach(stepResult -> upStringJoiner.add(stepResult.getUpString()));
		return upStringJoiner.toString();
	}
	
	private static String getDownString(List<StepResult> stepResults) {
		StringJoiner downStringJoiner = new StringJoiner("|", "[", "]");
		stepResults.stream()
				.sorted()
				.forEach(stepResult -> downStringJoiner.add(stepResult.getDownString()));
		return downStringJoiner.toString();
	}
}
