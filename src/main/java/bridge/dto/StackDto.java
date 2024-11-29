package bridge.dto;

public class StackDto {
    int tryStack;
    int blockStack;

    public StackDto() {
        this.tryStack = 0;
        this.blockStack = 0;
    }

    public int getTryStack() {
        return tryStack;
    }

    public int getBlockStack() {
        return blockStack;
    }

    public void plusOneTryStack() {
        tryStack++;
    }

    public void plusOneBlockStack() {
        blockStack++;
    }

    public void resetBlockStack() {
        blockStack = 0;
    }
}
