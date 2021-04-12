Provide input in input.txt file.
First line has the number of test cases (Test Cases: 4)
Then there will be blocks of lines for each test case
In each block:
In the first line, specify the number of outlets in the coffee machine (Number of Outlets: 4)
Next line will have the number of stocks (Items in Stock: 5)
Followed by all those stocks, stock_name: stock_quantity (hot_water: 500)
After that provide number of beverage request (Number of beverage requests: 4)
Followed by that many requests
Each request in 2 lines, first line telling which outlet (Outlet: 1) and second line telling which drink (Drink: Coffee)


Example:
Test Cases: 2
Number of Outlets: 4
Items in Stock: 5
hot_water: 500
hot_milk: 500
ginger_syrup: 100
sugar_syrup: 100
tea_leaves_syrup: 100
Number of beverage requests: 4
Outlet: 1
Drink: Coffee
Outlet: 2
Drink: Green Tea
Outlet: 3
Drink: Tea
Outlet: 1
Drink: Coffee
Number of Outlets: 4
Items in Stock: 5
hot_water: 500
hot_milk: 500
ginger_syrup: 100
sugar_syrup: 100
tea_leaves_syrup: 100
Number of beverage requests: 4
Outlet: 1
Drink: Coffee
Outlet: 2
Drink: Green Tea
Outlet: 3
Drink: Tea
Outlet: 1
Drink: Coffee

Supported items: hot_water | hot_milk | ginger_syrup | sugar_syrup | tea_leaves_syrup | green_mixture
Supported drinks: Coffee | Tea | Green Tea | Black Tea

To add more items or drinks, add its class and update switch case in CoffeeMachine.java