window.addEventListener('load', function () {
    if(!this.sessionStorage.getItem("token")){
        window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Index.html";
    }
  })

var bgC = { 'green': "rgba(75, 192, 192, 0.7)", 'blue': "rgba(54, 162, 235,0.7)", 'violett': "rgba(153, 102, 255, 0.7)", 'red': "rgba(255, 99, 132, 0.7)", 'orange': "rgba(255, 159, 64, 0.7)", 'yellow': "rgba(255, 205, 86, 0.7)",'grey': "rgba(201, 203, 207, 0.7)"};
var backgroundColorCategory = [bgC.red, bgC.orange, bgC.yellow, bgC.green, bgC.blue, bgC.violett, bgC.grey];


    
function transactionData(currentCategoryID){
     let response= fetch('http://localhost:9000/api/categories/'+currentCategoryID+'/transactions' , {
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
                    if(response.status == 400){
                        alert("Please set your budget");
                        window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/BudgetSetup.html";
                    }
                    console.log( "has error");
                }else{
                    console.log( "has NNOOOO error");
                    return response.json();
                }
            });
            return response;
}

    const categoryData = fetch('http://localhost:9000/api/categories/' , {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        }
    }).then(function(response) {
        if(!response.ok){
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            if(response.status == 400){
                alert("Please set your budget");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/BudgetSetup.html";
            }
            console.log( "has error");
        }else{
            return response.json();
        }
    });

    const budgetData = fetch('http://localhost:9000/api/categories/budget/' , {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + sessionStorage.getItem("token")
        }
    }).then(function(response) {
        if(!response.ok){
            if(response.status === 403){
                alert("session expired, Please Login");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/Login.html";
            }
            if(response.status == 400){
                alert("Please set your budget");
                window.location.href = "http://localhost:63342/CurbTheCoins/Purchase-Service/src/webapps/views/BudgetSetup.html";
            }
            console.log( "has error");
        }else{
            
            return response.json();
        }
    });

