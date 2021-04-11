class Yatzy(private vararg val dice: Int) {

    private var counts = IntArray(6)

    init {
        require(dice.size == 5) {"Only five dice can be thrown."}
        for (die in dice) {
            counts[die - 1]++
            require(die in 1..6) {"Only dice with face values of 1 to 6 can be thrown."}
        }
    }

    fun ones(): Int {
        return counts[0]
    }

    fun twos(): Int {
        return counts[1] * 2
    }

    fun threes(): Int {
        return counts[2] * 3
    }

    fun fours(): Int {
        return counts[3] * 4
    }

    fun fives(): Int {
        return counts[4] * 5
    }

    fun sixes(): Int {
        return counts[5] * 6
    }

    fun chance(): Int {
        return dice.sum()
    }

    fun yatzy(): Int {
        if (!counts.contains(5)) return 0
        return 50
    }

    fun scorePair(): Int {
        for ((index, count) in counts.reversedArray().withIndex()) {
            if (count >= 2) return (6 - index) * 2
        }
        return 0
    }

    fun twoPair(): Int {
        var n = 0
        var score = 0
        for ((index, count) in counts.withIndex()) {
            if (count >= 2) {
                score += index + 1
                n++
            }
        }
        return if (n != 2) 0
        else score * 2
    }

    fun threeOfAKind(): Int {
        return findOfAKind(3)
    }

    fun fourOfAKind(): Int {
        return findOfAKind(4)
    }

    private fun findOfAKind(kindCount: Int): Int {
        for ((index, count) in counts.withIndex()) {
            if (count >= kindCount) return (index + 1) * kindCount
        }
        return 0
    }

    fun smallStraight(): Int {
        return if (!isStraight(0..4)) 0
        else 15
    }

    fun largeStraight(): Int {
        return if (!isStraight(1..5)) 0
        else 20
    }

    private fun isStraight(range: IntRange): Boolean {
        for (i in range) {
            if (counts[i] == 0) return false
        }
        return true
    }

    fun fullHouse(): Int {
        if (!counts.contains(2) || !counts.contains(3)) return 0
        return (counts.indexOf(2) + 1) * 2 + (counts.indexOf(3) + 1) * 3
    }
}


