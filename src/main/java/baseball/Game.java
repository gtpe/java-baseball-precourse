package baseball;

import nextstep.utils.Randoms;

import java.util.HashMap;

public class Game {

    static final int START_NUMBER = 1; // 숫자 범위 중 가장 작은 숫자
    static final int END_NUMBER = 9; // 숫자 범위 중 가장 큰 숫자
    private int numberSize; // 숫자 길이
    private HashMap<Integer, Integer> randomMap; // 랜덤 숫자

    /**
     * 생성자 (게임 초기화)
     */
    public Game(int numberSize) {
        this.numberSize = numberSize;
        makeRandomMap();
    }

    /**
     * 랜덤 숫자 생성
     */
    private void makeRandomMap() {
        randomMap = new HashMap<>();
        int count = 0;
        while(randomMap.size() < numberSize) {
            int random = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if(randomMap.get(random) == null) {
                randomMap.put(random, count);
                count++;
            }
        }
    }

}
