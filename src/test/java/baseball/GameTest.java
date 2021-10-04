package baseball;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    static final int NUMBER_SIZE = 3; // 숫자 길이

    @Test
    void 게임을_진행_중인_경우() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)){
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3);
            Game game = new Game(NUMBER_SIZE);
            assertThat(game.play(new int[] { 3, 2, 7 })).isEqualTo("2볼");
            assertThat(game.isPlaying()).isTrue(); // 게임 진행 중
            assertThat(game.play(new int[] { 7, 3, 1 })).isEqualTo("1스트라이크 2볼");
            assertThat(game.isPlaying()).isTrue(); // 게임 진행 중
        }
    }

    @Test
    void 정답을_맞춘_경우() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)){
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(5, 2, 9);
            Game game = new Game(NUMBER_SIZE);
            assertThat(game.play(new int[] { 5, 2, 9 })).isEqualTo("3스트라이크");
            assertThat(game.isPlaying()).isFalse(); // 게임 끝
        }
    }

}