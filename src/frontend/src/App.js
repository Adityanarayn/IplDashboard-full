import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import './App.css';
import { TeamPage } from './Pages/TeamPage';
import {MatchPage } from './Pages/MatchPage';
import { HomePage } from './Pages/HomePage';


function App() {
  return (
    <div className="App">
      
      
      
      
      <Router>
        <Routes>
          
          <Route path="/iplteams/team/:teamName/matches/:year" element={<MatchPage />} />  
          <Route path="/iplteams/team/:teamName" element={<TeamPage />} /> 
          <Route path="/" element={<HomePage />} /> 
          
          {/* this here is used to access the TeamPage element with given url 
            the route path is used to determine where the pattern of the url should be directed to and with what given parameters
            
              the ':' after the team/ is used to indicate that the element coming after the ':' is a parameter */}
         
         
         </Routes>

         
      </Router>
    </div>
  );
}

export default App;
