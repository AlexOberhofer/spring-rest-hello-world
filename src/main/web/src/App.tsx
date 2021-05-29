import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {useEffect} from "react";

function App() {

    useEffect(() => {
        const e = makeAPICall();
    }, [])

    const makeAPICall = async (): Promise<void> => {
        console.log("Making API Call...");
        await axios.post("http://localhost:8080/hello", {name: "REACT",}
        )
            .then(res => {
                const rResp = res.data;
                console.log(rResp);
            });
    }

  return (
    <div className="App">
      <header className="App-header">
        <h1>React + Spring Application Template</h1>
          <div>
              <button onClick={() => {const p = makeAPICall()}}>Call Spring REST API</button>
          </div>
      </header>
    </div>
  );
}

export default App;
