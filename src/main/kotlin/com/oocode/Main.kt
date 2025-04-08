@file:Suppress("UNUSED_PARAMETER")

fun main(args: Array<String>) {
    println("Hello World!")
}

interface Robot {
    fun moveOnto(from: Int, to: Int)
    fun moveOver(from: Int, to: Int)
//    fun pileOnto(from: Int, to: Int)
    fun quit()
    fun start(size:Int)
}

class BlocksParser(robot: Robot) {

    private var robot: Robot

    init {
        this.robot = robot
    }

    fun parse(input: String) {
        val arrayOfCommands = input.split("\n")
        val size = arrayOfCommands[0].toInt()
        robot.start(size)
        for (command in arrayOfCommands.toList().drop(1)){
            if (command == "quit") {
                robot.quit()
                return
            }
            val left = command.split(" ")[1].toInt()
            val right = command.split(" ")[3].toInt()
            if (command.split(" ")[2] == "onto"){
                robot.moveOnto(left, right)
            }
            else {
                robot.moveOver(left, right)
            }
        }
    }
}

