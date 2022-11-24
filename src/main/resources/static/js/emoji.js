const input = document.querySelector(".inputRange");
const emoji = document.querySelector("#emoji")
input.oninput = ()=>{ 
  let sliderValue = input.value;
  if(sliderValue < 2){
    emoji.innerHTML = "&#128545";
  }
  if(sliderValue >= 4){
    emoji.innerHTML = "&#128551";
  }
  if(sliderValue >= 6){
    emoji.innerHTML = "&#128528";
  }
  if(sliderValue >= 8){
    emoji.innerHTML = "&#128578";
  }
  if(sliderValue >= 10){
    emoji.innerHTML = "&#128512";
  }
}
