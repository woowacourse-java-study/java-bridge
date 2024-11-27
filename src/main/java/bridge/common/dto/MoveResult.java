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
		StringJoiner upStringJoiner = new StringJoiner("|", "[", "]");
		StringJoiner downStringJoiner = new StringJoiner("|", "[", "]");
		
		stepResults.stream()
				.sorted()
				.forEach(stepResult -> {
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
