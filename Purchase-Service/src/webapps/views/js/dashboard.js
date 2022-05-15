window.addEventListener('load', function () {
    if(!this.sessionStorage.getItem("token") || this.sessionStorage.getItem("token-expiry") > new Date().getTime){
        window.location.href = "http://127.0.0.1:5500/Index.html";
    }
  })


  function fetchBudget() {
    let details = fetch('http://localhost:9000/api/categories/budget/' , {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        }
    });
    return details;
  }

 let budgetDetails = fetchBudget().then(function(response){
         console.log(response + " inside valid code ");
        return response.json();
    }).then(function(data){
        console.log(" inside data ");
        const budget = new Map(Object.entries(data));
        if(budget.has("com.css533.curbthecoins.BudgetProto.hasError")){
            console.log(data + "has error");
        }
        return budget;
    }).catch(function(error){
        console.log(error)
        console.log("inside 400 code "  )
});

 console.log(budgetDetails);

 function fetchCategories() {
    let details = fetch('http://localhost:9000/api/categories/' , {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        }
    });
    return details;
  }

  let categoryDetails = fetchCategories().then(function(response){
    if(response.status != 200){
        console.log( "has error");
    }
   return response.json();
}).then(function(data){
   console.log(" inside data category");
   return new Map(Object.entries(data));
   
}).catch(function(error){
   console.log(error)
   console.log("inside 400 code category"  )
});

console.log(categoryDetails);



