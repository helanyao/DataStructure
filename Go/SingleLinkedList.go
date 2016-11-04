package SingleLinkedList

import (
	"fmt"
    "errors"
)

type Node struct {
    next  *Node
    value string
}

func PrintNode(node Node) {
    fmt.Println("****Start printing node info:")
    fmt.Println("value = " + node.value)
    if ExistNext(node) {
        fmt.Println("next: ")
        fmt.Println(node.next)
    } else {
        fmt.Println("no next node")
    }
    
}

func SetValue(value string, node * Node)  {
    node.value = value
}

func ExistNext(node Node) bool {
    if &node == nil {
        errMsg := "ERROR! the node is empty"
        fmt.Println(errMsg)
        panic(errors.New(errMsg))
    }

    if node.next != nil {
        return true
    } else {
        return false
    }
}