class Yatzy(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) {

    private var dice: IntArray = IntArray(5)
    private var counts: IntArray = IntArray(6)

    init {
        this.dice[0] = d1
        this.dice[1] = d2
        this.dice[2] = d3
        this.dice[3] = d4
        this.dice[4] = d5
        for (die in this.dice) this.counts[die - 1]++
    }


    fun ones(): Int {
        return this.counts[0]
    }

    fun twos(): Int {
        return this.counts[1] * 2
    }

    fun threes(): Int {
        return this.counts[2] * 3
    }

    fun fours(): Int {
        return this.counts[3] * 4
    }

    fun fives(): Int {
        return this.counts[4] * 5
    }

    fun sixes(): Int {
        return this.counts[5] * 6
    }

    fun chance(): Int {
        return this.dice.sum()
    }

    fun yatzy(): Int {
        if (!this.counts.contains(5)) return 0
        return 50
    }

    fun scorePair(): Int {
        for ((index, count) in this.counts.reversedArray().withIndex()) {
            if (count >= 2) return (6 - index) * 2
        }
        return 0
    }

    fun twoPair(): Int {
        var n = 0
        var score = 0
        for ((index, count) in this.counts.withIndex()) {
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
        for ((index, count) in this.counts.withIndex()) {
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
            if (counts[i] != 1) return false
        }
        return true
    }

    fun fullHouse(): Int {
        if (!counts.contains(2) || !counts.contains(3)) return 0
        return (counts.indexOf(2) + 1) * 2 + (counts.indexOf(3) + 1) * 3
    }
}


