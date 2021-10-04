package baseball;

import nextstep.utils.Console;

public class Application {

    static final int NUMBER_SIZE = 3; // 숫자 길이

    /**
     * 문자열을 숫자 배열로 반환
     */
    private static int[] getIntArray(String str) {
        char[] charArray = str.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i] - '0';
        }
        return intArray;
    }

    /**
     * 입력한 숫자 반환
     */
    private static int[] getInputArray() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        if(!Validator.validateInput(inputStr, NUMBER_SIZE)) {
            return getInputArray();
        }
        return getIntArray(inputStr);
    }

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
    }
}
