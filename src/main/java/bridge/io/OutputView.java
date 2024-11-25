package bridge.io;

import bridge.domain.GameResult;
import bridge.domain.MoveStatus;
import bridge.io.writer.Writer;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    
    private final Writer writer;
    
    public OutputView(Writer writer) {
        this.writer = writer;
    }
    
    public void printGreetings() {
        writer.write("다리 건너기 게임을 시작합니다.\n\n");
    }
    
    public void printMap(MoveStatus moveStatus) {
        writer.write(moveStatus.toString());
    }

    public void printResult(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 게임 결과\n");
        stringBuilder.append(gameResult.getMoveStatus());
        stringBuilder.append("\n\n");
        stringBuilder.append("게임 성공 여부: ")
                .append(getSucessResult(gameResult))
                .append("\n");
        stringBuilder.append("총 시도한 횟수: ")
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
