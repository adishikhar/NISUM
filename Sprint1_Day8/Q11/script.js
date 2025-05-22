function checkPalindrome() {
  const input = document.getElementById("inputText").value.trim().toLowerCase();
  const cleaned = input.replace(/[^a-z0-9]/gi, '');
  const reversed = cleaned.split('').reverse().join('');
  
  const result = document.getElementById("result");
  
  if (cleaned === "") {
    result.textContent = "Please enter a valid string.";
  } else if (cleaned === reversed) {
    result.textContent = `"${input}" is a palindrome`;
  } else {
    result.textContent = `"${input}" is not a palindrome`;
  }
}
