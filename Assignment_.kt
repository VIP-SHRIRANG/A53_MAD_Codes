// 🧠 Problem: Remove Adjacent Duplicate Characters

// You are given a string S consisting of lowercase English letters.

// Your task is to repeatedly remove adjacent duplicate characters from the string until no such pairs remain.

// If two consecutive characters are the same, remove both.

// Continue this process until the string becomes stable (no more adjacent duplicates).
// 📥 Input

// A single string S

// 📤 Output

// Print the final string after removing all adjacent duplicate pairs.

// 📌 Example

// Input: abbaca

// Process:

// abbaca → aaca (remove "bb")

// aaca → ca (remove "aa")

// Output: ca


//Solution for the problem statement:-
import kotlin.*

fun removeConsistent(str:String){
    var tempStr = StringBuilder(str)
    str.forEach{char->
        if(tempStr.last() == char){
            tempStr.deleteCharAt(tempStr.length-1)
        }
        else{
            tempStr.append(char)
        }
    }
}

fun main() {
    
    var str:String = readLine() ?: ""
    removeConsistent(str)
    println()
}
