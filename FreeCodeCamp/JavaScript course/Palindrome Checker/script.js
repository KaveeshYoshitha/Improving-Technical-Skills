function checkNull() {
  const inputBtn = document.getElementById("text-input").value;

  const inputArray = inputBtn
    .toLowerCase()
    .split("")
    .filter((char) => /[a-z0-9]/.test(char));

  const reversedArray = [...inputArray].reverse();

  if (inputArray.length === 0) {
    alert("Please input a value");
    return;
  } else if (JSON.stringify(inputArray) === JSON.stringify(reversedArray)) {
    const resultPrint = document.getElementById("result");
    resultPrint.innerHTML = `${inputBtn} is a palindrome`;
  } else {
    const resultPrint = document.getElementById("result");
    resultPrint.innerHTML = `${inputBtn} is not a palindrome`;
  }
}
