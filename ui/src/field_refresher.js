import React from 'react';
import axios from 'axios';
import Rx from 'rxjs/Rx';

export default (Component, url) => class extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      field: null
    }
  }

  componentDidMount() {
    this.subscription = Rx.Observable
      .interval(50)
      .switchMap(() => Rx.Observable.fromPromise(axios.get(url)))
      .subscribe(response => {
        this.setState({
          field: response.data.grid
        });
      });
  }

  componentWillUnmount() {
    this.subscription.unsubscribe();
  }

  render() {
    return <Component {...this.props} field={this.state.field} />;
  }
};
