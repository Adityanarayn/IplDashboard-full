import React, { useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import { MatchYearCard } from '../Components/MatchYearCard';
// import { Button, Dropdown, DropdownButton } from 'react-bootstrap';  // Assuming 'Button' and 'Dropdown' are components from react-bootstrap
import {DateComponent} from '../Components/DateComponent'


import './MatchPage.scss';

export const MatchPage = () => {
  const [iplteams,  setIplTeams] = useState([]);
 
  const { teamName, year } = useParams();

  useEffect(() => {
    const fetchDetails = async () => {
      try {
        const response = await fetch(`http://localhost:8080/ipl/teamName/${teamName}/matches/${year}`);
        const data = await response.json();
        console.log(data); // if this is null we have to display that the team data has not been found for the given year 
        setIplTeams(data);

        
        
       
      } catch (error) {
        console.error('Error fetching data', error);
      }
    };
    fetchDetails();
  }, [teamName, year]);
 
  
  return (
    <div className="MatchPage">
     
      <h1><Link to={'/'} >{teamName}</Link></h1>
      <h2 className="Mini-Heading"> Matches of the year: {year}</h2>
      
      <div className='dateDetails'>
        <DateComponent teamName={teamName}/>
      </div>

      <div className='matchDetails'>
      {iplteams.length > 0 ? (
          iplteams.map((match) => (
            <MatchYearCard teamName={teamName} match={match} key={match.matchId} />
          ))
        ) : (
          <div className='centered-message'>
            <p>Team data not found.</p>
          </div>
        )}
      </div>
    </div>
  );
};



