import {React, useEffect, useState} from 'react';
<<<<<<< HEAD

=======
import{ useParams } from 'react-router-dom';
>>>>>>> 8052f41 (Optimised it for upload on aws)
import { TeamDetailCard } from '../Components/TeamDetailCard'
import './HomePage.scss'




export const HomePage = () => {
  const [team,setTeams]= useState([]);

  useEffect(
    () => {
        const fetchDetails = async () => {
            try {
<<<<<<< HEAD
                const response= await fetch(`${process.env.REACT_APP_ROOT_URL}/iplteams/test`);
=======
                const response= await fetch(`${process.env.REACT_APP_DATA_ROOT_URL}/iplteams/test`);
>>>>>>> 8052f41 (Optimised it for upload on aws)
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
<<<<<<< HEAD
                    team.map(match => <TeamDetailCard key={match.id} teamName={match.name} />)
=======
                    team.map(match => <TeamDetailCard teamName={match.name} match={match}/>)
>>>>>>> 8052f41 (Optimised it for upload on aws)
                    }
                  </div>
        </div>
    </div>
  );
}


