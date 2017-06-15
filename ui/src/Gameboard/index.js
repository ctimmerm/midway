import React from 'react'

import PlayField from '../PlayField';
import fieldRefresher from '../field_refresher';
import './gameboard.css';

const OurPlayField = fieldRefresher(PlayField, '/api/own-grid');
const EnemyPlayField = fieldRefresher(PlayField, '/api/enemy-grid');

class Gameboard extends React.Component {
  render() {
    return (
      <div className="gameboard--container">
        <OurPlayField title="✨ US ✨" />
        <EnemyPlayField title="💩 THEM 💩" />
      </div>
    );
  }
}

export default Gameboard;
