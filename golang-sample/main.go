package main

import (
	"fmt"
	"learn_protobuf/gamerscore/gamer"

	"google.golang.org/protobuf/proto"
)

func main() {
	p1 := gamer.MyMessage{
		PlayerName: "felipe",
		Score:      "900",
	}

	out, err := proto.Marshal(&p1)
	if err != nil {
		panic(err)
	}

	var p1Rec gamer.MyMessage
	if err := proto.Unmarshal(out, &p1Rec); err != nil {
		panic(err)
	}

	fmt.Println(p1Rec)

}
