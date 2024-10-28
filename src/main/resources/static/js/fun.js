let stompClient;

function onMessageReceived(message) {
    console.log("subscribe fun finish: "+message)
    const pollResult = JSON.parse(message.body); // Parse the JSON string
    updatePollResult(pollResult);
}

    function updatePollResult(result) {
        // Access the properties of the PollResult object
        document.getElementById('pollResult').innerText = `Received: `+result;
    }

function onConnected() {
    console.log("connection finish")
    console.log("subscribe fun start..")
    stompClient.subscribe('/topic/polls', onMessageReceived);

}

function onError() {
    console.log("Error connection!")
}

function connectWebSocket() {
    console.log("connection start..")
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected, onError);
}

function castVote(option) {
    if (stompClient && stompClient.connected) {
        stompClient.send("/app/votes", {}, option);
        console.log('Vote sent:', option);
    } else {
        console.error('Not connected to the server.');
    }
}

window.onload = function () {
    connectWebSocket();
};