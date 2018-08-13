package main

import (
	"fmt"
	"unsafe"
)

func Greeting() {
	x := "hello1"
	y := 10
	fmt.Printf(x, " ", unsafe.Sizeof(x), " ", unsafe.Sizeof(y))
}

func ChanTest() {
	var c1, c2, c3 chan int
	var i1, i2 int
	select {
	case i1 = <-c1:
		fmt.Printf("received ", i1, " from c1\n")
	case c2 <- i2:
		fmt.Printf("sent ", i2, " to c2\n")
	case i3, ok := (<-c3): // same as: i3, ok := <-c3
		if ok {
			fmt.Printf("received ", i3, " from c3\n")
		} else {
			fmt.Printf("c3 is closed\n")
		}
	default:
		fmt.Printf("no communication\n")
	}
}

func LoopTest() {
	for a := 0; a < 10; a++ {
		fmt.Printf("a 的值为: %d\n", a)
	}

	a := 0

	for true{
		fmt.Printf("a 的值为: %d\n", a)
		a++;
		if a > 5 {
			break
		}
	}
}

func LoopTest2(){
	nubmers := [6]int{1,2,3,4,5,6}
	//nubmers = append(nubmers, 7)
	fmt.Println(len(nubmers))
	fmt.Println(cap(nubmers))

	for i,n := range nubmers{
		fmt.Println("%d位置的值为: %d\n", i, n)
	}
}

func SliceTest(){
	var numbers []int
	printSlice(numbers)

	/* 允许追加空切片 */
	numbers = append(numbers, 0)
	printSlice(numbers)

	/* 向切片添加一个元素 */
	numbers = append(numbers, 1)
	printSlice(numbers)

	/* 同时添加多个元素 */
	numbers = append(numbers, 2,3,4)
	printSlice(numbers)

	/* 创建切片 numbers1 是之前切片的两倍容量*/
	numbers1 := make([]int, len(numbers), (cap(numbers))*2)

	/* 拷贝 numbers 的内容到 numbers1 */
	copy(numbers1,numbers)
	printSlice(numbers1)
}

func printSlice(x []int){
	fmt.Printf("len=%d cap=%d slice=%v\n",len(x),cap(x),x)
}

func swap(x, y string) (string, string) {
	return y, x
}

func getSequence() func() int {
	i:=0
	return func() int {
		i+=1
		return i
	}
}

func FuncTest1(){

}

func FuncTest2(){

}
