let chart = undefined;

/** @type {HTMLCanvasElement} */
const canvas = document.getElementById("barChart");

/** @type {HTMLInputElement} */
const numberInput = document.getElementById("numberOfCountries");

async function generateChart() {
  const response = await fetch("https://restcountries.com/v3.1/all");

  /** @type {any[]} */
  const data = await response.json();

  const countriesToDisplay = parseInt(numberInput.value);
  const filteredData = data.slice(0, countriesToDisplay);

  chart?.destroy();
  chart = new Chart(canvas, {
    type: "bar",
    data: {
      labels: filteredData.map((c) => c.name.common),
      datasets: [
        {
          label: "Population",
          data: filteredData.map((c) => c.population),
          borderWidth: 1,
        },
      ],
    },
  });
}
