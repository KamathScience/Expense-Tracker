const register_submit = document.querySelector('#register_submit');
const msg = document.querySelector('.msg');
const my_form = document.getElementById('my-form');


my_form.addEventListener('submit', function(e){
    e.preventDefault();
    let firstName = document.getElementById("firstName").value
    let lastName = document.getElementById("lastName").value
    let registerEmail = document.getElementById("registerEmail").value
    let registerPassword = document.getElementById("registerPassword").value
    let code = document.getElementById("registerInviteCode").value

    fetch('http://localhost:9000/api/users/register' , {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
        firstName:firstName,
        lastName : lastName,
            email :registerEmail,
            password : registerPassword,
            inviteCode : code
        })
    }).then(function(response){
        console.log(response);
        return response.json();

    }).then(function(data){
        if(data.error){
            var message =data.error;
            msg.classList.add('error');
            msg.innerHTML = message;
            setTimeout(() => msg.remove(), 3000);
            console.log(data);
            // TODO: ERROR DISPLAYS ONLY THE FIRST TIME
        }
        else{
            sessionStorage.setItem("token",data.token)
            sessionStorage.setItem("token-expiry", new Date().getTime() + (2 * 60 * 60 * 1000))
            sessionStorage.setItem("userName" , data.userName);
            sessionStorage.setItem("userId", data.userId);
            sessionStorage.setItem("partnerId", data.partnerId);
            sessionStorage.setItem("invite_code", data.invite_code);

            if(code === ""){
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/BudgetSetup.html";
            }else{
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Dashboard.html";
            }

        }
    }).catch(function(error){
        console.log(error)
        var message = "errorMessage";
        msg.classList.add('error');
        msg.innerHTML = message;
        setTimeout(() => msg.remove(), 3000);
        console.log("inside 400  " + message )
    })

});

