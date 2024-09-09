<template>
  <div>
    <apexchart type="donut" :options="chartOptions" :series="series"></apexchart>
  </div>
</template>

<script>
import { defineComponent, reactive } from 'vue';

export default defineComponent({
  setup() {
    const state = reactive({
      series: [44, 55, 41, 17, 15],
      chartOptions: {
        chart: {
          type: 'donut',
          height: 350
        },
        plotOptions: {
          pie: {
            startAngle: -90,
            endAngle: 90,
            offsetY: 10,
          }
        },
        dataLabels: {
          enabled: true
        },
        fill: {
          type: 'gradient'
        },
        legend: {
          position: 'bottom'
        },
        responsive: [{
          breakpoint: 480,
          options: {
            chart: {
              width: 200,
              height: 350,
            },
            legend: {
              position: 'bottom'
            }
          }
        }]
      }
    });

    return {
      ...state
    };
  }
});
</script>
