document.addEventListener("DOMContentLoaded", (event) => {
    console.log("Reverse String")
    reverseString("abcdefg")

    let s1 = ["One", "Two", "Three", "Four", "Five"]
    console.log(s1.join(", "))

    // sum of array
    sum([1, 2, 3, 4, 5])

    // max of array
    console.log("Max of array: ", max([1, 2, 3, 4, 5, 6]))

    // convert array to object
    const arr = [["Name", "Phú"], ["Age", "22"], ["Gender", "Male"]]
    console.log(convertToObject(arr));

    // word count
    const arr2 = ["Pham", "Duy", "Phu", "Pham", "Duy"]
    console.log(wordCount(arr2))

    // find max with spread operator
    const arr3 = [1, 2, 3, 4, 5, 6] // expect: 6
    console.log("Find max with spread: " + findMaxWithSpread(arr3))

    // even numbers in array
    const arr4 = [1, 2, 3, 4, 5, 6, 7, 8]
    console.log("Even number in the array: ", evenNumbers(arr4))

    // find first odd number in array
    const arr5 = [3, 4, 5, 6, 7] 
    console.log("First odd number in array: ", findFirstOdd(arr5)) // expect: 3

    // find sum of odd numbes in the array
    const arr6 = [1, 2, 3, 4, 5, 6, 7]
    console.log("Sum of odd numbers in the array: " + findSumOfOdds(arr6)) // expect: 1 + 3 + 5 + 7 = 16
    console.log("Sum of odd numbers in the array with best practise: " + findSumOfOddsBestPractise(arr6)) // expect: 1 + 3 + 5 + 7 = 16

    // test spread with string
    const str1 = "Phạm Duy Phu"
    console.log("Test spread" + [...str1])

    // find max frequence char in the string
    const str2 = "aabbbccccdddd"
    console.log("Max frequence of char in the string: " + maxFrequence(str2)) // expect: d

});

// reverse string
const reverseString = (str) => {
    let newStr = str.split('').reverse().join('')
    console.log(newStr)
}

// sum of array
const sum = (arr) => {
    // pattern: reduce(funtion for accumulator, initValue)
    const sum = arr.reduce((accumulator, currenValue) => {return accumulator += currenValue}, 0)
    console.log("Sum of array: ", sum);
}

// max of array
const max = (arr) => {
    return arr.reduce((accumulator, currenValue) => {
        return accumulator = Math.max(accumulator, currenValue)
    }, -1);
}

// convert array to object 
const convertToObject = (arr) => {
    return arr.reduce((accumulator, [key, value]) => {
        accumulator[key] = value;
        return accumulator;
    }, {})
}

// count frequence of word in the array
const wordCount = (arr) => {
    return arr.reduce((accumulator, currentValue) => {
        let check = accumulator.get(currentValue);
        check === undefined ? accumulator.set(currentValue, 1) : accumulator.set(currentValue, check + 1);
        return accumulator; 
    }, new Map());
}

// find max with spread operator 
// note: spread operator is quite similar tail recursive in some functional language programming such as: Prolog, Haskell
const findMaxWithSpread = (arr) => {
    return Math.max(...arr);
}

// filter even number in array
const evenNumbers = (arr) => {
    return arr.filter(item => item % 2 == 0)
}

// find first odd number in array
const findFirstOdd = (arr) => {
    return arr.find(item => item % 2 !== 0)
}

// sum of odd numbers in array 
const findSumOfOdds = (arr) => {
    return arr.filter(item => item % 2 !== 0)
        .reduce(((accumulator, currenValue) => {
            return accumulator += currenValue;
        }), 0)
}

// version 2 for "Sum of odd numbers in array:
const findSumOfOddsBestPractise = (arr) => {
    return arr.filter(item => item % 2 !== 0).reduce((accumulator, currenValue) => accumulator + currenValue, 0)
}


// find max frequence of term in string
const maxFrequence = (str) => {
    // find frequence of each term in array
    const freMap = [...str].reduce((accumulator, char) => {
        let frequence = accumulator.get(char) || 0;

        accumulator.set(char, frequence + 1)
        return accumulator;
    }, new Map());

    let maxFrequence = -1;
    let maxChar = '';
    freMap.forEach((frequence, char) => {
       if(frequence >= maxFrequence) {
            maxFrequence = frequence
            maxChar = char;

            console.log("max char each loop: " + maxChar)
       }
    })
    return maxChar;
}

// Notes for javascript(15/10/2024)
// Some function with function programming: foreach(callback_function), filter(callback_function), reduce(callback_function, init_value), find(callback_function)
// --> All function is related functional programming passed callback function
// Some common function: Math.max(1, 2, 3, 4), Math.max(...arr)- Spread operator, pattern forEach((value, key))
// Map datastructure: has, get, set
// Object: object[key] = value, image object same map
// Operator: ||, example: frequence = accumulator.get(char) || 0;

