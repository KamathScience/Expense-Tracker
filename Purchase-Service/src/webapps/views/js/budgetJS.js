window.addEventListener('load', function () {
    if(!this.sessionStorage.getItem("token") || this.sessionStorage.getItem("token-expiry") < new Date().getTime){
        window.location.href = "http://127.0.0.1:5500/Index.html";
    }
  })

const msg = document.querySelector('.msg');
const my_form = document.getElementById('my-form');


my_form.addEventListener('submit', function(e){
    e.preventDefault();
    let budget = document.getElementById("budget").value
    let title = document.getElementById("title").value
    let description = document.getElementById("description").value
  
    console.log("token is " + sessionStorage.getItem("token"))

    fetch('http://localhost:9000/api/categories/budget/budgetSetup' , {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json', 
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
            
        },
        body: JSON.stringify({
        budget : budget,
        title : title,
        description : description
        })
    }).then(function(response){
        console.log(response)
        return response.json();
       
    }).then(function(data){
        if(data.error){
            console.log(data.error)
            var message =data.error;
            msg.classList.add('error');
            msg.innerHTML = message;
            setTimeout(() => msg.remove(), 3000);
            // TODO: ERROR DISPLAYS ONLY THE FIRST TIME
        }
        else{
                window.location.href = "http://127.0.0.1:5500/Dashboard.html";
        }
    }).catch(function(error){
        console.log(error)
    })

});
