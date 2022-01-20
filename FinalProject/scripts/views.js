const homePage = function () {
    const view = document.getElementById('view');
    const html = `<section>
                    <button id='create-team-button'> Create New Team</button>                    
                    <button id='join-team-button'> Join Team </button>
                </section>`
    view.innerHTML = html;
    addController('join-team-button');
    addController('create-team-button');
}

const createTeam = function() {
    const view = document.getElementById('view');
    const html = `<section>
                    Team Name: <input id='team-name' type=text value=''>
                    Manager's Name: <input id='manager-name' type=text value=''>
                    <button id='create-button'> Create Team </button>
                </section>`
    view.innerHTML= html;
    addController('create-button');
}

const joinTeam = function() {
    const view = document.getElementById('view');
    const html = `<section>
                    Enter Team ID: <input id='team-code' type=text value='Team ID'>
                    <button id='enter-team-id'> Join Team </button>
                </section>`
    view.innerHTML = html;
}

const teamPage = function() {
    const view = document.getElementById('view');
    const html = `<section>
                    <button id='schedule-button'> Schedule</button>
                    <button id='chat-button'> Chat </button>
                    <button id='roster-button'> Roster </button>
                  </section>`
    view.innerHTML = html; 
    addController('schedule-button');
    addController('chat-button');
    addController('roster-button');
}

const schedulePage = function() {
    const view = document.getElementById('view');
    const html = `<section>
                    This is where the schedule will be.
                </section>`
    view.innerHTML = html;
}

const chatPage = function() {
    const view = document.getElementById('view');
    const html = `<section>
                    This is where the chat will be.
                </section>`
    view.innerHTML = html;
}

const rosterPage = function() {
    const view = document.getElementById('view');
    const html = `<section>
                    This is where the roster will be.
                </section>`
    view.innerHTML = html;
}

const viewTeam = function() {
    console.log(teamID, teamName, managerName);
}