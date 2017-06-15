import React from 'react';

import './playfield.css';

class PlayField extends React.Component {
  renderBoat = boat => {
    switch (boat) {
      case '5': return '🚣‍♀️';
      case '4': return '⛵';
      case '3': return '🚤';
      case '2': return '🛥';
      case '1': return '️🚢';

      case 'x':
      case 'X':
        return '🔥';

      case 'o': return '💦';

      default: return boat;
    }
  };

  renderCell = cell => {
    return (
      <td className="playfield--cell">{this.renderBoat(cell)}</td>
    );
  };

  renderRow = row => {
    return (
      <tr>
        {row.map(this.renderCell)}
      </tr>
    );
  };

  render() {
    if (!this.props.field) return null;

    return (
      <div className="playfield--container">
        <h2 className="playfield--header">{this.props.title}</h2>
        <table className="playfield--table" cellSpacing="5px">
          <tbody>
            {this.props.field.map(this.renderRow)}
          </tbody>
        </table>
      </div>
    );
  }
}

export default PlayField;
