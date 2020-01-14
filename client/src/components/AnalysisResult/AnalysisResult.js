import React from 'react';

import './AnalysisResult.css';

const AnalysisResult = ({analysisResults}) => {
  return (
    <div className='table-result'>
      {analysisResults && 
        <div>
          <h1>Page summary information:</h1>
          <ul>
            <li>Page Title: <b>{analysisResults.pageTitle}</b></li>
            <li>HTML version: <b>{analysisResults.htmlVersion}</b></li>
            <li>
              Number of internal links: <b>{analysisResults.noOfInternalLinks}</b>
            </li>
            <li>
              Number of external links: <b>{analysisResults.noOfExternalLinks}</b>
            </li>
            <li>
              Does page contained login form:
                <b>{analysisResults.loginForm ? ' Yes' : ' No'}</b>
            </li>
          </ul>
          <p>Numbers of heading tags:</p>
          <ul>
            {analysisResults.headingTagDTOs.map((element, index) => {
              return (
                <li key={index}>
                  {element.headingTag}: <b>{element.noOfOccurance}</b>
                </li>
              );
            })}
          </ul>
        </div>
      }
    </div>
  );
}
export default AnalysisResult