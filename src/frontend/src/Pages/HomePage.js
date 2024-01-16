import {React, useEffect, useState} from 'react';

import { TeamDetailCard } from '../Components/TeamDetailCard'
import './HomePage.scss'




export const HomePage = () => {
  const [team,setTeams]= useState([]);

  useEffect(
    () => {
        const fetchDetails = async () => {
            try {
                const response= await fetch(`${process.env.REACT_APP_ROOT_URL}/iplteams/test`);
                const data= await response.json();
                setTeams(data);
                console.log(data);

                
            } catch (error) {
                console.error("Not Found", error);
            }
        }
        fetchDetails();

    },[]
  );

   


  
  
    return (
    <div className="HomePage">
        <div className='heading'>
          <h1>The IPL Dashboard</h1>
        </div>
        <div className='teamTile'>
          
                  <div className='teamNames'>
                    {
                    team.map(match => <TeamDetailCard key={match.id} teamName={match.name} />)
                    }
                  </div>
        </div>
    </div>
  );
}


