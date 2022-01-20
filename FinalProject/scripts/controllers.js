const getCallbacks = function (){
    const callbacks = {};
    callbacks['schedule-button'] = schedulePage;
    callbacks['chat-button'] = chatPage;
    callbacks['roster-button'] = rosterPage;
    callbacks['join-team-button'] = joinTeam;
    callbacks['create-team-button'] = createTeam;
    callbacks['create-button'] = newTeam;
    return callbacks;
   } 

const addController = function (... buttonIDs ){
    const callbacks = getCallbacks ();
    for ( let id of buttonIDs ){
        const button = document . getElementById( id );
        button.addEventListener( 'click' , callbacks[ id ]);
    }
}

const getTeamName = () => document.getElementById('team-name').value;
const getManagerName = () => document.getElementById('manager-name').value;