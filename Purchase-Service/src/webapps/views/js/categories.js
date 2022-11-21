window.addEventListener('load', function () {
    if(!this.sessionStorage.getItem("token")){
        window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Index.html";
    }
  })

const addCategoryButton = document.querySelector('#add-category-button');
const deleteCategory = document.querySelectorAll('.delete-category');
const transactionModalForm = document.querySelector('.transaction-modal');
const categoryModalForm = document.querySelector('.category-modal');
var modalCategory = document.querySelector('.modal-category');
var modalTransaction = document.querySelector('.modal-transaction');
var modalEditCategory = new bootstrap.Modal(document.querySelector('.modal-edit-category'));
const modalEditTitle = document.getElementById('edit-category-title');
const modalDescriptionTitle = document.getElementById('edit-category-description');


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
   
      window.onload =  fetchCategories().then(function(response){
        if(!response.ok){
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            console.log( "has error");
        }else{
            return response.json();
        }
      }).then(function(data){
        const categoryList = document.querySelector('.category-list');
        let details =  Object.values(data)
                for(let key of details){
                    console.log(key);
                    categoryList.innerHTML += `<div class="category-item">
                    <div class="category-name" id="${key.categoryId}">
                      <h3>  ${key.title}<h3>        <h5 style="margin-left: 10px;">total expense is ${key.totalExpense}<h5>
                 
                    </div>
                    <div class="category-transactions-${key.categoryId} category-transactions">

                    </div>
                    <button type="click"  class="add-transaction  btn btn-primary " id ="${key.categoryId}"  data-bs-toggle="modal" data-bs-target="#AddTransactionModal" onclick="document.querySelector('.add-transaction-button').id = this.id"> Add Transaction </button>
                </div>
                <div>
                    <button type="click" class ="delete-category " id ="${key.categoryId}" onclick="deleteCategoryID(this.id)"> Delete </button> 
                    <button type="click" class ="edit-category" id ="${key.categoryId}" onclick="editCategoryID(this.id)"> Edit </button> 
              
                </div>`;
                }

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
                        fetchTransactionByCategoryID(categoryName.id);
                        categoryTransactionBody.style.maxHeight =   categoryTransactionBody.scrollHeight + "px";
                        }
                        else{
                            categoryTransactionBody.style.maxHeight = 0;
                        }
                    })
                })
                            
    }).catch(function(error){
       console.log(error)
       console.log("inside 400 code category"  )
    });

   
      function fetchTransactionByCategoryID(categoryIdTransactions){
        fetch('http://localhost:9000/api/categories/'+categoryIdTransactions+'/transactions' , {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("token")
            }
        }).then(function(response){
            if(!response.ok){
                if(response.status === 403){
                    alert("session expired, Please Login");
                    window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
                }
                console.log( "has error");
            }else{
                return response.json();
            }
          }).then(function(data){
            const transactionList = document.querySelector('.category-transactions-'+categoryIdTransactions);
            let details =  Object.values(data)
            transactionList.innerHTML = ""
                    for(let key of details){
                        console.log(key);
                        if(key.userId == sessionStorage.getItem("userId")){
                            transactionList.innerHTML += `
                            <div class="category-transactions-body" id ="${key.transactionId}" style ="background-color : rgb(127, 187, 206)">
                            <h5>Transaction of ${key.amount}<h5> <h6> ${key.note}<h6>
                            <button type="click" class ="delete-transaction " id ="${key.transactionId}" onclick="deleteTransactionID(this.id ,${categoryIdTransactions})"> Delete </button>  
                            </div>
                         `;
                        }else{
                            transactionList.innerHTML += `
                            <div class="category-transactions-body" id ="${key.transactionId}" >
                            <h5>Transaction of ${key.amount}<h5> <h6> ${key.note}<h6>
                            <button type="click" class ="delete-transaction " id ="${key.transactionId}" onclick="deleteTransactionID(this.id ,${categoryIdTransactions})"> Delete </button>  
                            </div>
                         `;
                        }
                   
                    }
                             //                            <button class = "edit-transaction">edit </button>
   
        }).catch(function(error){
           console.log(error)
           console.log("inside 400 code category"  )
        });
      }


