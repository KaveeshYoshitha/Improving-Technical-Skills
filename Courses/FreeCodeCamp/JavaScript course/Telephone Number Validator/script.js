function validatePhoneNumber() {
  clearResults();

  var userInput = document.getElementById("user-input").value.trim();

  if (userInput === "") {
    alert("Please provide a phone number");
    return;
  }

  var phoneRegex = /^(1\s?)?(\(\d{3}\)|\d{3})([\s\-]?)\d{3}([\s\-]?)\d{4}$/;

  if (phoneRegex.test(userInput)) {
    document.getElementById("results-div").innerText =
      "Valid US number: " + userInput;
  } else {
    document.getElementById("results-div").innerText =
      "Invalid US number: " + userInput;
  }
}

function clearResults() {
  document.getElementById("results-div").innerText = "";
}
