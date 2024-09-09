<template>
  <div>
    <apexchart type="line" :options="chartOptions" :series="series"></apexchart>
  </div>
</template>

<script>
import { defineComponent, reactive } from 'vue';

export default defineComponent({
  setup() {
    const state = reactive({
      series: [{
        name: 'Sales',
        data: [
          { x: new Date('2023-01-01').getTime(), y: 30 },
          { x: new Date('2023-01-02').getTime(), y: 40 },
          { x: new Date('2023-01-03').getTime(), y: 35 },
          // 더 많은 데이터 포인트 추가
        ]
      }],
      chartOptions: {
        chart: {
          type: 'line',
          height: 350,
          zoom: {
            enabled: true
          }
        },
        xaxis: {
          type: 'datetime'
        },
        tooltip: {
          x: {
            format: 'dd MMM yyyy'
          }
        }
      }
    });

    return {
      ...state
    };
  }
});
</script>
