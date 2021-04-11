import org.junit.*
import org.junit.Assert.*

class YatzyTest {

    @Test
    fun chance_scores_sum_of_all_dice() {
        assertEquals(5, Yatzy(1, 1, 1, 1, 1).chance())
        assertEquals(15, Yatzy(2, 3, 4, 5, 1).chance())
        assertEquals(16, Yatzy(3, 3, 4, 5, 1).chance())
        assertEquals(25, Yatzy(5, 5, 5, 5, 5).chance())
    }

    @Test
    fun yatzy_scores_50() {
        assertEquals(0, Yatzy(6, 6, 6, 6, 1).yatzy())
        assertEquals(50, Yatzy(1, 1, 1, 1, 1).yatzy())
        assertEquals(50, Yatzy(4, 4, 4, 4, 4).yatzy())
        assertEquals(50, Yatzy(6, 6, 6, 6, 6).yatzy())
    }

    @Test
    fun ones() {
        assertEquals(0, Yatzy(6, 2, 2, 4, 5).ones())
        assertEquals(1, Yatzy(1, 2, 3, 4, 5).ones())
        assertEquals(2, Yatzy(1, 2, 1, 4, 5).ones())
        assertEquals(4, Yatzy(1, 2, 1, 1, 1).ones())
    }

    @Test
    fun twos() {
        assertEquals(0, Yatzy(1, 1, 3, 5, 6).twos())
        assertEquals(2, Yatzy(1, 2, 3, 4, 6).twos())
        assertEquals(4, Yatzy(1, 2, 3, 2, 6).twos())
        assertEquals(10, Yatzy(2, 2, 2, 2, 2).twos())
    }

    @Test
    fun threes() {
        assertEquals(0, Yatzy(1, 2, 4, 5, 6).threes())
        assertEquals(3, Yatzy(3, 1, 2, 4, 6).threes())
        assertEquals(6, Yatzy(3, 3, 4, 5, 6).threes())
        assertEquals(12, Yatzy(2, 3, 3, 3, 3).threes())
    }

    @Test
    fun fours() {
        assertEquals(0, Yatzy(5, 5, 5, 5, 5).fours())
        assertEquals(4, Yatzy(4, 5, 5, 5, 5).fours())
        assertEquals(8, Yatzy(4, 4, 5, 5, 5).fours())
        assertEquals(12, Yatzy(4, 4, 4, 5, 5).fours())
    }

    @Test
    fun fives() {
        assertEquals(0, Yatzy(1, 1, 1, 1, 1).fives())
        assertEquals(5, Yatzy(5, 1, 1, 1, 1).fives())
        assertEquals(10, Yatzy(4, 4, 4, 5, 5).fives())
        assertEquals(15, Yatzy(4, 4, 5, 5, 5).fives())
        assertEquals(20, Yatzy(5, 5, 5, 5, 1).fives())
    }

    @Test
    fun sixes_test() {
        assertEquals(0, Yatzy(4, 4, 4, 5, 5).sixes())
        assertEquals(6, Yatzy(4, 4, 6, 5, 5).sixes())
        assertEquals(18, Yatzy(6, 5, 6, 6, 5).sixes())
    }

    @Test
    fun one_pair() {
        assertEquals(6, Yatzy(3, 4, 3, 5, 6).scorePair())
        assertEquals(10, Yatzy(5, 3, 3, 3, 5).scorePair())
        assertEquals(12, Yatzy(5, 3, 6, 6, 5).scorePair())
        assertEquals(0, Yatzy(1, 2, 3, 4, 5).scorePair())
    }

    @Test
    fun two_pair() {
        assertEquals(0, Yatzy(3, 4, 5, 4, 1).twoPair())
        assertEquals(16, Yatzy(3, 3, 5, 4, 5).twoPair())
        assertEquals(16, Yatzy(3, 3, 5, 5, 5).twoPair())
    }

    @Test
    fun three_of_a_kind() {
        assertEquals(0, Yatzy(3, 3, 4, 4, 5).threeOfAKind())
        assertEquals(9, Yatzy(3, 3, 3, 4, 5).threeOfAKind())
        assertEquals(15, Yatzy(5, 3, 5, 4, 5).threeOfAKind())
        assertEquals(9, Yatzy(3, 3, 3, 3, 5).threeOfAKind())
        assertEquals(9, Yatzy(3, 3, 3, 3, 3).threeOfAKind())
    }

    @Test
    fun four_of_a_knd() {
        assertEquals(0, Yatzy(3, 3, 3, 5, 5).fourOfAKind())
        assertEquals(12, Yatzy(3, 3, 3, 3, 5).fourOfAKind())
        assertEquals(20, Yatzy(5, 5, 5, 4, 5).fourOfAKind())
    }

    @Test
    fun small_straight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5))
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1))
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5))
    }

    @Test
    fun large_straight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5))
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6))
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5))
    }

    @Test
    fun full_house() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6))
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6))
    }
}