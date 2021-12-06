package com.example.codequality

import io.kotest.matchers.shouldBe
import org.junit.Before
import org.junit.Test

class SumMultiplesImprovedTest {

    private lateinit var sumMultiplesImproved: SumMultiplesImproved

    @Before
    fun setup() {
        sumMultiplesImproved = SumMultiplesImproved()
    }

    @Test
    fun sumMultiplesImproved_GetsTheRightAnswerFor10() {
        // Note: The example tells us that for n in range 1 until 10 , the answer should be 23
        sumMultiplesImproved.sumMultiplesOfThreeAndFive(10) shouldBe 23
    }

    @Test
    fun sumMultiplesImproved_HandlesValidStringInputCorrectly() {
        // Note: If a string contains a valid number like 10.0, it should treat it as 10 and return correct result
        sumMultiplesImproved.sumMultiplesOfThreeAndFive("10.0") shouldBe 23
    }

    @Test
    fun sumMultiplesImproved_ReturnsZeroForInvalidStringInput() {
        // Note: SumMultiples always returns 0 if an exception was raised trying to make the numbers list
        sumMultiplesImproved.sumMultiplesOfThreeAndFive("??") shouldBe 0
    }

    @Test
    fun sumMultiplesImproved_GetsTheRightAnswerFor1000() {
        // Try to calculate the sum of all the multiples of 3 or 5 for the range 1 until 1000
        // The expected answer is 233168
        sumMultiplesImproved.sumMultiplesOfThreeAndFive(1000) shouldBe 233168
    }
}