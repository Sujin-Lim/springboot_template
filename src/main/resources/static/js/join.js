
const form = document.getElementById('signUpForm');

$(document).ready(function() {
    $('#signUpForm').submit(function(event) {
    event.preventDefault();

    const userData = {
        userId: document.getElementById('userId').value,
        userPw: document.getElementById('userPw').value,
        userName: document.getElementById('userName').value,
        userEmail: document.getElementById('userEmail').value
    };

    fetch('/api/users/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => {
            if (response.ok) {
                alert('회원가입 성공!');
                window.location.href = 'login.html';
            } else {
                alert('회원가입 실패!');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('오류가 발생했습니다.');
        });
    })
});