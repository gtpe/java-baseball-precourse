package baseball;

public class ResultMessage {

    private static String messageForCount(int count, String message) {
        if(count > 0) {
            return count + message;
        }
        return "";
    }

    /**
     * 카운트 결과 메시지 반환
     */
    public static String getMessage(int strikeCount, int ballCount) {
        if(strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        return messageForCount(strikeCount, "스트라이크")
                + ((strikeCount > 0 && ballCount > 0) ? " " : "")
                + messageForCount(ballCount, "볼");
    }

}
