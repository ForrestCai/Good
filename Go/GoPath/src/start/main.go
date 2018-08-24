package main

import "fmt"

func main() {
	//Greeting()
	//ChanTest()
	//LoopTest()
	//LoopTest2()
	//SliceTest()

	//x,y:=swap("hello","world")
	//fmt.Println("%d   %d", x, y)


	//x:=getSequence()
    //y:=x()
	//fmt.Println(x())
	//fmt.Println("%d", y)

	///* 声明函数变量 */
	//getSquareRoot := func(x float64) float64 {
	//	return math.Sqrt(x)
	//}
	//
	///* 使用函数 */
	//fmt.Println(getSquareRoot(9))

	var hone IHuman

	hone = new(man)
	i,s:=hone.lauph()
	fmt.Println(i, s)
	fmt.Println(hone.(*man).name)

	hone = new(woman)
	i,s=hone.lauph()
	fmt.Println(i, s)
}