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