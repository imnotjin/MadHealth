const submit = document.getElementById("submit");
const accountPrompt = document.getElementById("accountPrompt");
submit.addEventListener("click", () => {  
  const name = document.getElementById("userName").value;
  const gender = document.getElementById("userGender").value;
  const age = document.getElementById("userAge").value;
  const weight = document.getElementById("userWeight").value;
  const height = document.getElementById("userHeight").value;
  console.log(name);
  console.log(gender);
  console.log(age);
  console.log(weight);
  console.log(height);

  const f = "Input.txt";

  writeTextFile(f, name);
  writeTextFile(f, gender);
  writeTextFile(f, age);
  writeTextFile(f, weight);
  writeTextFile(f, height);
  
  function writeTextFile(afilename, output)
  {
    const txtFile = new File(afilename);
    txtFile.writeln(output);
    txtFile.close();
  }

  accountPrompt.remove();
 })