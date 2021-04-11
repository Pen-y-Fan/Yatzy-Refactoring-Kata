class Yatzy(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) {
// vararg dice: Int
    private var dice: IntArray = IntArray(5)
    private var tallies: IntArray = IntArray(6)

    init {
        this.dice[0] = d1
        this.dice[1] = d2
        this.dice[2] = d3
        this.dice[3] = d4
        this.dice[4] = d5
        this.tallies = tallies(d1, d2, d3, d4, d5)
    }


    fun ones(): Int {
        return this.tallies[0]
    }

    fun twos(): Int {
        return this.tallies[1] * 2
    }

    fun threes(): Int {
        return this.tallies[2] * 3
    }

    fun fours(): Int {
        return this.tallies[3] * 4
    }

    fun fives(): Int {
        return this.tallies[4] * 5
    }

    fun sixes(): Int {
        return this.tallies[5] * 6
    }

    fun chance(): Int {
        return this.dice.sum()
    }

    fun yatzy(): Int {
        if (!this.tallies.contains(5)) {
            return 0
        }
        return 50
    }

    companion object {


        fun scorePair(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies = tallies(d1, d2, d3, d4, d5)

            var at = 0
            while (at != 6) {
                if (tallies[6 - at - 1] >= 2)
                    return (6 - at) * 2
                at++
            }
            return 0
        }

        fun twoPair(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies = tallies(d1, d2, d3, d4, d5)

            var n = 0
            var score = 0
            var i = 0
            while (i < 6) {
                if (tallies[6 - i - 1] >= 2) {
                    n++
                    score += 6 - i
                }
                i += 1
            }
            return if (n == 2)
                score * 2
            else
                0
        }

        fun fourOfAKind(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies = tallies(d1, d2, d3, d4, d5)

            for (i in 0..5)
                if (tallies[i] >= 4)
                    return (i + 1) * 4
            return 0
        }

        fun threeOfAKind(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies = tallies(d1, d2, d3, d4, d5)

            for (i in 0..5)
                if (tallies[i] >= 3)
                    return (i + 1) * 3
            return 0
        }

        fun smallStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies = tallies(d1, d2, d3, d4, d5)

            return if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
            ) 15 else 0
        }

        fun largeStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            val tallies = tallies(d1, d2, d3, d4, d5)

            return if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1
            ) 20 else 0
        }

        fun fullHouse(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
            var i = 0
            var foundTwoPair = false
            var twoPairFoundAt = 0
            var foundThreePair = false
            var threePairFoundAt = 0

            val tallies = tallies(d1, d2, d3, d4, d5)

            while (i != 6) {
                if (tallies[i] == 2) {
                    foundTwoPair = true
                    twoPairFoundAt = i + 1
                }
                i += 1
            }

            i = 0
            while (i != 6) {
                if (tallies[i] == 3) {
                    foundThreePair = true
                    threePairFoundAt = i + 1
                }
                i += 1
            }

            return if (foundTwoPair && foundThreePair)
                twoPairFoundAt * 2 + threePairFoundAt * 3
            else
                0
        }

        private fun tallies(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): IntArray {
            val tallies = IntArray(6)
            tallies[d1 - 1] += 1
            tallies[d2 - 1] += 1
            tallies[d3 - 1] += 1
            tallies[d4 - 1] += 1
            tallies[d5 - 1] += 1
            return tallies
        }
    }
}


