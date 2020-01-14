import React, { Component } from 'react';
import jump from 'jump.js';

import { AnalysisForm } from '../../components/AnalysisForm/index';
import { AnalysisResult } from '../../components/AnalysisResult/index';

import './index.css';

export default class HomePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      analysisResults: null
    };
  }

  setAnalysisResults = analysisResults => {
    this.setState({
      analysisResults
    });
  };

  /**
   * Scroll the page to the Report section
   */
  jumpToReportSection = () => {
    jump('#report-section', {
      duration: 1000,
      offset: 60
    });
    document
      .getElementsByClassName('loader-container')[0]
      .classList.remove('show-loader');
  };

  /**
   * Scroll to top of the page
   */
  scrollTop = () => {
    jump('body', {
      duration: 1000,
      offset: 0
    });
  };

  render() {
    return (
      <div>
        <div className='container'>
          <div className='logo-container row'>
            <div className='col-sm-1'>
              <span className='logo'>LOGO</span>
            </div>
          </div>
          <div className='body-container row d-flex justify-content-center'>
            <div className='col-lg-3 col-xxl-3'></div>
            <div className='col-sm-12'>
              <h1 className='page-title text-center'>Web Scraping Project</h1>
              <AnalysisForm setAnalysisResults={this.setAnalysisResults}/>
            </div>
            <div className='col-sm-12'>
              <AnalysisResult analysisResults={this.state.analysisResults} />
            </div>
          </div>
        </div>
        <div className='footer'>
          <button onClick={this.scrollTop} className='button scroll-top-button'>
            <i className='fas fa-arrow-up'></i>
          </button>
          Copyright © 2020, Wizy. All rights reserved. 0.2.0
        </div>
      </div>
    );
  }
};
