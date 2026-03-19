//Problem Statement: Implement mergeSort in kotlin and implement dynamic Threading for faster execution

//Merge Function
fun merge(arr:Array<Int>, l:Int, right:Int, mid:Int){
    val leftArr = arr.copyOfRange(l, mid+1)
    val rightArr = arr.copyOfRange(mid+1, right+1)
    var i=0
    var j=0
    var k=l
    while(i < leftArr.size && j < rightArr.size){
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i]
            i++
        } else {
            arr[k] = rightArr[j]
            j++
        }
        k++
    }
    while (i < leftArr.size){
        arr[k] = leftArr[i]
        i++
        k++
    }

    while (j < rightArr.size) {
        arr[k] = rightArr[j]
        j++
        k++
    }
        
}

//MergeSort Function
fun mergeSort(arr:Array<Int>, l:Int, r:Int){
    if(l < r){
        var mid = l + (r - l) /2
        var left:Thread = parallelSort(arr, l, mid);
        var right:Thread = parallelSort(arr, mid+1, r)
        left.join()
        right.join()
        merge(arr,l, r, mid)
    }
}
//Array Creation for Faster Execiution
fun parallelSort(arr:Array<Int>, l:Int, r:Int):Thread{
    var temp:Thread = Thread{mergeSort(arr, l, r)}
    temp.start()
    return temp
}

//Main Function
fun main() {
    var array = arrayOf(1, 3, 2, 5, 6, 4, 9, 8, 70, 0, -1, -2)
    mergeSort(array, 0, 11)
    array.forEach{i->
    	print(i)
        print(" ")
    }
}
