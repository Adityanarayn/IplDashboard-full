import {React} from 'react';
import { Link } from 'react-router-dom'

import './TeamDetailCard.scss';


export const TeamDetailCard = ({teamName,match}) => {
    if (!teamName) return null;
    
    const teamRoute=`/iplteams/team/${teamName}`;
    return (
    <div className='TeamDetailCard'>
        
        <div>
          <h2><Link to={teamRoute}>{teamName}</Link> </h2>
        </div>
        
      
    </div>
  );
}


