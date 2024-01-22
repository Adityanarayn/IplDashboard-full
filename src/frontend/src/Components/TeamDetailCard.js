import {React} from 'react';
import { Link } from 'react-router-dom'

import './TeamDetailCard.scss';


<<<<<<< HEAD
export const TeamDetailCard = ({teamName}) => {
=======
export const TeamDetailCard = ({teamName,match}) => {
>>>>>>> 8052f41 (Optimised it for upload on aws)
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


