import React from 'react';
import { Pie } from 'react-chartjs-2';






export const PieChart = ({ data }) => {
  const chartData = {
    labels: data.labels,
    datasets: [
      {
        data: data.values,
        backgroundColor: data.colors,
      },
    ],
  };

  const chartOptions = {
    responsive: true,
    maintainAspectRatio: false,
  };
  

  return <Pie data={chartData} options={chartOptions} />;
};



