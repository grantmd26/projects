window.onload = homePage;

async function newTeam() {
    teamName = getTeamName();
    managerName = getManagerName();
    const url = `http://localhost:3000/api/team/new?team=${teamName}&manager=${managerName}`;
    const response = fetch(url);
    const data = await response.json();
    teamID = data.teamID;
    viewTeam();
}
