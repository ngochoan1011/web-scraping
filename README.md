Site scraping (React + Java)
=================================

## Objective
​
The objective is to build a web-application that does some analysis of a web-page/URL. The application should show a form with a text-field thus the user can type in the URL of the webpage being analyzed. Additionally to form should contain a button for sending the input to the server as well as to trigger the server-side analysis process. After processing the results should be shown to the user below the form, design and user experience matters, but it's your decision how to represent the results. 
​
The result comprises the following information:
 - What HTML version has the document?
 - What is the page title?
 - How many headings of what level are in the document?
 - How many internal and external links are in the document? 
 - Are there any inaccessible links and how many?
 - Did the page contain a login-form? 
​

In case the URL given by the user is not reachable an error message should appear below the input form. The message should contain the HTTP status-code and some useful error description. 

*Assumption*: A valid link must start with `http://` or `https://`.

## Installation Prerequisites

The backend is set up using Java. 
Frontend is a React app.

- node: 10.16.1
- maven: 3.6.1
- java: 1.8.0_201-b09


## Run the application

MacOS or Linux:

```
sh run_app.sh
```

Windows:

- Create the folder /src/main/resources in Java project
- Run the following commands:

```
cd client;
npm install;
npm run build;
mvn spring-boot:run
```

Visit http://localhost:8080/  

See this demo on running the app: https://youtu.be/k73Dy0w9u00 

## Run tests

```
mvn test
```

## Further works 

* Increase testing coverage.

* Implement the checking for inaccessible links in the backend.

## References 

The implementation for this project is based on these previous works:

* https://github.com/virtualSharif/imscout24

* https://github.com/htimur/site-analysis
