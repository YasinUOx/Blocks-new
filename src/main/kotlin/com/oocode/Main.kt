@file:Suppress("UNUSED_PARAMETER")

fun main(args: Array<String>) {
    println("Hello World!")
}

interface Robot {
    fun moveOnto(from: Int, to: Int): String
    fun moveOver(from: Int, to: Int): String
}

class BlocksParser(robot: Robot) {

    private var robot: Robot

    init {
        this.robot = robot
    }

    fun parse(input: String){
        val left = input.split(" ")[1].toInt()
        val right = input.split(" ")[3].toInt()
        if (input.split(" ")[2] == "onto"){
            robot.moveOnto(left, right)
        }
        else {
            robot.moveOver(left, right)
        }


    }
}

