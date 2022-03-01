fun main(args: Array<String>) {
    /*
    In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.

    Example

    For

    matrix = [[true, false, false],
        [false, true, false],
        [false, false, false]]
    the output should be

            solution(matrix) = [[1, 2, 1],
        [2, 1, 1],
        [1, 1, 1]]
    Check out the image below for better understanding:



    Input/Output

    [execution time limit] 3 seconds (kt)

    [input] array.array.boolean matrix

    A non-empty rectangular matrix consisting of boolean values - true if the corresponding cell contains a mine, false otherwise.

    Guaranteed constraints:
    2 ≤ matrix.length ≤ 100,
    2 ≤ matrix[0].length ≤ 100.

    [output] array.array.integer

            Rectangular matrix of the same size as matrix each cell of which contains an integer equal to the number of mines in the neighboring cells. Two cells are called neighboring if they share at least one corner.

   fun solution(matrix: MutableList<MutableList<Boolean>>):
   MutableList<MutableList<Int>> {

}
   */
    println("Hello World!")
    var entrada: MutableList<MutableList<Boolean>> = mutableListOf(
        mutableListOf(true, false),
        mutableListOf(false, true),
        mutableListOf(false, false))

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    println(entrada)
                println(solution(entrada))

}
fun solution(matrix: MutableList<MutableList<Boolean>>):
        MutableList<MutableList<Int>> {
    var salida: MutableList<MutableList<Int>> = MutableList(matrix.size){MutableList(matrix[0].size) { 0 }}
    var minas: MutableList<MutableList<Int>> = MutableList(matrix.size){MutableList(matrix[0].size) { 0 }}

    for (i in 0 .. matrix.indices.last)
        for (j in 0 .. matrix[0].indices.last)
            if(matrix[i][j])salida[i][j]=1
            else salida[i][j]=0


    for (i in 0 .. matrix.indices.last)
        for (j in 0 .. matrix[0].indices.last)
            minas[i][j]=0

    for (i in 0 .. matrix.indices.last)
        for (j in 0 .. matrix[0].indices.last)
            if(i==0 && j==0)
                minas[i][j]+=salida[i][j+1]+salida[i+1][j]+salida[i+1][j+1]
            else if(i==matrix.indices.last && j==matrix[0].indices.last)
                minas[i][j]+=salida[i][j-1]+salida[i-1][j]+salida[i-1][j-1]
            else if(i==0 && j==matrix[0].indices.last)
                minas[i][j]+=salida[i][j-1]+salida[i+1][j]+salida[i+1][j-1]
            else if(j==0 && i==matrix.indices.last)
            minas[i][j] += salida[i][j+1] + salida[i - 1][j] + salida[i - 1][j + 1]
            else if(i==0 && j>0 && j<matrix[0].indices.last)
                minas[i][j] += salida[i][j-1]+salida[i+1][j-1]+salida[i+1][j]+salida[i][j+1]+salida[i+1][j+1]
            else if(i==matrix.indices.last && j>0 && j<matrix[0].indices.last)
                minas[i][j] += salida[i][j-1]+salida[i-1][j-1]+salida[i-1][j]+salida[i][j+1]+salida[i-1][j+1]
            else if(j==0 && i>0 && i<matrix.indices.last)
                minas[i][j] += salida[i-1][j]+salida[i-1][j+1]+salida[i][j+1]+salida[i+1][j]+salida[i+1][j+1]
            else if(j==matrix[0].indices.last && i>0 && i<matrix.indices.last)
                minas[i][j] += salida[i-1][j]+salida[i-1][j-1]+salida[i][j-1]+salida[i+1][j]+salida[i+1][j-1]
            else
                minas[i][j] += salida[i-1][j-1]+salida[i-1][j]+salida[i-1][j+1]+salida[i][j-1]+salida[i][j+1]+salida[i+1][j-1]+salida[i+1][j]+salida[i+1][j+1]

    println(salida)

    return minas
}