package main

type IHuman interface{
	lauph() (int, string)
}

type man struct {
	name string
}

type woman struct{
	name string
}

func (aman *man) lauph() (int, string){
	(*aman).name = "a"
	//aman.name = "a"
	return 1, "man lauph"
}

func (awoman woman) lauph() (int, string){
	//(*awoman).name = "b"
	awoman.name = "a"
	return 2, "woman lauph"
}

