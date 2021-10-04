package baseball;

import java.util.HashSet;

public class Validator {

    /**
     * 입력값이 숫자인지 확인
     */
    protected static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력값이 숫자가 아닙니다.");
            return false;
        }
        return true;
    }

    /**
     * 입력값 중복 확인
     */
    protected static boolean isDuplicated(String str) {
        char[] chars = str.toCharArray();
        HashSet<Character> tempSet = new HashSet<>();
        for(char ch : chars) {
            if(tempSet.add(ch) == false) {
                System.out.println("[ERROR] 중복되지 않는 숫자를 입력해 주세요.");
                return true;
            }
        }
        return false;
    }

    /**
     * 입력값에 0이 포함되어 있는지 확인
     */
    protected static boolean isContainZero(String str) {
        if(str.contains("0")) {
            System.out.println("[ERROR] 0을 제외한 숫자를 입력해 주세요.");
            return true;
        }
        return false;
    }

    /**
     * 입력값 사이즈 확인
     */
    protected static boolean isCorrectSize(String str, int size) {
        if(str.length() != size) {
            System.out.println("[ERROR] " + size + "개의 숫자를 입력해 주세요.");
            return false;
        }
        return true;
    }

    /**
     * 입력값 검증
     */
    protected static boolean validateInput(String inputStr, int size) {
        if(!isNumber(inputStr) || !isCorrectSize(inputStr, size) || isDuplicated(inputStr) || isContainZero(inputStr)) {
            return false;
        }
        return true;
    }

}
