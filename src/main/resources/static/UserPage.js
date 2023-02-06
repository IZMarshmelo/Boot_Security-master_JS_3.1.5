const showNavbarInfoUser = (user) => {
    document.getElementById("top-panel").innerHTML =
        `<h5>${user.email} with roles: ${user.rolesToString}</h5>`
}
fetch("/api/user")
    .then(response => response.json())
    .then(data => showNavbarInfoUser(data))
    .catch(error => console.log(error))

let userPageInfo = ' '
const showUserInfo = (user) => {
    const container = document.getElementById("tbody-user")
    userPageInfo +=
        `<tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
            <td>${user.rolesToString}</td>
        </tr>`
    container.innerHTML = userPageInfo
}
fetch("/api/user")
    .then(response => response.json())
    .then(data => showUserInfo(data))
    .catch(error => console.log(error))

