package bridge.io;

import bridge.domain.vo.GameResult;
import bridge.domain.vo.MoveResult;
import bridge.io.writer.Writer;

public class OutputView {
    
    private final Writer writer;
    
    public OutputView(Writer writer) {
        this.writer = writer;
    }
    
    public void printGreetings() {
        writer.write("다리 건너기 게임을 시작합니다.\n");
    }
    
    public void printMap(MoveResult moveResult) {
        writer.write(moveResult.toString());
    }

    public void printResult(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n최종 게임 결과\n");
        stringBuilder.append(gameResult.getMoveStatus());
        stringBuilder.append("\n게임 성공 여부: ")
                .append(getSucessResult(gameResult));
        stringBuilder.append("\n총 시도한 횟수: ")
                .append(gameResult.getTotalTryCount());
        writer.write(stringBuilder.toString());
    }
    
    private static String getSucessResult(GameResult gameResult) {
        if (gameResult.getMoveStatus().isFail()) {
            return "실패";
        }
        return "성공";
    }
}
