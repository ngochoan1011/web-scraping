import React, { Component } from 'react';
import { getAnalysisData } from '../../services/analysis.service';

export default class AnalysisForm extends Component {
  constructor(props) {
    super(props);
    this.state = { 
      url: '', 
      analysisResults: null, 
      errorMessage: '' 
    };
  }

  handleChangeURL = event => {
    this.setState({ url: event.target.value });
  };

  isUrlValid = userInput => {
    return userInput.match(
      /(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_.~#?&//=]*)/g
    );
  };

  validateAndSubmit = async (event) => {
    event.preventDefault();
    const { url: currentURL } = this.state;
    if (this.isUrlValid(currentURL)) {
      await this.submitURL(currentURL);
    } else {
      this.setState({
        errorMessage: 'Input URL is invalid!'
      });
    }
  };

  submitURL = async analysisURL => {
    try {
      this.setState({
        errorMessage: ''
      });
      const result = await getAnalysisData(analysisURL);
      if (result) {
        this.props.setAnalysisResults(result);
      }
    } catch (error) {
      this.setState({
        errorMessage: error.response.data.message
      })
    }
  };

  resetInputURL = (event) => {
    event.preventDefault();
    this.setState({
      url: '',
      errorMessage: ''
    });
  };

  render() {
    return (
      <div>
        <form>
          <div class="form-row">
            <div class="form-group col-xs-12 col-sm-8 col-md-10">
              <label htmlFor='inputURL' className='sr-only'>
                URL
            </label>
              <input
                type='text'
                value={this.state.url}
                onChange={this.handleChangeURL}
                className='form-control'
                id='inputURL'
                placeholder='Enter URL to analyse'
              />
            </div>
            <div class="form-group col-xs-3 col-sm-2 col-md-1">
              <button
                onClick={this.validateAndSubmit}
                className='btn btn-submit-url'
              >
                Submit
              </button>
            </div>
            <div class="form-group col-xs-9 col-sm-2 col-md-1">
              <button
                onClick={this.resetInputURL}
                type="submit"
                className='btn btn-reset'
              >
                Reset
              </button>
            </div>
            <div class="form-group col-xs-12">
              {this.state.errorMessage && (
                <div class='invalid-feedback'>{this.state.errorMessage}</div>
              )}
            </div>
          </div>
        </form>
      </div>
    );
  }
}
