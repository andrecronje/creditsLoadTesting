const axios = require('axios')
process.env['NODE_TLS_REJECT_UNAUTHORIZED'] = '0';
const data = {
  hash: "146722dd",
  innerId: "ddca6629-70ef-4cd4-8b55-160a4d781b6f",
  source: "o5QMrpmxrdpPVTsSsqPSoPsoFZtPSZtYTVmSEzjMdes=",
  target: "accXpfvxnZa8txuxpjyPqzBaqYPHqYu2rwn34lL8rjI=",
  amount: 0,
  currency: "cs",
  signatureBASE64: "fWNE4c3tNHnKJ8IgFQtoPrz1EWORsY61i/5S5ZHprm4nYB5chxOAsm+kzN0AaDrHdgg9vI0JIqIUxeC7Xq7JAQ=="
}

for (var i = 0; i < 10; i++) {
  loadTest()
}

function loadTest() {
  axios.post('https://wallet.credits.com/wallet/transactionFlow', data)
  .then(function (r) {
    
  })
  .catch(function (err) {
    console.log(err)
  })  
}