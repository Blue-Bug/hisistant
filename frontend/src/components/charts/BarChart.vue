<template>
  <div>
    <apexchart type="bar" :options="chartOptions" :series="series"></apexchart>
  </div>
</template>

<script>
import { defineComponent, watch, reactive } from 'vue';
export default defineComponent({
  props: {
    salesData: {
      type: Array,
      required: true
    },
    salesLabel: {
      type: Array,
      required: true
    }
  },
  setup(props) {
    const state = reactive({
      series: [{
        name: 'Sales',
        data: []
      }],
      chartOptions: {
        chart: {
          type: 'bar',
          height: 350
        },
        plotOptions: {
          bar: {
            horizontal: true,
            columnWidth: '55%',
            endingShape: 'rounded'
          },
        },
        dataLabels: {
          enabled: false
        },
        stroke: {
          show: true,
          width: 2,
          colors: ['transparent']
        },
        xaxis: {
          categories: [],
          labels: {
            style: {
              fontSize: '12px',
              colors: ['#000']
            },
            formatter: function (val) {
              return val;
            },
            rotate: -45,
            maxHeight: 60
          }
        },
        yaxis: {
          title: {
            text: '주차'
          }
        },
        fill: {
          opacity: 1
        },
        tooltip: {
          y: {
            formatter: function (val) {
              return val + "원";
            }
          }
        }
      }
    });

    const processSalesData = (salesData, salesLabel) => {
      state.series[0].data = salesData;
      state.chartOptions.xaxis.categories = salesLabel;
    };

    watch(
        () => ({salesData: props.salesData, salesLabel: props.salesLabel}),
        (newVal) => {
          processSalesData(newVal.salesData, newVal.salesLabel);
        },
        {immediate: true, deep: true}
    );

    return {
      ...state
    };
  }
});
</script>
