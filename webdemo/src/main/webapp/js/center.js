function renderAuthor(currentUser) {
    document.querySelector('.author-username').value = currentUser.username
    document.querySelector('.author-userSex').value = currentUser.userSex
    document.querySelector('.author-userAge').value = currentUser.userAge
    document.querySelector('.author-userOccupation').value = currentUser.userOccupation
    document.querySelector('.author-userHobby').value = currentUser.userHobby
    document.querySelector('.author-userPoint').value = currentUser.userPoint
    document.querySelector('.author-userClass').value = currentUser.userClass
    document.querySelector('.author-userRegister').value = currentUser.userRegister
}

var xhr = new XMLHttpRequest()
xhr.open('get', '/section-list.json')
xhr.onload = function() {
    //alert(this.responseText);
    console.log(this.responseText)
    var data = JSON.parse(this.responseText)
    if(!data.currentUser){
        // 重定向
        // location = '/login.html'
        location.assign('/login.html')
        return
    }

    renderAuthor(data.currentUser)
}
xhr.send()