package bridge.domain;

import static java.lang.Integer.*;
import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class Bridge {
    private static final String INPUT_NOT_INTEGER_ERROR = "[ERROR] 생성할 다리의 길이는 정수만 입력이 가능합니다.";
    private static final String INPUT_VALID_RANGE_OF_NUMBER_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final List<String> bridge;

    public Bridge(String input) {
        validateBridgeSize(input);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(parseInt(input));
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public String getBlock(int index) {
        return bridge.get(index);
    }

    private void validateBridgeSize(String input) {
        validateInteger(input);
        validateRange(parseInt(input));
    }

    private void validateInteger(String size) {
        String regex = "^[0-9]+$";

        if (!size.matches(regex)) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR);
        }

    }

    private void validateRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(INPUT_VALID_RANGE_OF_NUMBER_ERROR);
        }
    }
}
