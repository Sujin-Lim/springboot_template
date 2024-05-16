
const form = document.getElementById('loginForm');

$(document).ready(function() {
    $('#loginForm').submit(function(event) {
        event.preventDefault();

        const userData = {
            userId: document.getElementById('userId').value,
            userPw: document.getElementById('userPw').value,
        };

        fetch('/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        })
            .then(response => response.text())
            .then(result => {
                if (result === 'OK') {
                    const id = document.getElementById('userId').value;
                    sessionStorage.setItem('userId', id);
                    window.location.href = 'hello.html';
                } else {
                    alert('로그인 실패!');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('오류가 발생했습니다.');
            });
    })
});