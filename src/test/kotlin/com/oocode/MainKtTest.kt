package com.oocode
import BlocksParser
import Robot


import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class BlockParserTests{
    @Test
    fun `canParseSingleMoveIntoInput`() {
        val robot = mock(Robot::class.java)
        val blocksParser = BlocksParser(robot)

        blocksParser.parse("move 3 onto 4")
        verify(robot).moveOnto(3,4)
    }

    @Test
    fun `canParseSingleMoveIntoInputVariation`() {
        val robot = mock(Robot::class.java)
        val blocksParser = BlocksParser(robot)

        blocksParser.parse("move 4 onto 3")
        verify(robot).moveOnto(4,3)
    }

}

