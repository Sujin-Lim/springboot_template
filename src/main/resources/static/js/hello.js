const userId = sessionStorage.getItem("userId");

$(function() {
    getUserInfo();
});

function getUserInfo() {
    fetch('/api/users/getUserInfo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ userId: userId }),
    })
        .then(response => response.json())
        .then(result => {
            const userName = document.getElementById("userName");
            userName.innerText = result.userName;
            const createDate = result.createDate;
            const createDateElement = document.getElementById("createDate");
            createDateElement.innerText = createDate;
        })
        .catch(error => {
            console.error('Error:', error);
            alert('오류가 발생했습니다.');
        });
}
