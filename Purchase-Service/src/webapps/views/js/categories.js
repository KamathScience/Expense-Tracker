// window.addEventListener('load', function () {
//     if(!this.sessionStorage.getItem("token") || this.sessionStorage.getItem("token-expiry") > new Date().getTime){
//         window.location.href = "http://127.0.0.1:5500/Index.html";
//     }
//   })

const addCategoryButton = document.querySelector('#add-category-button');



  
 function fetchCategories() {
    let details = fetch('http://localhost:9000/api/categories' , {
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
    if(!response.ok){
        console.log( "has error");
    }else{
        return response.json();
    }
}).then(function(Objectdata){

   console.log(data);

}).catch(function(error){
   console.log(error)
   console.log("inside 400 code category"  )
});

console.log(categoryDetails);

// for(Key key)





// "+"

const categoryName = document.querySelectorAll(".category-name");

const currentlyActiveCategory = document.querySelector(".category-name.active");
    if(currentlyActiveCategory && currentlyActiveCategory!==categoryName) {
        currentlyActiveCategory.classList.toggle("active");
        currentlyActiveCategory.nextElementSibling.style.maxHeight = 0;
    }

categoryName.forEach(categoryName =>{
    categoryName.addEventListener("click", event => {
        categoryName.classList.toggle("active");
        const categoryTransactionBody = categoryName.nextElementSibling;
        if(categoryName.classList.contains("active")){
          categoryTransactionBody.style.maxHeight =   categoryTransactionBody.scrollHeight + "px";
        }
        else{
            categoryTransactionBody.style.maxHeight = 0;
        }
    })
})

const saveNewCategory = async() =>{
    let newCategoryTitle = document.getElementById("category-title").value;
    let newCategoryDescription = document.getElementById("category-description").value;

    fetch('http://localhost:9000/api/categories' , {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        },
        body: JSON.stringify({
            title : newCategoryTitle,
            description : newCategoryDescription,
        })
    }).then(function(response){
        console.log(response);
        if(!response.ok){
            console.log("coud not create new category error" + response.json())
        }
        else{
            return response.json();
        }
      
       
    }).then(function(data){
     
          console.log("added new category " + data);
        
    }).catch(function(error){
        console.log(error)
        console.log("inside 400  " )
    })

}


addCategoryButton.addEventListener('click' , saveNewCategory);

