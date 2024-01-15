import { React } from 'react';
import { Link } from 'react-router-dom';

import './DateComponent.scss';



export const DateComponent = ({teamName}) => {
   
    
    let years=[];
    const startYear= process.env.REACT_APP_DATA_START_YEAR;
    const endYear= process.env.REACT_APP_DATA_END_YEAR;
    for (let i=startYear;i <= endYear ;i++){
        years.push(i);
    }
    

    return (
        <div className='DateComponent'>
        <h2>Years</h2>
          {years.map((year) => (
            <ul>
                <li className='dates'>
                    <Link to={`/iplteams/team/${teamName}/matches/${year}`}>{year}</Link>
                               
                </li>
             </ul>
          ))}
        </div>
      );

}