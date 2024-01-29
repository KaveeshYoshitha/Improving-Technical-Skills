function salaryCalculate() {
  let BSal = parseFloat(document.getElementById("BSal").value) || 0;

  let allowance = 0;

  if (document.getElementById("empPost").value === "Manager") {
    allowance = BSal * 0.15;
  } else if (document.getElementById("empPost").value === "Cleark") {
    allowance = BSal * 0.05;
  } else if (document.getElementById("empPost").value === "Staff") {
    allowance = BSal * 0.1;
  }

  if (document.getElementById("female").checked) {
    allowance += 5000;
  }

  let epf = 0;
  let etf = 0;

  if (document.getElementById("EmpStatus").checked) {
    epf = BSal * 0.12 + BSal * 0.08;
    etf = BSal * 0.03;
  }

  let NSal = BSal + allowance - BSal * 0.08;

  document.getElementById("Allowance").value = allowance.toFixed(2);
  document.getElementById("epf").value = epf.toFixed(2);
  document.getElementById("etf").value = etf.toFixed(2);
  document.getElementById("NSal").value = NSal.toFixed(2);
}
