import React from 'react';

import Gameboard from './Gameboard';
import './App.css';

class App extends React.Component {
  render() {
    return (
      <div>
        <h1 className="App--header">🚢 Midway 🚀</h1>
        <Gameboard />
      </div>
    );
  }
}

export default App;
