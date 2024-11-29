package bridge.model;

import bridge.constant.GameValue;

public class Parser {

    public int bridgeSizeParser(String rawBridgeSize) {
        try {
            int bridgeSize = Integer.parseInt(rawBridgeSize.trim());
            bridgeSizeValidate(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리 길이는 숫자로 입력하여야 합니다.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public String moveParser(String rawMove) {
        if (rawMove.trim().equals(GameValue.UP) || rawMove.trim().equals(GameValue.DOWN)) {
            return rawMove.trim();
        }
        throw new IllegalArgumentException("잘못된 입력입니다. U, D 중 하나만 입력할 수 있습니다.");
    }

    public String retryParser(String rawRetry) {
        if (rawRetry.trim().equals(GameValue.RETRY) || rawRetry.trim().equals(GameValue.QUIT)) {
            return rawRetry.trim();
        }
        throw new IllegalArgumentException("잘못된 입력입니다. R, Q 중 하나만 입력할 수 있습니다.");
    }

    private static void bridgeSizeValidate(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("다리 길이는 3 이상 20 이하만 입력 가능합니다.");
        }
    }
}
