import {React} from 'react';
import { Link } from 'react-router-dom';

import './MatchSmallCard.scss';




export const MatchSmallCard = ({teamName,match}) => {
  
    
    const otherTeam=(match.team1=== teamName)? match.team2 : match.team1;
    const otherTeamRoute= `/iplteams/team/${otherTeam}`;
    const isMatchWon= teamName=== match.winningTeam;


    return (
    <div className={isMatchWon ? 'MatchSmallCard won-card': 'MatchSmallCard loss-card'}>
        <span>
                <i>vs</i>
        </span>
            <h4 ><Link to={otherTeamRoute}>  {otherTeam}</Link></h4>
        <ul>
            <li>{match.winningTeam} won by {match.margin} runs </li>
        </ul>
      
    </div>
  );
}


