
let timeJson = {
    hours: parseInt(initialTime.split(":")[0]),
    minutes: parseInt(initialTime.split(":")[1]),
    seconds: parseInt(initialTime.split(":")[0]),
}


// inputParams = (timeObj Obj: h, m, s ), secondsInterval INT
// output = (timeObj obj: h, m, s)
function incrementTime(timeObj, secondsInterval){

    let seconds = timeObj.seconds;
    let minutes = timeObj.minutes;
    let hours = timeObj.hours;


    seconds += secondsInterval;


    if(seconds >= 60){
        minutes++;
        seconds = seconds - 60;
    }

    if(minutes == 60){
        hours++;
        minutes = 0;
    }

    if(hours == 24){
        hours = 0;
    }

    const newTimeObj = {
        hours: hours,
        minutes: minutes,
        seconds: seconds,
    }


    return newTimeObj;
}

const dHours = document.getElementById("hours");
const dMinutes = document.getElementById("minutes");
const dSeconds = document.getElementById("seconds");

function updateDomNodes(nodesArr, valuesArr){
    for(let i = 0; i < nodesArr.length; i++){
        nodesArr[i].textContent = valuesArr[i];
    }
}


// display initial time
// increment it
// reassign it.

setInterval(() => {
    updateDomNodes([dHours, dMinutes, dSeconds], [timeJson.hours, timeJson.minutes, timeJson.seconds]);
    timeJson = incrementTime(timeJson, 1);
    }, 1000);