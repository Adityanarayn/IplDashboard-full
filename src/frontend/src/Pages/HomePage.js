import {React, useEffect, useState} from 'react';
import{ useParams } from 'react-router-dom';
import { TeamDetailCard } from '../Components/TeamDetailCard'
import './HomePage.scss'




export const HomePage = () => {
  const [team,setTeams]= useState([]);

  useEffect(
    () => {
        const fetchDetails = async () => {
            try {
                const response= await fetch(`http://localhost:8080/iplteams/test`);
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
                    team.map(match => <TeamDetailCard teamName={match.name} match={match}/>)
                    }
                  </div>
        </div>
    </div>
  );
}


