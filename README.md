# currency
1. Caclucate avg value between buy and sale values
2. Add EUR currency to response
3. Parametrize endpoint with bank names
4. Group response by bank name like (use Map):
"data" : "today",
"source" : [
   "privat" : [
         {
           "nameFrom": "USD",
           "nameTo": "UAH",
           "buyValue": 12412.43 
           "sellValue": 45454.4141
           "avgValue": 45415.545
         },
         {
         "nameFrom": "EUR",
          "nameTo": "UAH",
          "buyValue": 12412.43 
          "sellValue": 45454.4141
          "avgValue": 45415.545
         }
     ],
      "mono" : [
         {
           "name": "USD",
           "name": "UAH",
           "value" 12412.43 (avg between buy and sale)
         },
         {
           "name": "EUR",
           "name": "UAH",
           "value" 12412.43 (avg between buy and sale)
         }
     ]
   ]
