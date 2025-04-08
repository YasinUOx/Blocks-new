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

        blocksParser.parse("0\nmove 3 onto 4")
        verify(robot).moveOnto(3,4)
    }

    @Test
    fun `canParseSingleMoveIntoInputVariation`() {
        val robot = mock(Robot::class.java)
        val blocksParser = BlocksParser(robot)

        blocksParser.parse("0\nmove 4 onto 3")
        verify(robot).moveOnto(4,3)
    }

    @Test
    fun `canParseSingleOverInput`() {
        val robot = mock(Robot::class.java)
        val blocksParser = BlocksParser(robot)

        blocksParser.parse("0\nmove 3 over 4")
        verify(robot).moveOver(3,4)
    }

//    @Test
//    fun `canparseSinglePileOntoInput`() {
//        val robot = mock(Robot::class.java)
//        val blocksParser = BlocksParser(robot)
//
//        blocksParser.parse("pile 3 onto 4")
//        verify(robot).pileOnto(3,4)
//    }

    @Test
    fun `canParseInputWithQuit`() {
        val robot = mock(Robot::class.java)
        val blocksParser = BlocksParser(robot)

        blocksParser.parse("0\nquit")
        verify(robot).quit()
    }

    @Test
    fun `canParseMultipleInputs`() {
        val robot = mock(Robot::class.java)
        val blocksParser = BlocksParser(robot)

        blocksParser.parse("""0
move 9 onto 1
move 8 over 1
move 4 over 9
quit""".trimIndent())
        verify(robot).moveOnto(9,1)
        verify(robot).moveOver(8,1)
        verify(robot).moveOver(4,9)
        verify(robot).quit()
    }


    @Test
    fun `canParseFullInput`() {
        val robot = mock(Robot::class.java)
        val blocksParser = BlocksParser(robot)

        blocksParser.parse("""10
move 9 onto 1
move 8 over 1
move 4 over 9
quit""".trimIndent())
        verify(robot).start(10)
        verify(robot).moveOnto(9,1)
        verify(robot).moveOver(8,1)
        verify(robot).moveOver(4,9)
        verify(robot).quit()
    }
}

