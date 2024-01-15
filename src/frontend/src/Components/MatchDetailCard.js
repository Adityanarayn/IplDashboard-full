import {React} from 'react';
import { Link } from 'react-router-dom'

import './MatchDetailCard.scss';


export const MatchDetailCard = ({teamName,match}) => {
    if (!match) return null;
    const otherTeam=(match.team1=== teamName)? match.team2 : match.team1;
    const otherTeamRoute=`/iplteams/team/${otherTeam}`;
    const isMatchWon= teamName === match.winningTeam;

    return (
    <div className= {isMatchWon ? 'MatchDetailCard won-card':'MatchDetailCard loss-card'} >
        <div className='primary-details'>
            
             <span className='vs'>vs</span> <h2 className='other-teamName'> <Link to={otherTeamRoute}>{otherTeam}</Link> </h2>
            <h3 className='date-section'><Link to={`/iplteams/team/${teamName}/matches/${match.season}`}>Date: {match.date}</Link></h3>
            <ul className='list-items'>
                <li>Location : {match.venueDetails.stadiumName}, {match.city}</li>
                <li>{match.winningTeam} won by {match.margin} runs </li>
            </ul>
        </div>

        <div className='secondary-details'>
            <h3>Toss Winner</h3>
                <p>{match.tossWinner}</p>
            <h3>Toss Decision</h3>
                <p>{match.team1} chose to {match.tossDecision} </p>
            <h3>Man of the match</h3>
                <p>{match.playerOfMatch}</p>
        </div>
      
    </div>
  );
}


