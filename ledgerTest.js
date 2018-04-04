const axios = require('axios')
process.env['NODE_TLS_REJECT_UNAUTHORIZED'] = '0';

var globalPage = 1
findMax(globalPage)

function findMax(page) {
  axios.get('https://monitor.credits.com/api/ledgers/'+page)
  .then(function (r) {
    if (r.data.ledgers.length == 0) {
      console.log(r.data)
      return false
    }
    const max = r.data.ledgers.filter(function (f) {
      return (f.txCount > 300);
    })
    if (max.length == 0) {
      console.log(globalPage)
      findMax(++globalPage)
    } else {
      console.log(max)
      console.log(page)
      findMax(++globalPage)
    }
  })
  .catch(function (err) {
    console.log(err)
})
}
