import {React} from 'react';
import { Link } from 'react-router-dom'



import './MatchYearCard.scss';


export const MatchYearCard = ({teamName,match}) => {
    if (!match) return null;
    const otherTeam=(match.team1=== teamName)? match.team2 : match.team1;
    const otherTeamRoute=`/iplteams/team/${otherTeam}`;
    const isMatchWon= teamName=== match.winningTeam;
    return (
    <div className={isMatchWon ? 'MatchYearCard won-card' : 'MatchYearCard loss-card'}>
        
        <div className='other-TeamName'>
            <span>vs</span>
            <h2><Link to={otherTeamRoute}>{otherTeam}</Link> </h2>
        </div>
        <div className='MatchDate'>
            <h3>Date: {match.date}</h3>
        </div>
        <div className='MatchDetails'>
            <ul>
                <li>Location : {match.venueDetails.stadiumName}, {match.city}</li>
                <li>{match.winningTeam} won by {match.margin} runs </li>
            </ul>
        </div>
      
    </div>
  );
}