// "+"



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
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            console.log("coud not create new category error" + response.json())
        }
        else{
            return response.json();
        }
      
       
    }).then(function(data){
        
          console.log("added new category " + data);
          categoryModalForm.reset();
          window.location.reload();
        
    }).catch(function(error){
        console.log(error)
        console.log("inside 400  " )
    })

}


addCategoryButton.addEventListener('click' , saveNewCategory);



function saveNewTransaction(categoryId){
    event.preventDefault();
    let newTransactionAmount = document.getElementById("transaction-amount").value;
    let newTransactionDescription = document.getElementById("transaction-description").value;
    let newTransactionDate = new Date().getTime();

    console.log(newTransactionDate + "new transaction date")

    fetch('http://localhost:9000/api/categories/' + categoryId +'/transactions' , {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        },
        body: JSON.stringify({
            amount : newTransactionAmount,
            note : newTransactionDescription,
            transactionDate : newTransactionDate
        })
    }).then(function(response){
        console.log(response);
        if(!response.ok){
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            console.log("coud not create new transaction error" + response.json())
        }
        else{
            return response.json();
        }
      
       
    }).then(function(data){

          console.log("added new transaction " + data);
          transactionModalForm.reset();
          window.location.reload();
        
    }).catch(function(error){
        console.log(error)
        console.log("inside 400  transactions" )
    })

}

function deleteCategoryID(categoryId){
    console.log(categoryId)
    fetch('http://localhost:9000/api/categories/'+categoryId , {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        }
    }).then(function(response){
        console.log(response);
        if(!response.ok){
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            console.log("coud not delete category error" + response.json())
        }
        else{
            return response.json();
        }
    }).then(function(data){
     
          console.log("deleted new category " + data);
          window.location.reload();
        
    }).catch(function(error){
        console.log(error)
        console.log("inside 400  " )
    })

}

function deleteTransactionID(transactionId, categoryId){
    console.log(categoryId)
    fetch('http://localhost:9000/api/categories/'+categoryId+'/transactions/'+transactionId , {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        }
    }).then(function(response){
        console.log(response);
        if(!response.ok){
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            console.log("coud not delete transaction error" + response.json())
        }
        else{
            return response.json();
        }
    }).then(function(data){
     
          console.log("deleted new transaction " + data);
          window.location.reload();
        
    }).catch(function(error){
        console.log(error)
        console.log("inside 400  transaction" )
    })

}


function editCategoryID(categoryId){
    console.log(categoryId)
    fetch('http://localhost:9000/api/categories/'+categoryId , {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        }
    }).then(function(response){
        console.log(response);
        if(!response.ok){
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            console.log("coud not get category error" + response.json())
        }
        else{
            return response.json();
        }
    }).then(function(data){
        console.log(data)
        let details =  Object.values(data)
        console.log(details)
        document.querySelector('.edit-category-submit-button').id = categoryId
        modalEditTitle.value = details[2];
        modalDescriptionTitle.value = details[3];
        modalEditCategory.show();
        
        
    }).catch(function(error){
        console.log(error)
        console.log("inside 400  " )
    })

}


function saveEditedCategory(categoryId){
let newCategoryTitle = modalEditTitle.value;
let newCategoryDescription = modalDescriptionTitle.value;

fetch('http://localhost:9000/api/categories/'+categoryId , {
    method: 'PUT',
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
        if(response.status === 403){
            alert("session expired, Please Login");
            window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
        }
        console.log("coud not update category error" + response.json())
    }
    else{
        return response.json();
    }
  
}).then(function(data){
      console.log("added new category " + data);
      categoryModalForm.reset();
      window.location.reload();
    
}).catch(function(error){
    console.log(error)
    console.log("inside 400  " )
})

}


