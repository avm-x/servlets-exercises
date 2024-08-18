function _formatTimeToString(h, m, s){
    return `${h}:${m}:${s}`;
}

// inputParams = currentTime STRING, secondsInterval INT
// output = string with new time
function incrementTime(currTime, secondsInterval){
    timeArr = currTime.split(":");

    seconds = Math.floor( parseInt(timeArr[2]) );
    minutes = parseInt(timeArr[1]);
    hours = parseInt(timeArr[0]);

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


    return _formatTimeToString(hours, minutes, seconds);
}

dHours = document.getElementById("hours");
dMinutes = document.getElementById("minutes");
dSeconds = document.getElementById("seconds");

setInterval(() => {
    incrementedT = incrementTime(currTime, 1).split(":");
    dHours.value = incrementedT[0];
    dMinutes.value = incrementedT[1];
    dSeconds.value = incrementedT[2];

    currTime = incrementedT;
}, 1000);