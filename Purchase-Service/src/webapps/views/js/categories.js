// window.addEventListener('load', function () {
//     if(!this.sessionStorage.getItem("token") || this.sessionStorage.getItem("token-expiry") > new Date().getTime){
//         window.location.href = "http://127.0.0.1:5500/Index.html";
//     }
//   })

const addCategoryButton = document.querySelector('#add-category-button');
const deleteCategory = document.querySelectorAll('.delete-category');

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
                        ${key.title}
                 
                    </div>
                    <div class="category-transactions-${key.categoryId} category-transactions">

                    </div>
                    <button type="click"  class="add-transaction  btn btn-primary " id ="${key.categoryId}"  data-bs-toggle="modal" data-bs-target="#AddTransactionModal" onclick="document.querySelector('.add-transaction-button').id = this.id"> Add Transaction </button>
                </div>
                <div>
                    <button type="click" class ="delete-category " id ="${key.categoryId}" onclick="deleteCategoryID(this.id)"> Delete Category</button> 
              
                </div>`;
                }
//      // <button type="click" class ="edit-category" id ="${key.categoryId}" onclick="editCategoryID(this.id)"> Edit Category</button> 
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
                        
                        transactionList.innerHTML += `
                        <div class="category-transactions-body" id ="${key.transactionId}">
                        Transaction of ${key.amount} - ${key.note}
                        <br>
                        <br>
                        <button type="click" class ="delete-transaction " id ="${key.transactionId}" onclick="deleteTransactionID(this.id ,${categoryIdTransactions})"> Delete Transaction</button>  
                            <button class = "edit-transaction">edit </button>
                        </div>
                     `;
                    }
                                
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
            console.log("coud not create new category error" + response.json())
        }
        else{
            return response.json();
        }
      
       
    }).then(function(data){
     
          console.log("added new category " + data);
          
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
            console.log("coud not create new transaction error" + response.json())
        }
        else{
            return response.json();
        }
      
       
    }).then(function(data){
     
          console.log("added new transaction " + data);
          
        //   window.location.reload();
        
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

