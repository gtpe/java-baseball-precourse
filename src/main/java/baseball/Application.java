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

    /**
     * 게임 재시작 여부 반환
     */
    private static boolean isRestart() {
        System.out.println(NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputStr = Console.readLine();
        if(!("1").equals(inputStr) && !("2").equals(inputStr)) {
            System.out.println("[ERROR] 입력값이 1 또는 2가 아닙니다. 다시 입력해 주세요.");
            return isRestart();
        }
        return ("1").equals(inputStr);
    }

    /**
     * 게임 실행
     */
    public static void main(String[] args) {
        do {
            Game game = new Game(NUMBER_SIZE);
            while(game.isPlaying()) {
                System.out.println(game.play(getInputArray()));
            }
        } while(isRestart());
    }

}
