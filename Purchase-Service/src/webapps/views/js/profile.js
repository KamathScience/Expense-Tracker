

window.onload = function loadDetails() {
    let userBody = document.querySelector('.userBody')
    userBody.innerHTML += `
        <h3> Hello ${sessionStorage.userName} !</h3>
    `;

    if(sessionStorage.partnerId > 0){
        userBody.innerHTML += `
            <h2> Yay you are connected with your partner! </h2>
        `;
    }else{
        userBody.innerHTML += `
        <h2> your invite code is = ${sessionStorage.invite_code}<h2>
    `;
    }
}


