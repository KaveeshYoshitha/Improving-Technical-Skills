function checkFunction() {
  let msg = "Fix the errors\n";
  let flag = 0;

  if (document.getElementById("name").value === "") {
    msg += "Name cannot be blank\n";
    flag = 1;
  }

  if (document.getElementById("address").value === "") {
    msg += "Address cannot be blank\n";
    flag = 1;
  }

  if (isNaN(document.getElementById("courseNo").value)) {
    msg += "CourseNo should be a number\n";
    flag = 1;
  }

  if (document.getElementById("reason").selectedIndex === 0) {
    msg += "Please select a reason\n";
    flag = 1;
  }
  if (
    !document.getElementById("cash").checked &&
    !document.getElementById("cheque").checked
  ) {
    msg += "Please select a refund method\n";
    flag = 1;
  }
  if (!document.getElementById("policy").checked) {
    msg += "Please agree to terms\n";
    flag = 1;
  }

  if (flag == 1) {
    alert(msg);
  }
}
