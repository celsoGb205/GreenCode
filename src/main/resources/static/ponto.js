const searchCityInput = document.getElementById("searchCity");
const searchWasteTypeInput = document.getElementById("searchWasteType");
const pontoContainers = document.querySelectorAll(".col-4.mb-5");




function filterPontoItems() {
  const cityQuery = searchCityInput.value.trim().toLowerCase();
  const wasteTypeQuery = searchWasteTypeInput.value.trim().toLowerCase();

  pontoContainers.forEach((ponto) => {
    const cityText = ponto.querySelector("h4:nth-child(3)").textContent.toLowerCase(); // Assuming city is the 3rd <h4>
    const wasteTypeText = ponto.querySelector("h4:nth-child(5)").textContent.toLowerCase(); // Assuming waste type is the 5th <h4>

    if (
      cityText.includes(cityQuery) &&
      wasteTypeText.includes(wasteTypeQuery)
    ) {
      ponto.style.display = "block";
    } else {
      ponto.style.display = "none";
    }
  });
}
