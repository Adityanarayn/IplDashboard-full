import { React, useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import { MatchDetailCard } from '../Components/MatchDetailCard';
import { MatchSmallCard } from '../Components/MatchSmallCard';
import { PieChart } from '../Components/PieChart';
import { Chart, ArcElement } from 'chart.js';

import './TeamPage.scss';

Chart.register(ArcElement);  // had to register the arcelement in the chart and for that the 
// chart and ArcElements have been imported from chart.js 

export const TeamPage = () => {
  const [team, setTeam] = useState({ latestMatches: [] });
  const { teamName } = useParams();

  useEffect(() => {
    const fetchDetails = async () => {
      try {
        const response = await fetch(`http://localhost:8080/iplteams/team/${teamName}`);
        const data = await response.json();
        console.log(data);
        setTeam(data);
      } catch (error) {
        console.error('Error fetching data', error);
      }
    };

    fetchDetails();
  }, [teamName]);

  const pieChartData = {
    labels: ['Wins', 'Loss'],
    values: [`${team.totalWins}`, `${team.totalLoss}`],
    colors: ['#C6A969', '#ff0000'],
  };

  if (!team.name) {
    return <h1> Team:{teamName} Not Found </h1>;
  }

  return (
    <div className="TeamPage">
      <div className="TeamName-section">
        <h1 className="teamName">{team.name}</h1>
      </div>
      <div className="WinsVsLoss">
        <PieChart data={pieChartData} />
      </div>
      <div className="MatchDetails">
        <h2 className="latestMatches-heading">Latest Matches</h2>
        <MatchDetailCard teamName={team.name} match={team.latestMatches[0]} />
      </div>
      {team.latestMatches.slice(1).map((match) => (
        <MatchSmallCard teamName={team.name} match={match} />
      ))}
      <div className="more-button">
        <Link to={'/'}>More -></Link>
      </div>
    </div>
  );
};
