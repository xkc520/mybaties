// 1. request /json/article_list.json
// 2. update dom tree
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

function renderSectionList(sectionList, topicList) {
    console.log(sectionList)
    var container = document.querySelector('.section')
    console.log(container)

    for (var i in sectionList) {
        var section = sectionList[i]
        console.log(section)

        var html = `<li>` +
             `<div class="板块信息">` +
                ` <h3 class="板块名称">${section.sName}</h3>` +
                 `<div class="版主">版块ID: <span class="版主名称">${section.sID}</span></div>` +
                `<p class="板块说明">${section.sStatement}</p>` +

                ` <div class="点击">` +
                     `<div class="数量">` +
                        ` <div>浏览量</div>` +
                        ` <div>${section.sClickCount}</div>` +
                     `</div>` +
                     `<div>` +
                         `<div>主贴数</div>` +
                         `<div>${section.sTopicCount}</div>` +
                     `</div>` +
                 `</div>` +

                 `<div class="查看详情">` +
                     `<a href="detail.html?sid=${section.sID}" target="_self">查看详情>></a>` +
                 `</div>` +

             `</div></li>`


        container.innerHTML += html
    }
}

function renderTopicList(topicList) {
    console.log(topicList)
    var container = document.querySelector('.topic')
    console.log(container)

    for (var i in topicList) {
        var topic = topicList[i]
        console.log(topic)


        var html = `<li>` +
             `<div class="板块信息">` +
                 `<h3 class="板块名称">${topic.tTopic}</h3>` +
                ` <p class="主贴时间">${topic.tTime}</p>` +

                ` <div class="版主">贴主: <span class="版主名称">${topic.username}</span></div>` +

                ` <p class="板块说明">${topic.tContent}</p>` +

                ` <div class="点击">` +
                   `  <div class="数量">` +
                         `<div>浏览量</div>` +
                        ` <div>${topic.tClickCount}</div>` +
                     `</div>` +
                     `<div>` +
                         `<div>回复</div>` +
                         `<div>${topic.tReplyCount}</div>` +
                     `</div>` +
                ` </div>` +

                `<div class="查看回复" style="display: block; margin: 10px auto 0 auto; align-items: center;
                text-align: center;color: black;user-select: none;cursor: pointer;">` +
                  `<a href="reply.html?tid=${topic.tID}" target="_self" style="color: black;text-decoration:
                  none;font-size: 13px;">查看回复>></a>` +
                `</div>` +
             `</div></li>`


        container.innerHTML += html
    }
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
    renderCount(data.pointCount, data.classCount)
    renderSectionList(data.sectionList)
    renderTopicList(data.topicList)
}
xhr.send()