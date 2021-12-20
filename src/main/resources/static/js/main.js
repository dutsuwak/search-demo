'use strict';

var singleSearchForm = document.querySelector('#singleSearchForm');
var genreSearchForm = document.querySelector('#genreSearchForm');
var rateSearchForm = document.querySelector('#rateSearchForm');

function searchByTitle(pTitle) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            var movie = JSON.parse(this.responseText)
            
            /* Found exact title match */
            if(movie.Name == pTitle){
                document.getElementById("resultsTable").style.display="table";
                document.getElementById("tMovieName").innerHTML = movie.Name;
                document.getElementById("tMovieDate").innerHTML = movie.Date;
                document.getElementById("tMovieRate").innerHTML = movie.Rate;
                document.getElementById("tMovieVotes").innerHTML = movie.Votes;
                document.getElementById("tMovieGenre").innerHTML = movie.Genre;
                document.getElementById("tMovieDuration").innerHTML = movie.Duration;
                document.getElementById("tMovieType").innerHTML = movie.Type;
                document.getElementById("tMovieCertificate").innerHTML = movie.Certificate;
                document.getElementById("tMovieEpisodes").innerHTML = movie.Episodes;
                document.getElementById("tMovieNudity").innerHTML = movie.Nudity;
                document.getElementById("tMovieViolence").innerHTML = movie.Violence;
                document.getElementById("tMovieProfanity").innerHTML = movie.Profanity;
                document.getElementById("tMovieAlcohol").innerHTML = movie.Alcohol;
                document.getElementById("tMovieFrightening").innerHTML = movie.Frightening
            }
            else if(movie.Name.includes(pTitle)){
                suggestMovieName(movie.Name);
            }
        }
    };
    xhttp.open("GET", "/searchByTitle/"+pTitle, true);
    xhttp.send();
}

function suggestMovieName(pMovieName){
    var resultsDiv = document.getElementById("results");
    resultsDiv.innerHTML = "";

    var suggestedMovie = document.createElement("LABEL");
    suggestedMovie.innerHTML = "Did you mean: ";


    var a = document.createElement('a'); 
    var link = document.createTextNode(pMovieName);
        
    // Append the text node to anchor element.
    a.appendChild(link); 
    a.title = pMovieName; 
    a.href = "#"; 

    a.onclick = function() {
        resetForms();
        document.getElementById("searchInput").value = pMovieName;
        searchByTitle(pMovieName);
    }

    resultsDiv.appendChild(suggestedMovie);
    resultsDiv.appendChild(a);
}

function searchByGenre(pGenre) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            var movies = JSON.parse(this.responseText)

            generateTable(movies, pGenre, "byGenreTable");

        }
    };
    xhttp.open("GET", "/searchByGenre/"+pGenre, true);
    xhttp.send();
}

function searchByRate(pLow, pHigh, pGenre) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

            var movies = JSON.parse(this.responseText)

            generateTable(movies, "("+pLow+"-"+pHigh+")", "byRateTable");

        }
    };
    xhttp.open("GET", "/searchByRate/"+pLow+"/"+pHigh+"/"+pGenre, true);
    xhttp.send();
}

function generateTable(pMovies, pQuery, pTableName) {
    //Build an array containing Customer records.
    var tableMovies = new Array();
    tableMovies.push(["Name","Date","Rate","Votes","Genre","Duration","Type",
                      "Certificate","Episodes","Nudity","Violence","Profanity",
                      "Alcohol","Frightening"]);
    
    for (var key in pMovies) {
        if (pMovies.hasOwnProperty(key)) {
            tableMovies.push([pMovies[key].Name, pMovies[key].Date, pMovies[key].Rate,
                              pMovies[key].Votes, pMovies[key].Genre, pMovies[key].Duration,
                              pMovies[key].Type, pMovies[key].Certificate, pMovies[key].Episodes,
                              pMovies[key].Nudity, pMovies[key].Violence, pMovies[key].Profanity,
                              pMovies[key].Alcohol, pMovies[key].Frightening]);
        }
    }

    //Create a HTML Table element.
    var table = document.createElement("TABLE");
    table.border = "1";

    //Get the count of columns.
    var columnCount = tableMovies[0].length;

    //Add the header row.
    var row = table.insertRow(-1);
    for (var i = 0; i < columnCount; i++) {
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = tableMovies[0][i];
        row.appendChild(headerCell);
    }

    //Add the data rows.
    for (var i = 1; i < tableMovies.length; i++) {
        row = table.insertRow(-1);
        for (var j = 0; j < columnCount; j++) {
            var cell = row.insertCell(-1);
            cell.innerHTML = tableMovies[i][j];
        }
    }

    var grTable = document.getElementById(pTableName);
    grTable.innerHTML = "";

    var numTitles = tableMovies.length-1;
    var numTitlesLabel = document.createElement("LABEL");
    numTitlesLabel.innerHTML = "Number of Titles in " + pQuery + ": " + numTitles;

    grTable.appendChild(numTitlesLabel);
    grTable.appendChild(table);

}

function resetForms() {
    document.getElementById("resultsTable").style.display = "none";
    document.getElementById("searchInput").value = "";
    document.getElementById("genreSearchInput").value = "";
    document.getElementById("rateGenreSearchInput").value = "";
    document.getElementById("byGenreTable").innerHTML = "";
    document.getElementById("byRateTable").innerHTML = "";
    document.getElementById("results").innerHTML = "";
}

singleSearchForm.addEventListener('submit', function(event){
    var searchText = document.getElementById("searchInput").value;

    searchByTitle(searchText);
    event.preventDefault();
}, true);

genreSearchForm.addEventListener('submit', function(event){
    var searchText = document.getElementById("genreSearchInput").value;

    searchByGenre(searchText);
    event.preventDefault();
}, true);

rateSearchForm.addEventListener('submit', function(event){
    var rate = document.getElementById("rateSearchInput").value;
    var searchText = document.getElementById("rateGenreSearchInput").value;

    if(searchText==""){
        searchText="none";
    }

    switch(rate) {
        case "0":
            searchByRate(8,11,searchText);
            break;
        case "2":
            searchByRate(6,8,searchText);
            break;
        case "3":
            searchByRate(4,6,searchText);
            break;
        case "4":
            searchByRate(2,4,searchText);
            break;
        case "5":
            searchByRate(0,2,searchText);
            break;
      }
    event.preventDefault();
}, true);