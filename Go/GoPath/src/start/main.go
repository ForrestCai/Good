package main

import (
	"fmt"
	"math"
)

func main() {
	//Greeting()
	//ChanTest()
	//LoopTest()
	//LoopTest2()
	//SliceTest()

	//x,y:=swap("hello","world")
	//fmt.Println("%d   %d", x, y)


	x:=getSequence()
    y:=x()
	fmt.Println(x())
	fmt.Println("%d", y)

	/* 声明函数变量 */
	getSquareRoot := func(x float64) float64 {
		return math.Sqrt(x)
	}

	/* 使用函数 */
	fmt.Println(getSquareRoot(9))

}