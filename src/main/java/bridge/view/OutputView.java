package bridge.view;

import bridge.dto.ResultBridgeDto;
import bridge.dto.StackDto;
import java.util.List;

public class OutputView {
    public void printGameIntro() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printMap(ResultBridgeDto resultBridgeDto) {
        System.out.println(makeMapForPrint(resultBridgeDto));
    }

    public void printResult(ResultBridgeDto resultBridgeDto, StackDto stackDto, boolean isGameWin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 게임 결과\n");
        stringBuilder.append(makeMapForPrint(resultBridgeDto));
        stringBuilder.append("게임 성공 여부: ");
        appendGameWinResult(isGameWin, stringBuilder);
        stringBuilder.append("총 시도한 횟수: ");
        stringBuilder.append(stackDto.getTryStack());
        System.out.println(stringBuilder);
    }

    public void printError(String errorMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ERROR] ");
        stringBuilder.append(errorMessage);
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    private String makeMapForPrint(ResultBridgeDto resultBridgeDto) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> upperBridge = resultBridgeDto.getUpperBridge().getBridge();
        List<String> lowerBridge = resultBridgeDto.getLowerBridge().getBridge();
        makeEachBridgeForPrint(upperBridge, stringBuilder);
        makeEachBridgeForPrint(lowerBridge, stringBuilder);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private void makeEachBridgeForPrint(List<String> bridgeDto, StringBuilder stringBuilder) {
        for (int i = 0; i < bridgeDto.size(); i++) {
            if (i == 0) {
                stringBuilder.append("[ ");
            }
            stringBuilder.append(bridgeDto.get(i));
            if (i == bridgeDto.size() - 1) {
                stringBuilder.append(" ]\n");
                return;
            }
            stringBuilder.append(" | ");
        }
    }

    private void appendGameWinResult(boolean isGameWin, StringBuilder stringBuilder) {
        if (isGameWin) {
            stringBuilder.append("성공\n");
            return;
        }
        stringBuilder.append("실패\n");
    }
}
