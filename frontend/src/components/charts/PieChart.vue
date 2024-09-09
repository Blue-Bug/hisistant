<template>
  <Pie :data="this.$data" :options="this.$options" />
</template>

<script>
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js'
import { Pie } from 'vue-chartjs'

ChartJS.register(ArcElement, Tooltip, Legend)

export default {
  components: {
    Pie
  },
  options: {
    responsive: true,
    maintainAspectRatio: false
  },
  data() {
    return {
      labels: ['VueJs', 'EmberJs', 'ReactJs', 'AngularJs'],
      datasets: [
        {
          backgroundColor: ['#41B883', '#E46651', '#00D8FF', '#DD1B16'],
          data: [40, 20, 80, 10]
        }
      ]
    }
  }
}
</script>
