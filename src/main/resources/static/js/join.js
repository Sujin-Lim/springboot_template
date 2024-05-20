const form = document.getElementById('signUpForm');

$(document).ready(function () {
    $('#signUpForm').submit(function (event) {
        event.preventDefault();

        const userData = {
            userId: document.getElementById('userId').value,
            userPw: document.getElementById('userPw').value,
            userName: document.getElementById('userName').value,
            userEmail: document.getElementById('userEmail').value
        };

        fetch('/api/auth/checkId', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        }).then(response => response.text())
            .then(result => {
                if (result === 'OK') {
                    fetch('/api/auth/checkEmail', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(userData)
                    }).then(response => response.text())
                        .then(result => {
                            if (result === 'OK') {
                                // Proceed with sign up
                                fetch('/api/auth/guest', {
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
                            } else {
                                alert('이미 사용 중인 이메일입니다.');
                            }
                        })
                        .catch(error => {
                            console.error('Error:', error);
                            alert('오류가 발생했습니다.');
                        });
                } else {
                    alert('이미 사용 중인 아이디입니다.')
                }
            }).catch(error => {
            console.error('Error:', error);
            alert('오류가 발생했습니다.');
        });
    });
});
