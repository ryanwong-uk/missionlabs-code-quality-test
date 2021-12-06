package com.example.codequality

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.Test

class SumMultiplesTest {

    @Test
    fun sumMultiples_GetsTheRightAnswer() {
        // Note: The example tells us that for n in range 1 until 10 , the answer should be 23
        val multiplesToBeSummed = mutableListOf<Int>()
        SumMultiples().sumMultiplesOfThreeAndFive(10, multiplesToBeSummed) shouldBe 23

        // Check that it identified the right multiples
        multiplesToBeSummed.joinToString(", ") shouldBe "3, 5, 6, 9"
    }

    @Test
    fun sumMultiples_HandlesValidStringInputCorrectly_And_ReturnsZeroForInvalidStringInput() {
        // Note: SumMultiples always returns 0 if an exception was raised trying to make the numbers list
        SumMultiples().sumMultiplesOfThreeAndFive("10.0", mutableListOf()) shouldNotBe 0
        SumMultiples().sumMultiplesOfThreeAndFive("??", mutableListOf()) shouldBe 0
    }

    @Test
    fun sumMultiples_GetsTheRightAnswerFor1000() {
        // Try to calculate the sum of all the multiples of 3 or 5 for the range 1 until 1000
        // The expected answer is 233168
        val multiplesToBeSummed = mutableListOf<Int>()
        SumMultiples().sumMultiplesOfThreeAndFive(1000, multiplesToBeSummed) shouldBe 233168
    }
}