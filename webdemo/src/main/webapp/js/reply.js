function renderAuthor(currentUser) {
    document.querySelector('.author-username').textContent = currentUser.username
    document.querySelector('.author-userSex').textContent = currentUser.userSex
    document.querySelector('.author-userAge').textContent = currentUser.userAge
    document.querySelector('.author-userOccupation').textContent = currentUser.userOccupation
    document.querySelector('.author-userHobby').textContent = "爱好：" + currentUser.userHobby
}

function renderCount(pointCount, classCount) {
    document.querySelector('.author-userPoint').textContent = pointCount
    document.querySelector('.author-userClass').textContent = classCount
}

function renderDefineTid(tid){
    document.querySelector('.tid').value = tid;
}

function renderReplyList(topic,replyList){
    console.log(replyList)
    var container = document.querySelector('.reply')
    console.log(container)

    // 主贴
    var html = `<li>` +
         `<div class="板块信息1">` +

             `<h3 class="板块名称">${topic.tTopic}</h3>` +
            ` <p class="主贴时间">${topic.tTime}</p>` +

            ` <div class="版主">贴主: <span class="版主名称">${topic.username}</span></div>` +

            ` <p class="板块说明">${topic.tContent}</p>` +

                ` <div class="点击">` +
                   `  <div class="数量">` +
                         `<div>浏览量</div>` +
                        ` <div>${topic.tClickCount}</div>` +
                     `</div>` +
                ` </div>` +

         `</div></li>`


    container.innerHTML += html


    //回帖
    for(var i in replyList){
        var reply = replyList[i]
        console.log(reply)

        var html = `<li>` +
                     `<div class="板块信息">` +
                         `<h3 class="板块名称">${reply.rTopic}</h3>` +
                        ` <p class="主贴时间">${reply.rTime}</p>` +

                        ` <div class="版主"><span class="版主名称">${reply.username}</span></div>` +
                        ` <p class="板块说明">${reply.rContent}</p>` +


                        /*` <div class="点击">` +
                           `  <div class="数量">` +
                                 `<div>点击次数</div>` +
                                ` <div>100</div>` +
                             `</div>` +
                        ` </div>` +*/
                     `</div></li>`

                container.innerHTML += html
    }
}

var xhr = new XMLHttpRequest()
xhr.open('get','/reply-list.json' + location.search)

xhr.onload = function() {
    //alert(this.responseText);
    console.log(this.responseText)
    var data = JSON.parse(this.responseText)
    if(!data.currentUser){
        location.assign('/login.html')
        return
    }

    renderAuthor(data.currentUser)
    renderCount(data.pointCount, data.classCount)
    renderReplyList(data.topic,data.replyList)
    renderDefineTid(data.tid)
}
xhr.send()