const makeGraph = async() => {
    let json_data_category = await categoryData;
    let category_details =  Object.values(json_data_category);

    let json_data_budget = await budgetData;
    let budget_details = new Map(Object.entries(json_data_budget))

    let totalBudget = 0;
    let budgetTitle = "";
    let totalSpending = 0;
    var totalcategory = new Array();
    var totalcategorySpending = [];
    var totalSpentByUser = 0;
    var totalSpentByPartner = 0;
    var categoryIdArray = [];
    var categorySpendingUserArray = [];
    var categorySpendingPartnerArray = [];

    for(let key of category_details){
        console.log(key + "category");
        totalSpending +=  key.totalExpense;
        totalcategory.push(key.title);
        totalcategorySpending.push( Number( key.totalExpense) );
        categoryIdArray.push(key.categoryId);
    }

    if(budget_details.has("com.css533.curbthecoins.BudgetProto.hasError")){
        console.log(budget_details + "has error");
    }
    for(var [key,values] of budget_details){
        if(key === 'com.css533.curbthecoins.BudgetProto.budget'){
            totalBudget = values;
        }
        if( key === 'com.css533.curbthecoins.BudgetProto.title'){
            budgetTitle = values;
        }
    }


    for(let id of categoryIdArray ){
        console.log("inside for loop")
        let json_data_transactions =  await transactionData(id).then( function(resopnse){return resopnse});
        let transaction_details =  Object.values(json_data_transactions);

        let userCategorySpending = 0;
        let partnerCategorySpending = 0;
        for(let key of transaction_details){
            if(key.userId+"" === sessionStorage.getItem("userId")){
                    userCategorySpending += key.amount;
                    console.log(key.amount);
            } else{
                    partnerCategorySpending += key.amount;
            }
        }
        totalSpentByUser += userCategorySpending;
        totalSpentByPartner += partnerCategorySpending;
        categorySpendingUserArray.push(userCategorySpending);
        categorySpendingPartnerArray.push(partnerCategorySpending);
      
    }
   
// <-----------------------------------------------category----------------------------------------->
    let DataEC = {
        labels: totalcategory,
        datasets: [{
            backgroundColor: backgroundColorCategory,
            data: totalcategorySpending,
            borderColor: 'rgba(0,0,0,0.1)',
            borderWidth: '1'        
        }]
    };
    
    var optionsEC = {
        plugins: {
            title: { display: true, text: 'Combined Expenses per Category', fontSize: '24', fontFamily: "'Roboto', sans-serif"}
        },
        legend: { display: true, position: 'right', align: 'center'}
    }
    
    var budget_total_chart = document.getElementById('ExpensesByCategory').getContext('2d');
    PieChart1 = new Chart(budget_total_chart, { type: 'doughnut', data: DataEC, options: optionsEC});

// --------------------------------------------------Budget --------------------------------------->

    let DataB = {
        labels: ["Budget Remaining" , "Total Spending"],
        datasets: [{
            backgroundColor: backgroundColorCategory,
            data: [(totalBudget - totalSpending), totalSpending],
            borderColor: 'rgba(0,0,0,0.1)',
            borderWidth: '1'        
        }]
    };
    
    var optionsB = {
        plugins: {
            title: { display: true, text: 'Total Spending', fontSize: '24', fontFamily: "'Roboto', sans-serif"}
        },
        legend: { display: true, position: 'right', align: 'center'},
        rotation: -90,
        circumference: 180

    }
    
    var budget_spent_chart = document.getElementById('budget-spent').getContext('2d');
    DoughnutChart = new Chart(budget_spent_chart, { type: 'doughnut', data: DataB, options: optionsB});

    // --------------------------------------------------user-partner-spending --------------------------------------->

    let DataBUP = {
        labels: ["Your spending" , "partners Spending"],
        datasets: [{
            backgroundColor: backgroundColorCategory,
            data: [totalSpentByUser, totalSpentByPartner],
            borderColor: 'rgba(0,0,0,0.1)',
            borderWidth: '1'        
        }]
    };
    
    var optionsBUP = {
        plugins: {
            title: { display: true, text: 'Individual Spending', fontSize: '24', fontFamily: "'Roboto', sans-serif"}
        },
        legend: { display: true, position: 'right', align: 'center'},
        rotation: -90,
        circumference: 180

    }
    
    var user_partner_spent_chart = document.getElementById('user-partner-spent').getContext('2d');
    DoughnutChart2 = new Chart(user_partner_spent_chart, { type: 'doughnut', data: DataBUP, options: optionsBUP});


    // <-----------------------------------------------category----------------------------------------->
    let DataU = {
        labels: totalcategory,
        datasets: [{
            backgroundColor: backgroundColorCategory,
            data: categorySpendingUserArray,
            borderColor: 'rgba(0,0,0,0.1)',
            borderWidth: '1'        
        }]
    };
    
    var optionsU = {
        plugins: {
            title: { display: true, text: 'Your Expenses per Category', fontSize: '24', fontFamily: "'Roboto', sans-serif"}
        },
        legend: { display: true, position: 'right', align: 'center'}
    }
    
    var user_total_chart = document.getElementById('user-spent').getContext('2d');
    PieChartUser = new Chart(user_total_chart, { type: 'doughnut', data: DataU, options: optionsU});


    // <-----------------------------------------------category----------------------------------------->
    let DataP = {
        labels: totalcategory,
        datasets: [{
            backgroundColor: backgroundColorCategory,
            data: categorySpendingPartnerArray,
            borderColor: 'rgba(0,0,0,0.1)',
            borderWidth: '1'        
        }]
    };
    
    var optionsP = {
        plugins: {
            title: { display: true, text: 'Partners Expenses per Category', fontSize: '24', fontFamily: "'Roboto', sans-serif"}
        },
        legend: { display: true, position: 'right', align: 'center'}
    }
    
    var partner_total_chart = document.getElementById('partner-spent').getContext('2d');
    PieChartPartner = new Chart(partner_total_chart, { type: 'doughnut', data: DataP, options: optionsP});

}

makeGraph();

