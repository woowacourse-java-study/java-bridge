package bridge.io.output;

import bridge.common.dto.GameResult;
import bridge.common.dto.MoveResult;
import bridge.io.writer.Writer;

public class OutputView {
	
	private final Writer writer;
	private final OutputParser outputParser;
	
	public OutputView(Writer writer, OutputParser outputParser) {
		this.writer = writer;
		this.outputParser = outputParser;
	}
	
	public void printGreetings() {
		writer.write("다리 건너기 게임을 시작합니다.\n");
	}
	
	public void printMap(MoveResult moveResult) {
		String output = outputParser.parseMoveResult(moveResult);
		writer.write(output);
	}
	
	public void printResult(GameResult gameResult) {
		String stringBuilder = "\n최종 게임 결과\n" +
				outputParser.parseFinalMoving(gameResult) +
				"\n게임 성공 여부: " +
				outputParser.parseSuccess(gameResult) +
				"\n총 시도한 횟수: " +
				outputParser.parseTotalTryCount(gameResult);
		writer.write(stringBuilder);
	}
}
